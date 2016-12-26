package com.rock.vmovie.ui.behindtabdetail.contract;

import com.rock.teachlibrary.base.BaseModel;
import com.rock.teachlibrary.base.BasePresenter;
import com.rock.teachlibrary.base.BaseView;
import com.rock.vmovie.bean.BehindDetail;

import rx.Observable;

public interface BehindDetailContract {

    interface Model extends BaseModel{
        Observable<BehindDetail> getBehindDetail(String postid);
    }

    interface View extends BaseView{
        void returnBehindDetail(BehindDetail behindDetail);
    }

    static abstract class Presenter extends BasePresenter<Model,View>{

        public abstract void getBehindDetail(String postid);

    }

}
