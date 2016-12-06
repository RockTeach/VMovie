package com.rock.teachlibrary.base;

import android.content.Context;

import com.rock.teachlibrary.rxevent.RxManager;


public abstract  class BasePresenter<M,V> {

    public Context mContext;

    public M mModel;

    public V mView;

    public RxManager mRxManager = new RxManager();

    public void setVM(V view,M model){
        this.mView = view;
        this.mModel = model;
        this.onStart();
    }

    public void onStart(){

    }

    public void onStop(){
        mRxManager.clear();
    }

}
