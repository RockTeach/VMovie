package com.rock.vmovie.ui.main.contract;

import com.rock.teachlibrary.base.BaseModel;
import com.rock.teachlibrary.base.BasePresenter;
import com.rock.teachlibrary.base.BaseView;
import com.rock.vmovie.bean.ChannelList;

import rx.Observable;

/**
 * Created by Rock on 16/12/5.
 */

public interface ChannelListContract {

    interface Model extends BaseModel {

        Observable<ChannelList> getChannelList();
    }

    interface View extends BaseView {

        void returnChannelList(ChannelList channelList);
    }

    abstract class Presenter extends BasePresenter<Model,View>{

        public abstract void getChannelListRequest();

    }

}
