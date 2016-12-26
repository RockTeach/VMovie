package com.rock.vmovie.ui.behindtabdetail.model;

import com.rock.teachlibrary.rxevent.RxSchedulers;
import com.rock.vmovie.api.Api;
import com.rock.vmovie.bean.BehindDetail;
import com.rock.vmovie.ui.behindtabdetail.contract.BehindDetailContract;

import rx.Observable;

/**
 * Created by Rock on 2016/12/26.
 */

public class BehindDetailModel implements BehindDetailContract.Model{
    @Override
    public Observable<BehindDetail> getBehindDetail(String postid) {
        return Api.getDefault().getBehindDetail(Api.getCacheControl(),postid).compose(RxSchedulers.<BehindDetail>io_main());
    }
}
