package com.rock.vmovie.ui.main.presenter;

import com.rock.teachlibrary.rxevent.RxSubscriber;
import com.rock.vmovie.bean.SeriesList;
import com.rock.vmovie.ui.main.contract.SeriesListContract;

/**
 * Created by Rock on 16/12/1.
 */

public class SeriesListPresenter extends SeriesListContract.Presenter {

    @Override
    public void getSeriesListRequest(int page, int size) {
        mRxManager.add(mModel.getSeriesList(page, size).subscribe(new RxSubscriber<SeriesList>(mContext) {
            @Override
            protected void _onNext(SeriesList seriesList) {
                mView.returnSeriesList(seriesList);
            }

            @Override
            protected void _onError(String message) {

            }
        }));
    }
}
