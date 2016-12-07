package com.rock.vmovie.ui.main.contract;

import com.rock.teachlibrary.base.BaseModel;
import com.rock.teachlibrary.base.BasePresenter;
import com.rock.teachlibrary.base.BaseView;
import com.rock.vmovie.bean.BehindList;

import rx.Observable;

/**
 * Created by Rock on 16/12/7.
 */

public interface BehindTabContract {

    interface Model extends BaseModel{

        Observable<BehindList> getBehindList(int page,int size,String cateid);

    }

    interface View extends BaseView{

        void returnBehindList(BehindList behindList);

    }

    static abstract class Presenter extends BasePresenter<Model,View>{

        public abstract void getBehindListRequest(int page,int size,String cateid);

    }


}
