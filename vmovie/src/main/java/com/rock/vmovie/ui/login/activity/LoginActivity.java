package com.rock.vmovie.ui.login.activity;

import com.rock.teachlibrary.base.BaseActivity;
import com.rock.vmovie.R;
import com.rock.vmovie.R2;

import butterknife.OnClick;

public class LoginActivity extends BaseActivity {


    @Override
    public int getLayoutResId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initView() {

    }

    @OnClick(R2.id.login_back)
    void clickBack(){
        finish();
    }


}
