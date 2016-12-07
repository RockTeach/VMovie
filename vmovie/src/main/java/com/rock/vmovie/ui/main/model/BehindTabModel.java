package com.rock.vmovie.ui.main.model;

import com.rock.teachlibrary.rxevent.RxSchedulers;
import com.rock.vmovie.api.Api;
import com.rock.vmovie.bean.BehindList;
import com.rock.vmovie.ui.main.contract.BehindTabContract;

import rx.Observable;

/**
 * Created by Rock on 16/12/7.
 */

public class BehindTabModel implements BehindTabContract.Model {
    @Override
    public Observable<BehindList> getBehindList(int page, int size, String cateid) {
        return Api.getDefault().getBehindList(Api.getCacheControl(),page,size,cateid).compose(RxSchedulers.<BehindList>io_main());
    }
}
