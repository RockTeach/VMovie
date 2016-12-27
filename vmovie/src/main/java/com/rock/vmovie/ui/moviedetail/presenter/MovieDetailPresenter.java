package com.rock.vmovie.ui.moviedetail.presenter;

import com.rock.teachlibrary.rxevent.RxSubscriber;
import com.rock.teachlibrary.utils.LogUtils;
import com.rock.vmovie.bean.MovieDetail;
import com.rock.vmovie.ui.moviedetail.contract.MovieDetailContract;

/**
 * Created by Rock on 2016/12/26.
 */

public class MovieDetailPresenter extends MovieDetailContract.Presenter {
    @Override
    public void getMovieDetailRequest(String postid) {
        mRxManager.add(mModel.getMovieDetail(postid).subscribe(new RxSubscriber<MovieDetail>(mContext) {
            @Override
            protected void _onNext(MovieDetail movieDetail) {
                mView.returnMovieDetail(movieDetail);
            }

            @Override
            protected void _onError(String message) {
                LogUtils.loge(message);
            }
        }));

    }
}
