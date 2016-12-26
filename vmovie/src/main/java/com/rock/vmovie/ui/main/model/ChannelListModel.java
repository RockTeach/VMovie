package com.rock.vmovie.ui.main.model;

import com.rock.teachlibrary.rxevent.RxSchedulers;
import com.rock.vmovie.api.Api;
import com.rock.vmovie.bean.ChannelList;
import com.rock.vmovie.ui.main.contract.ChannelListContract;

import rx.Observable;

/**
 * Created by Rock on 16/12/5.
 */

public class ChannelListModel implements ChannelListContract.Model {
    @Override
    public Observable<ChannelList> getChannelList() {
        return Api.getDefault().getChannelList(Api.getCacheControl()).compose(RxSchedulers.<ChannelList>io_main());
    }
}
