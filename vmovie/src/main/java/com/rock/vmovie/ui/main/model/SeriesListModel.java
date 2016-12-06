package com.rock.vmovie.ui.main.model;

import com.rock.teachlibrary.rxevent.RxSchedulers;
import com.rock.vmovie.api.Api;
import com.rock.vmovie.bean.SeriesList;
import com.rock.vmovie.ui.main.contract.SeriesListContract;

import rx.Observable;

/**
 * Created by Rock on 16/12/1.
 */

public class SeriesListModel implements SeriesListContract.Model {


    @Override
    public Observable<SeriesList> getSeriesList(int page, int size) {
        return Api.getDefault().getSeriesList(Api.getCacheControl(),page,size).compose(RxSchedulers.<SeriesList>io_main());
    }
}
