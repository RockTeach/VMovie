package com.rock.vmovie.ui.main.presenter;

import com.rock.teachlibrary.rxevent.RxSubscriber;
import com.rock.teachlibrary.utils.LogUtils;
import com.rock.vmovie.bean.BehindList;
import com.rock.vmovie.ui.main.contract.BehindTabContract;

/**
 * Created by Rock on 16/12/7.
 */

public class BehindTabPresenter extends BehindTabContract.Presenter {
    @Override
    public void getBehindListRequest(int page, int size, String cateid) {
        mRxManager.add(mModel.getBehindList(page, size, cateid).subscribe(new RxSubscriber<BehindList>(mContext) {
            @Override
            protected void _onNext(BehindList behindList) {
                mView.returnBehindList(behindList);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(message);
                LogUtils.loge(message);
            }
        }));
    }
}
