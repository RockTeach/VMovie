package com.rock.vmovie.ui.main.contract;

import com.rock.teachlibrary.base.BaseModel;
import com.rock.teachlibrary.base.BasePresenter;
import com.rock.teachlibrary.base.BaseView;
import com.rock.vmovie.bean.TabList;

import rx.Observable;

/**
 * Created by Rock on 16/12/7.
 */

public interface BehindContract {

    interface Model extends BaseModel{
        Observable<TabList> getTabList();
    }

    interface View extends BaseView{

        void returnTabList(TabList tabList);

    }

    static abstract class Presenter extends BasePresenter<Model,View>{

        public abstract void getTabListRequest();

    }

}
