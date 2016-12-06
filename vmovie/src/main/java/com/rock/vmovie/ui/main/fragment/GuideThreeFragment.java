package com.rock.vmovie.ui.main.fragment;

import android.content.Intent;

import com.rock.teachlibrary.base.BaseFragment;
import com.rock.vmovie.R;
import com.rock.vmovie.ui.main.activity.MainActivity;

import butterknife.OnClick;

/**
 * Created by Rock on 16/11/29.
 */

public class GuideThreeFragment extends BaseFragment{

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_guide_three;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initPresenter() {

    }

    @OnClick
    void goMain(){
        Intent intent = new Intent(getActivity(), MainActivity.class);
        getActivity().startActivity(intent);
        getActivity().finish();
    }


}
