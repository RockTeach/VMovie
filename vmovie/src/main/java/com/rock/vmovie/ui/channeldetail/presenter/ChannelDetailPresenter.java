package com.rock.vmovie.ui.channeldetail.presenter;

import com.rock.teachlibrary.rxevent.RxSubscriber;
import com.rock.vmovie.bean.ChannelDetail;
import com.rock.vmovie.ui.channeldetail.contract.ChannelDetailContract;

public class ChannelDetailPresenter extends ChannelDetailContract.Presenter {
    @Override
    public void getChannelDetailRequest(int page, int size, String cateid) {
        mRxManager.add(mModel.getChannelDetail(page, size, cateid).subscribe(new RxSubscriber<ChannelDetail>(mContext) {
            @Override
            protected void _onNext(ChannelDetail channelDetail) {
                mView.returnChannelDetail(channelDetail);
            }

            @Override
            protected void _onError(String message) {

            }
        }));
    }
}
