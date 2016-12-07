package com.rock.vmovie.ui.main.model;

import com.rock.teachlibrary.rxevent.RxSchedulers;
import com.rock.vmovie.api.Api;
import com.rock.vmovie.bean.TabList;
import com.rock.vmovie.ui.main.contract.BehindContract;

import rx.Observable;

/**
 * Created by Rock on 16/12/7.
 */

public class TabListModel implements BehindContract.Model {
    @Override
    public Observable<TabList> getTabList() {
        return Api.getDefault().getTabList(Api.getCacheControl()).compose(RxSchedulers.<TabList>io_main());
    }
}
