package com.rock.vmovie.ui.moviedetail.contract;

import com.rock.teachlibrary.base.BaseModel;
import com.rock.teachlibrary.base.BasePresenter;
import com.rock.teachlibrary.base.BaseView;
import com.rock.vmovie.bean.MovieDetail;

import rx.Observable;

/**
 * Created by Rock on 2016/12/26.
 */

public interface MovieDetailContract {

    interface Model extends BaseModel{

        Observable<MovieDetail> getMovieDetail(String postid);

    }

    interface View extends BaseView{

        void returnMovieDetail(MovieDetail movieDetail);

    }

    static abstract class Presenter extends BasePresenter<Model,View>{

        public abstract void getMovieDetailRequest(String postid);

    }

}
