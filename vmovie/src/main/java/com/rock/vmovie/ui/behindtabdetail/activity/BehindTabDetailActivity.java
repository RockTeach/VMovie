package com.rock.vmovie.ui.behindtabdetail.activity;


import android.annotation.SuppressLint;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.rock.teachlibrary.base.BaseActivity;
import com.rock.teachlibrary.utils.LogUtils;
import com.rock.vmovie.R;
import com.rock.vmovie.R2;
import com.rock.vmovie.bean.BehindDetail;
import com.rock.vmovie.constants.DataParams;
import com.rock.vmovie.ui.behindtabdetail.contract.BehindDetailContract;
import com.rock.vmovie.ui.behindtabdetail.model.BehindDetailModel;
import com.rock.vmovie.ui.behindtabdetail.presenter.BehindDetailPresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class BehindTabDetailActivity extends BaseActivity<BehindDetailModel,BehindDetailPresenter> implements BehindDetailContract.View{

    @BindView(R2.id.teach_behind_tab_detail_web)
    WebView mWeb;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_behind_tab_detail;
    }

    @Override
    protected void initPresenter() {
        mPresenter.setVM(this,mModel);
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void initView() {
        WebSettings settings = mWeb.getSettings();
        settings.setJavaScriptEnabled(true);

        String postid = getIntent().getStringExtra(DataParams.BEHIND_TO_DETAIL_POSTID);
        mPresenter.getBehindDetail(postid);

    }

    @Override
    public void returnBehindDetail(BehindDetail behindDetail) {
        LogUtils.logd("收到幕后数据");
        mWeb.loadUrl(behindDetail.getData().getShare_link().getWeixin());
    }

    @Override
    public void showLoading(String title) {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showErrorTip(String msg) {

    }

    @OnClick(R2.id.teach_behind_tab_detail_back)
    void clickBack(){
        finish();
    }
}
