package com.rock.teachlibrary.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rock.teachlibrary.rxevent.RxManager;
import com.rock.teachlibrary.utils.TypeUtil;

import butterknife.ButterKnife;

public abstract class BaseFragment<M extends BaseModel,P extends BasePresenter> extends Fragment {

    protected View layout;

    public M mModel;

    public P mPresenter;

    public RxManager mRxManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (layout == null) {
            layout = inflater.inflate(getLayoutResId(),container,false);
        }
        mRxManager = new RxManager();
        ButterKnife.bind(this,layout);
        mModel = TypeUtil.getTypeObject(this,0);
        mPresenter = TypeUtil.getTypeObject(this,1);
        this.initPresenter();
        this.initView();
        return layout;
    }

    public abstract int getLayoutResId();

    protected abstract void initPresenter();

    protected abstract void initView();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mRxManager.clear();
    }
}
