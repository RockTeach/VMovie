package com.rock.vmovie.api;


import com.rock.vmovie.bean.BehindDetail;
import com.rock.vmovie.bean.BehindList;
import com.rock.vmovie.bean.ChannelDetail;
import com.rock.vmovie.bean.ChannelList;
import com.rock.vmovie.bean.MovieDetail;
import com.rock.vmovie.bean.MovieListBanner;
import com.rock.vmovie.bean.MovieList;
import com.rock.vmovie.bean.SeriesList;
import com.rock.vmovie.bean.TabList;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiService {
    // 系列页面接口
//  /apiv3/series/getList?p=1&size=10
    @GET("/apiv3/series/getList")
    Observable<SeriesList> getSeriesList(@Header("Cache-Control") String cacheControl, @Query("p") int p, @Query("size") int size);

    // 主页面的新电影
//  /apiv3/post/getPostByTab?p=1&size=20
    @GET("/apiv3/post/getPostByTab")
    Observable<MovieList> getNewMovieList(@Header("Cache-Control") String cacheControl, @Query("p") int p, @Query("size") int size);

    // 新电影的详情
//    /api/post/view?postid=50759
    @GET("/api/post/view")
    Observable<MovieDetail> getMovieDetail(@Header("Cache-Control") String cacheControl, @Query("postid") String postid);

    // 主页面的新电影的Banner轮播图
//    /apiv3/index/getBanner
    @GET("/apiv3/index/getBanner")
    Observable<MovieListBanner> getNewMovieBanner(@Header("Cache-Control") String cacheControl);

    // 主页面的频道列表
//    /apiv3/cate/getList
    @GET("/apiv3/cate/getList")
    Observable<ChannelList> getChannelList(@Header("Cache-Control") String cacheControl);

    // 频道的详情
//    /apiv3/post/getPostInCate?p=1&size=10&cateid=6
    @GET("/apiv3/post/getPostInCate")
    Observable<ChannelDetail> getChannelDetail(@Header("Cache-Control") String cacheControl,@Query("p") int page,@Query("size") int size,@Query("cateid") String cateid);


    //  幕后主题
//    /apiv3/backstage/getCate
    @GET("/apiv3/backstage/getCate")
    Observable<TabList> getTabList(@Header("Cache-Control") String cacheControl);

    // 幕后各主页面
//    /apiv3/backstage/getPostByCate?p=1&size=10&cateid=47
    @GET("/apiv3/backstage/getPostByCate")
    Observable<BehindList> getBehindList(@Header("Cache-Control") String cacheControl,@Query("p")int page,@Query("size") int size,@Query("cateid")String cateid);

    // 幕后详情
//    /apiv3/post/view?postid=50757
    @GET("/apiv3/post/view")
    Observable<BehindDetail> getBehindDetail(@Header("Cache-Control") String cacheControl,@Query("postid")String postid);

    // WebView显示的详情页面
    String WEB_URL = "http://app.vmoiver.com/%s?qingapp=app_new";

}
