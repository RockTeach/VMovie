package com.rock.vmovie.ui.behindtabdetail.presenter;

import com.rock.teachlibrary.rxevent.RxSubscriber;
import com.rock.vmovie.bean.BehindDetail;
import com.rock.vmovie.ui.behindtabdetail.contract.BehindDetailContract;

/**
 * Created by Rock on 2016/12/26.
 */

public class BehindDetailPresenter extends BehindDetailContract.Presenter {

    @Override
    public void getBehindDetail(String postid) {
        mRxManager.add(mModel.getBehindDetail(postid).subscribe(new RxSubscriber<BehindDetail>(mContext) {
            @Override
            protected void _onNext(BehindDetail behindDetail) {
                mView.returnBehindDetail(behindDetail);
            }

            @Override
            protected void _onError(String message) {

            }
        }));
    }
}
