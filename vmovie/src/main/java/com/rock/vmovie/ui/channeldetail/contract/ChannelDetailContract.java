package com.rock.vmovie.ui.channeldetail.contract;

import com.rock.teachlibrary.base.BaseModel;
import com.rock.teachlibrary.base.BasePresenter;
import com.rock.teachlibrary.base.BaseView;
import com.rock.vmovie.bean.ChannelDetail;

import rx.Observable;

/**
 * Created by Rock on 2016/12/26.
 */

public interface ChannelDetailContract {

     interface Model extends BaseModel{

         Observable<ChannelDetail> getChannelDetail(int page,int size,String cateid);

     }

    interface View extends BaseView{

        void returnChannelDetail(ChannelDetail channelDetail);

    }

    static abstract class Presenter extends BasePresenter<Model,View>{

        public abstract void getChannelDetailRequest(int page,int size,String cateid);

    }

}
