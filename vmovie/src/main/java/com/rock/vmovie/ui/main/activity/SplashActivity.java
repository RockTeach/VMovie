package com.rock.vmovie.ui.main.activity;

import android.content.Intent;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.rock.teachlibrary.base.BaseActivity;
import com.rock.teachlibrary.utils.SharedUtil;
import com.rock.vmovie.R;
import com.rock.vmovie.R2;
import com.rock.vmovie.constants.SharedParams;

import butterknife.BindView;

public class SplashActivity extends BaseActivity implements Animation.AnimationListener {

    @BindView(R2.id.teach_splash_image)
    ImageView image;

    @Override
    protected void doBeforeSetContentView() {
        super.doBeforeSetContentView();
        // 设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1, 1.05f, 1, 1.05f, 0.5f, 0.5f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(2500);
        image.startAnimation(scaleAnimation);
        scaleAnimation.setAnimationListener(this);
    }

    @Override
    protected void initPresenter() {

    }


    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (SharedUtil.getFlag(SharedParams.USE_FLAG)) {
            // 去主页面
            goActivity(MainActivity.class);
        }else{
            // 缓存打开过的标记
            SharedUtil.putFlag(SharedParams.USE_FLAG,true);
            // 去导航页面
            goActivity(GuideActivity.class);
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    private void goActivity(Class cls){
        Intent intent = new Intent(this, cls);
        startActivity(intent);
        finish();
    }

}
