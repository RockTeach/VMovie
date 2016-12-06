package com.rock.vmovie.ui.main.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextSwitcher;
import android.widget.TextView;

import com.rock.teachlibrary.base.BaseActivity;
import com.rock.teachlibrary.utils.LogUtils;
import com.rock.teachlibrary.utils.ToastUitl;
import com.rock.vmovie.R;
import com.rock.vmovie.R2;
import com.rock.vmovie.constants.EventParams;
import com.rock.vmovie.ui.cache.activity.CacheActivity;
import com.rock.vmovie.ui.login.activity.LoginActivity;
import com.rock.vmovie.ui.main.fragment.BehindFragment;
import com.rock.vmovie.ui.main.fragment.HomeFragment;
import com.rock.vmovie.ui.main.fragment.SeriesFragment;
import com.rock.vmovie.ui.search.activity.SearchActivity;
import com.rock.vmovie.ui.set.activity.SetActivity;
import com.rock.vmovie.utils.UserController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import rx.functions.Action1;

public class MainActivity extends BaseActivity {

    private boolean isExit;

    @BindView(R2.id.teach_main_cover)
    View coverLayout;

    @BindView(R2.id.teach_main_cover_close)
    ImageView closeMenu;

    @BindView(R2.id.teach_main_cover_home)
    RadioButton homeRadio;

    @BindView(R2.id.teach_main_cover_series)
    RadioButton seriesRadio;

    @BindView(R2.id.teach_main_cover_behind)
    RadioButton behindRadio;

    @BindView(R2.id.teach_main_title)
    TextView mainTitle;

    @BindView(R2.id.teach_main_home_title)
    View mainHomeTitle;

    @BindView(R2.id.teach_main_first_page_channel)
    TextView channel;

    @BindView(R2.id.teach_main_first_page_indicator)
    View indicator;

    private Fragment mShowFragment;


    @BindView(R2.id.teach_main_first_page_new)
    TextSwitcher mSwitcher;

    private int channelLeft;


    @Override
    public int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        switchPage(HomeFragment.TAG);
        mRxManager.on(EventParams.HOME_TO_MAIN_CHANGE_COLOR, new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                // Switcher中的Child
                TextView childZero = (TextView) mSwitcher.getChildAt(0);
                TextView childOne = (TextView) mSwitcher.getChildAt(1);
                switch (integer) {
                    case 0:
                        channel.setTextColor(getResources().getColor(R.color.color_gray_9));
                        childZero.setTextColor(getResources().getColor(R.color.color_white));
                        childOne.setTextColor(getResources().getColor(R.color.color_white));
                        break;
                    case 1:
                        channel.setTextColor(getResources().getColor(R.color.color_white));
                        childZero.setTextColor(getResources().getColor(R.color.color_gray_9));
                        childOne.setTextColor(getResources().getColor(R.color.color_gray_9));
                        break;
                }
            }
        });
        mRxManager.on(EventParams.MOVIE_TO_MAIN_CHANGE_UP_DATE, new Action1<String>() {
            @Override
            public void call(String s) {
                LogUtils.loge("up->"+s);
                mSwitcher.setInAnimation(mContext,R.anim.new_title_previous_in);
                mSwitcher.setOutAnimation(mContext,R.anim.new_title_previous_out);
                mSwitcher.setText(s);
            }
        });
        mRxManager.on(EventParams.MOVIE_TO_MAIN_CHANGE_DOWN_DATE, new Action1<String>() {
            @Override
            public void call(String s) {
                LogUtils.loge("down->"+s);
                mSwitcher.setInAnimation(mContext,R.anim.new_title_next_in);
                mSwitcher.setOutAnimation(mContext,R.anim.new_title_next_out);
                mSwitcher.setText(s);
            }
        });

    }

    @Override
    protected void initPresenter() {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (coverLayout.getVisibility() == View.VISIBLE) {
                coverLayout.setVisibility(View.GONE);
                return true;
            }
            if (!isExit){
                isExit = true;
                ToastUitl.showShort(R.string.press_exit);
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        isExit = false;
                    }
                },2000);
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @OnClick(R2.id.teach_main_cover_close)
    void closeMenu(){
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(closeMenu, "scaleX", 1, 1.2f, 0.8f, 0);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(closeMenu, "scaleY", 1, 1.2f, 0.8f, 0);
        animatorSet.play(animatorX).with(animatorY);
        animatorSet.setDuration(400);
        animatorSet.start();
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                coverLayout.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    @OnClick(R2.id.teach_main_home)
    void openMenu(){
        coverLayout.setVisibility(View.VISIBLE);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(closeMenu, "scaleX", 0, 1f, 1.2f, 1);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(closeMenu, "scaleY", 0, 1f, 1.2f, 1);
        animatorSet.play(animatorX).with(animatorY).after(200);
        animatorSet.start();
        homeRadio.startAnimation(AnimationUtils.loadAnimation(this,R.anim.home_in));
        seriesRadio.startAnimation(AnimationUtils.loadAnimation(this,R.anim.series_in));
        behindRadio.startAnimation(AnimationUtils.loadAnimation(this,R.anim.behind_in));
    }

    @OnClick(value = {R2.id.teach_main_cover_behind,R2.id.teach_main_cover_series,R2.id.teach_main_cover_home})
    void onRadioClick(){
        coverLayout.setVisibility(View.GONE);
    }

    @OnCheckedChanged(value = {R2.id.teach_main_cover_home,R2.id.teach_main_cover_series,R2.id.teach_main_cover_behind})
    void onCheckedChanged(CompoundButton view,boolean isChecked){
        if (isChecked) {
            switch (view.getId()) {
                case R.id.teach_main_cover_home:
                    switchPage(HomeFragment.TAG);
                    mainHomeTitle.setVisibility(View.VISIBLE);
                    break;
                case R.id.teach_main_cover_series:
                    switchPage(SeriesFragment.TAG);
                    mainHomeTitle.setVisibility(View.GONE);
                    mainTitle.setText("系列");
                    break;
                case R.id.teach_main_cover_behind:
                    switchPage(BehindFragment.TAG);
                    mainHomeTitle.setVisibility(View.GONE);
                    mainTitle.setText("幕后");
                    break;
            }
        }
    }

    private void switchPage(String fragmentTag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        if (mShowFragment != null) {
            transaction.hide(mShowFragment);
        }
        mShowFragment = fm.findFragmentByTag(fragmentTag);
        if (mShowFragment != null) {
            transaction.show(mShowFragment);
        }else{

            try {
                mShowFragment = (Fragment) Class.forName(fragmentTag).newInstance();
                transaction.add(R.id.teach_main_container,mShowFragment,fragmentTag);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
        transaction.commit();
    }

    public void viewPagerOffset(float offset){
        if (channelLeft == 0)
            channelLeft = channel.getLeft();
        indicator.setTranslationX(offset * channelLeft);

    }

    @OnClick(value = {R2.id.teach_main_cover_subscribe,R2.id.teach_main_cover_likes,R2.id.teach_main_cover_icon,R2.id.teach_main_cover_name,R2.id.teach_main_cover_message})
    void onCoverClickCheckLogin(View v){
        if (UserController.isLogin()) {
            switch (v.getId()) {
                case R.id.teach_main_cover_subscribe:

                    break;
                case R.id.teach_main_cover_likes:

                    break;
                case R.id.teach_main_cover_icon:

                    break;
                case R.id.teach_main_cover_name:

                    break;
                case R.id.teach_main_cover_message:

                    break;
            }
        }else{
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
    }

    @OnClick(value = {R2.id.teach_main_cover_set,R2.id.teach_main_cover_cache,R2.id.teach_main_search})
    void onClick(View view){
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.teach_main_cover_set:
                intent.setClass(this, SetActivity.class);
                break;
            case R.id.teach_main_cover_cache:
                intent.setClass(this, CacheActivity.class);
                break;
            case R.id.teach_main_search:
                intent.setClass(this, SearchActivity.class);
                break;
        }
        startActivity(intent);
    }

    @OnClick(value = {R2.id.teach_main_first_page_channel,R2.id.teach_main_first_page_new})
    void onIndicatorClick(View view){
        switch (view.getId()) {
            case R.id.teach_main_first_page_new:
                mRxManager.post(EventParams.MAIN_TO_HOME_CHANGE_VIEWPAGER,0);
                break;
            case R.id.teach_main_first_page_channel:
                mRxManager.post(EventParams.MAIN_TO_HOME_CHANGE_VIEWPAGER,1);
                break;
        }
    }

}
