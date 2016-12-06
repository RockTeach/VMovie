package com.rock.vmovie.ui.main.model;

import com.rock.teachlibrary.rxevent.RxSchedulers;
import com.rock.vmovie.api.Api;
import com.rock.vmovie.bean.MovieListBanner;
import com.rock.vmovie.bean.MovieList;
import com.rock.vmovie.ui.main.contract.MovieListContract;

import rx.Observable;

/**
 * Created by Rock on 16/12/5.
 */

public class MovieListModel implements MovieListContract.Model {
    @Override
    public Observable<MovieList> getMovieList(int page, int size) {
        return Api.getDefault().getNewMovieList(Api.getCacheControl(),page,size).compose(RxSchedulers.<MovieList>io_main());
    }

    @Override
    public Observable<MovieListBanner> getMovieBanner() {
        return Api.getDefault().getNewMovieBanner(Api.getCacheControl()).compose(RxSchedulers.<MovieListBanner>io_main());
    }
}
