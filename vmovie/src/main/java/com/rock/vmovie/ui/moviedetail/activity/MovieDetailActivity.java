package com.rock.vmovie.ui.moviedetail.activity;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.rock.teachlibrary.base.BaseActivity;
import com.rock.teachlibrary.utils.LogUtils;
import com.rock.vmovie.R;
import com.rock.vmovie.R2;
import com.rock.vmovie.api.ApiService;
import com.rock.vmovie.bean.MovieDetail;
import com.rock.vmovie.ui.moviedetail.contract.MovieDetailContract;
import com.rock.vmovie.ui.moviedetail.model.MovieDetailModel;
import com.rock.vmovie.ui.moviedetail.presenter.MovieDetailPresenter;
import com.rock.vmovie.widget.CustomMediacontrol;
import com.rock.vmovie.widget.CustomVideoView;

import butterknife.BindView;

public class MovieDetailActivity extends BaseActivity<MovieDetailModel,MovieDetailPresenter> implements MovieDetailContract.View, MediaPlayer.OnPreparedListener, CustomMediacontrol.HandleScreen {

    public static final String POSTID = "postid";

    public static final String LIKES = "likes";

    public static final String SHARES = "shares";

    public static final String COMMENTS = "comments";

    @BindView(R2.id.teach_movie_detail_web)
    WebView mWebView;

    @BindView(R2.id.movie_details_lan_like)
    Button mLikes;

    @BindView(R2.id.movie_details_lan_share)
    Button mShares;

    @BindView(R2.id.movie_details_lan_comment)
    Button mComments;

    @BindView(R2.id.movie_details_lan_cache)
    Button mAddCache;

    @BindView(R2.id.teach_movie_detail_header_video)
    CustomVideoView mVideoView;

    @BindView(R2.id.teach_movie_detail_header)
    View mVideoHeader;

    private CustomMediacontrol mCustomMediacontrol;

    private int mVideoHeaderHeight;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_movie_detail;
    }

    @Override
    protected void initPresenter() {
        mPresenter.setVM(this,mModel);
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void initView() {
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient());
        String postid = getIntent().getStringExtra(POSTID);
        mWebView.loadUrl(String.format(ApiService.WEB_URL,postid));
        mLikes.setText(getIntent().getStringExtra(LIKES));
        mShares.setText(getIntent().getStringExtra(SHARES));

        mCustomMediacontrol = new CustomMediacontrol(this);
        mCustomMediacontrol.setVideoView(mVideoView);
        mCustomMediacontrol.setHandleScreen(this);

        LogUtils.logd(String.valueOf(postid));
        mPresenter.getMovieDetailRequest(postid);
    }

    @Override
    public void returnMovieDetail(MovieDetail movieDetail) {
        String playUrl = movieDetail.getData().getPlay_link().getMp4().get(0);
        mVideoView.setOnPreparedListener(this);
        mVideoView.setVideoURI(Uri.parse(playUrl));
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

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
        mCustomMediacontrol.setDuration(mp.getDuration());
    }

    @Override
    public void requestOpenFullScreen() {
        if (mVideoHeaderHeight == 0) {
            mVideoHeaderHeight = mVideoHeader.getLayoutParams().height;
        }
        ViewGroup.LayoutParams layoutParams = mVideoHeader.getLayoutParams();
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT;
        mVideoHeader.setLayoutParams(layoutParams);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    @Override
    public void requestCloseFullScreen() {
        ViewGroup.LayoutParams layoutParams = mVideoHeader.getLayoutParams();
        layoutParams.height = mVideoHeaderHeight;
        mVideoHeader.setLayoutParams(layoutParams);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    public void requestClosePage() {
        if (mVideoView != null) {
            mVideoView.stopPlayback();
        }
        finish();
    }
}
