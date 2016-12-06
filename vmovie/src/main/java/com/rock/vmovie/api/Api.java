package com.rock.vmovie.api;

import com.rock.teachlibrary.utils.NetWorkUtil;
import com.rock.vmovie.BuildConfig;
import com.rock.vmovie.VMovieApp;

import java.io.File;
import java.io.IOException;
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

    private ApiService service;

    private static Api sApi;

    private static final int READ_TIME_OUT = 10 * 1000;

    private static final int CONNECT_TIME_OUT = 10 * 1000;

    private static final long CACHE_STALE_SEC = 60 * 60 * 24 * 2;

    private static final String CACHE_CONTROL_CACHE = "only-if-cached, max-stale=" + CACHE_STALE_SEC;

    private static final String CACHE_CONTROL_AGE = "max-age=5";

    private Api() {
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


        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BuildConfig.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        service = retrofit.create(ApiService.class);
    }


    public static ApiService getDefault() {
        if (sApi == null) {
            synchronized (Api.class) {
                sApi = new Api();
            }
        }
        return sApi.service;
    }


    public static String getCacheControl() {
        return NetWorkUtil.isNetConnected(VMovieApp.getContext()) ? CACHE_CONTROL_AGE : CACHE_CONTROL_CACHE;
    }

}
