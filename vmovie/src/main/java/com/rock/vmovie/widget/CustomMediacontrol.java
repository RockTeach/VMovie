package com.rock.vmovie.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

import com.rock.teachlibrary.utils.LogUtils;
import com.rock.vmovie.R;
import com.rock.vmovie.utils.TimeUtil;

public class CustomMediacontrol extends FrameLayout implements Handler.Callback, CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener, View.OnClickListener {

    private static final int UPDATE_PROGRESS = 100;
    private VideoView mVideoView;
    private TextView mCurrentTime;
    private TextView mDuration;
    private SeekBar mProgress;
    private Handler mHandler;

    private HandleScreen mHandleScreen;
    private View mControlView;
    private ProgressBar mLoading;
    private CheckBox mFullScreen;
    private boolean isLandScape;

    public void setHandleScreen(HandleScreen mHandleScreen) {
        this.mHandleScreen = mHandleScreen;
    }

    public CustomMediacontrol(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        mHandler = new Handler(this);
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.activity_movie_detail_video_control,this,true);
        mCurrentTime = (TextView) findViewById(R.id.teach_movie_detail_header_video_current);
        mDuration = (TextView) findViewById(R.id.teach_movie_detail_header_video_duration);
        mProgress = (SeekBar) findViewById(R.id.teach_movie_detail_header_video_progress);
        mProgress.setOnSeekBarChangeListener(this);
        mFullScreen = (CheckBox) findViewById(R.id.teach_movie_detail_header_video_full_screen);
        CheckBox mPlay = (CheckBox) findViewById(R.id.teach_movie_detail_header_video_play);
        mPlay.setOnCheckedChangeListener(this);
        mFullScreen.setOnCheckedChangeListener(this);
        mControlView = findViewById(R.id.teach_movie_detail_header_control);
        mLoading = (ProgressBar) findViewById(R.id.teach_movie_detail_header_video_loading);
        ImageView mBack = (ImageView) findViewById(R.id.teach_movie_detail_header_back);
        mBack.setOnClickListener(this);
    }

    public void setVideoView(VideoView videoView){
        mVideoView = videoView;
        mVideoView.setKeepScreenOn(true);
        ViewGroup parent = (ViewGroup) mVideoView.getParent();
        parent.addView(this);
    }

    public void setDuration(int duration){
        mProgress.setMax(duration);
        mDuration.setText(TimeUtil.parseToMMSS(duration));
        mHandler.sendEmptyMessageDelayed(UPDATE_PROGRESS,1000);
        mLoading.setVisibility(GONE);
        mControlView.setVisibility(VISIBLE);
    }

    @Override
    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case UPDATE_PROGRESS:
                int currentPosition = mVideoView.getCurrentPosition();
                mCurrentTime.setText(TimeUtil.parseToMMSS(currentPosition));
                mProgress.setProgress(currentPosition);
                mHandler.sendEmptyMessageDelayed(UPDATE_PROGRESS,1000);
                break;
        }
        return true;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.teach_movie_detail_header_video_play:
                if (isChecked) {
                    mHandler.removeMessages(UPDATE_PROGRESS);
                    mVideoView.pause();
                }else{
                    mVideoView.start();
                    mHandler.sendEmptyMessageDelayed(UPDATE_PROGRESS,1000);
                }
                break;
            case R.id.teach_movie_detail_header_video_full_screen:
                if (mHandleScreen != null) {
                    if (isChecked) {
                        mHandleScreen.requestOpenFullScreen();
                    }else{
                        mHandleScreen.requestCloseFullScreen();
                    }
                }
                break;
        }
    }

    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        LogUtils.logd("Changed:" + newConfig.orientation);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            isLandScape = true;
        }else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            isLandScape = false;
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        mHandler.removeMessages(UPDATE_PROGRESS);
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        mVideoView.seekTo(seekBar.getProgress());
        mHandler.sendEmptyMessageDelayed(UPDATE_PROGRESS,500);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.teach_movie_detail_header_back:
                if (isLandScape) {
                    mFullScreen.setChecked(false);
                }else{
                    if (mHandleScreen != null) {
                       mHandleScreen.requestClosePage();
                    }
                }
                break;
        }
    }

    public interface HandleScreen{

        void requestOpenFullScreen();

        void requestCloseFullScreen();

        void requestClosePage();

    }
}
