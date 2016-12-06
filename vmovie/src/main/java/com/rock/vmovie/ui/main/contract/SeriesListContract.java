package com.rock.vmovie.ui.main.contract;

import com.rock.teachlibrary.base.BaseModel;
import com.rock.teachlibrary.base.BasePresenter;
import com.rock.teachlibrary.base.BaseView;
import com.rock.vmovie.bean.SeriesList;

import rx.Observable;

/**
 * Created by Rock on 16/12/1.
 */

public interface SeriesListContract {

    interface Model extends BaseModel{
        // 请求获取系列列表
        Observable<SeriesList> getSeriesList(int page,int size);

    }

    interface  View extends BaseView{
        // 返回获取的系列列表
        void returnSeriesList(SeriesList seriesList);

    }

    abstract static class Presenter extends BasePresenter<Model,View>{
        // 发起获取系列列表的请求
        public abstract void getSeriesListRequest(int page,int size);

    }


}
