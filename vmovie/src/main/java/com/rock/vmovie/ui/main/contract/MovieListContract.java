package com.rock.vmovie.ui.main.contract;

import com.rock.teachlibrary.base.BaseModel;
import com.rock.teachlibrary.base.BasePresenter;
import com.rock.teachlibrary.base.BaseView;
import com.rock.vmovie.bean.MovieListBanner;
import com.rock.vmovie.bean.MovieList;

import rx.Observable;

/**
 * Created by Rock on 16/12/5.
 */

public interface MovieListContract {

    interface Model extends BaseModel {

        Observable<MovieList> getMovieList(int page, int size);

        Observable<MovieListBanner> getMovieBanner();

    }

    interface View extends BaseView {

        void returnNewMovieList(MovieList movieList);

        void returnNewMovieBanner(MovieListBanner movieBanner);

    }

    static abstract class Presenter extends BasePresenter<Model, View> {

        public abstract void getNewMovieListRequest(int page, int size);

        public abstract void getNewMoviewBanner();

    }


}
