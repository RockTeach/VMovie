package com.rock.vmovie.ui.main.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.rock.teachlibrary.adapters.CommonFragmentPagerAdapter;
import com.rock.teachlibrary.base.BaseActivity;
import com.rock.teachlibrary.widget.circleindicator.CircleIndicator;
import com.rock.vmovie.R;
import com.rock.vmovie.R2;
import com.rock.vmovie.ui.main.fragment.GuideOneFragment;
import com.rock.vmovie.ui.main.fragment.GuideThreeFragment;
import com.rock.vmovie.ui.main.fragment.GuideTwoFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class GuideActivity extends BaseActivity {

    @BindView(R2.id.teach_guide_viewpager)
    ViewPager mViewPager;

    @BindView(R2.id.teach_guide_indicator)
    CircleIndicator mCircleIndicator;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_guide;
    }

    @Override
    protected void initView() {
        CommonFragmentPagerAdapter adapter = new CommonFragmentPagerAdapter(getSupportFragmentManager(), getFragments());
        mViewPager.setAdapter(adapter);
        mCircleIndicator.setViewPager(mViewPager);
    }

    private List<Fragment> getFragments() {
        List<Fragment> data = new ArrayList<>();
        data.add(new GuideOneFragment());
        data.add(new GuideTwoFragment());
        data.add(new GuideThreeFragment());
        return data;
    }

    @Override
    protected void initPresenter() {

    }
}
