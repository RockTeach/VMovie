package com.rock.vmovie.ui.channeldetail.model;

import com.rock.teachlibrary.rxevent.RxSchedulers;
import com.rock.vmovie.api.Api;
import com.rock.vmovie.bean.ChannelDetail;
import com.rock.vmovie.ui.channeldetail.contract.ChannelDetailContract;

import rx.Observable;

/**
 * Created by Rock on 2016/12/26.
 */

public class ChannelDetailModel implements ChannelDetailContract.Model {

    @Override
    public Observable<ChannelDetail> getChannelDetail(int page, int size, String cateid) {
        return Api.getDefault().getChannelDetail(Api.getCacheControl(),page,size,cateid).compose(RxSchedulers.<ChannelDetail>io_main());
    }
}
