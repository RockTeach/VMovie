package com.rock.vmovie.ui.moviedetail.model;

import com.rock.vmovie.api.Api;
import com.rock.vmovie.bean.MovieDetail;
import com.rock.vmovie.ui.moviedetail.contract.MovieDetailContract;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Rock on 2016/12/26.
 */

public class MovieDetailModel implements MovieDetailContract.Model {

    @Override
    public Observable<MovieDetail> getMovieDetail(String postid) {
        return Api.getService(Api.SPECIAL_SERVER).getMovieDetail(Api.getCacheControl(),postid).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
