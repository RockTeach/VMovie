package com.rock.vmovie.ui.main.presenter;

import com.rock.teachlibrary.rxevent.RxSubscriber;
import com.rock.vmovie.bean.ChannelList;
import com.rock.vmovie.ui.main.contract.ChannelListContract;

/**
 * Created by Rock on 16/12/5.
 */

public class ChannelListPresenter extends ChannelListContract.Presenter {

    @Override
    public void getChannelListRequest() {
        mRxManager.add(mModel.getChannelList().subscribe(new RxSubscriber<ChannelList>(mContext) {
            @Override
            protected void _onNext(ChannelList channelList) {
                mView.returnChannelList(channelList);
            }

            @Override
            protected void _onError(String message) {

            }
        }));
    }
}
