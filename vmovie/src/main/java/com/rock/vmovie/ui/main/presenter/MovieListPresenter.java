package com.rock.vmovie.ui.main.presenter;

import com.rock.teachlibrary.rxevent.RxSubscriber;
import com.rock.vmovie.bean.MovieListBanner;
import com.rock.vmovie.bean.MovieList;
import com.rock.vmovie.ui.main.contract.MovieListContract;

/**
 * Created by Rock on 16/12/5.
 */

public class MovieListPresenter extends MovieListContract.Presenter {
    @Override
    public void getNewMovieListRequest(int page, int size) {
        mRxManager.add(mModel.getMovieList(page,size).subscribe(new RxSubscriber<MovieList>(mContext) {
            @Override
            protected void _onNext(MovieList movieList) {
                mView.returnNewMovieList(movieList);
            }

            @Override
            protected void _onError(String message) {

            }
        }));
    }

    @Override
    public void getNewMoviewBanner() {
        mRxManager.add(mModel.getMovieBanner().subscribe(new RxSubscriber<MovieListBanner>(mContext) {
            @Override
            protected void _onNext(MovieListBanner movieBanner) {
                mView.returnNewMovieBanner(movieBanner);
            }

            @Override
            protected void _onError(String message) {

            }
        }));
    }
}
