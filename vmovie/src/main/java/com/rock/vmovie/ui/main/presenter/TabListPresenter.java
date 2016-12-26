package com.rock.vmovie.ui.main.presenter;

import com.rock.teachlibrary.rxevent.RxSubscriber;
import com.rock.teachlibrary.utils.LogUtils;
import com.rock.vmovie.bean.TabList;
import com.rock.vmovie.ui.main.contract.BehindContract;

/**
 * Created by Rock on 16/12/7.
 */

public class TabListPresenter extends BehindContract.Presenter {
    @Override
    public void getTabListRequest() {
        mRxManager.add(mModel.getTabList().subscribe(new RxSubscriber<TabList>(mContext) {
            @Override
            protected void _onNext(TabList tabList) {
                mView.returnTabList(tabList);
            }

            @Override
            protected void _onError(String message) {
                mView.showErrorTip(message);
                LogUtils.logd(message);
            }
        }));
    }
}
