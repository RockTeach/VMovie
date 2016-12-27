package com.rock.vmovie.api;

import android.util.SparseArray;

import com.rock.teachlibrary.utils.NetWorkUtil;
import com.rock.vmovie.BuildConfig;
import com.rock.vmovie.VMovieApp;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class Api {

    private static final int READ_TIME_OUT = 10 * 1000;

    private static final int CONNECT_TIME_OUT = 10 * 1000;

    private static final long CACHE_STALE_SEC = 60 * 60 * 24 * 2;

    public static final String CACHE_CONTROL_CACHE = "only-if-cached, max-stale=" + CACHE_STALE_SEC;

    public static final String CACHE_CONTROL_AGE = "max-age=5";

    public static final int DEFAULT_SERVER = 0;

    public static final int SPECIAL_SERVER = 1;

    public static SparseArray<ApiService> mServers = new SparseArray<>(2);

    private Api() {
        this(DEFAULT_SERVER);
    }

    private Api(int type) {
        //缓存
        File cacheFile = new File(VMovieApp.getContext().getCacheDir(), "cache");
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 100); //100Mb
        //增加头部信息
        Interceptor headerInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request build = chain.request().newBuilder()
                        .addHeader("Content-Type", "application/json")
                        .build();
                return chain.proceed(build);
            }
        };


        Interceptor mRewriteCacheControlInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (!NetWorkUtil.isNetConnected(VMovieApp.getContext())) {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }
                Response originalResponse = chain.proceed(request);
                if (NetWorkUtil.isNetConnected(VMovieApp.getContext())) {
                    String cacheControl = request.cacheControl().toString();
                    return originalResponse.newBuilder()
                            .removeHeader("Pragma")
                            .header("Cache-Control", cacheControl)
                            .build();
                } else {
                    return originalResponse.newBuilder()
                            .removeHeader("Pragma")
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + CACHE_STALE_SEC)
                            .build();
                }
            }
        };
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(READ_TIME_OUT, TimeUnit.MILLISECONDS)
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
                .addInterceptor(mRewriteCacheControlInterceptor)
                .addNetworkInterceptor(mRewriteCacheControlInterceptor)
                .addInterceptor(headerInterceptor)
                .cache(cache)
                .build();
        String baseUrl = BuildConfig.BaseUrl;
        switch (type) {
            case SPECIAL_SERVER:
                baseUrl = BuildConfig.BaseUrlSpecial;
                break;
        }
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        switch (type) {
            case SPECIAL_SERVER:
                mServers.put(SPECIAL_SERVER, retrofit.create(ApiService.class));
                break;
            default:
                mServers.put(DEFAULT_SERVER, retrofit.create(ApiService.class));
        }

    }


    public static ApiService getDefault() {
        return getService(DEFAULT_SERVER);
    }

    public static ApiService getService(int type) {
        if (mServers.get(type) == null) {
            synchronized (Api.class) {
                if (mServers.get(type) == null) {
                    new Api(type);
                }
            }
        }
        return mServers.get(type);
    }


    public static String getCacheControl() {
        return NetWorkUtil.isNetConnected(VMovieApp.getContext()) ? CACHE_CONTROL_AGE : CACHE_CONTROL_CACHE;
    }

}
