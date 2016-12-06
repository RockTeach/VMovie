package com.rock.vmovie.ui.main.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.rock.teachlibrary.adapters.CommonFragmentPagerAdapter;
import com.rock.teachlibrary.base.BaseFragment;
import com.rock.teachlibrary.utils.LogUtils;
import com.rock.vmovie.R;
import com.rock.vmovie.R2;
import com.rock.vmovie.constants.EventParams;
import com.rock.vmovie.ui.main.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import rx.functions.Action1;


public class HomeFragment extends BaseFragment implements ViewPager.OnPageChangeListener {

    public static final String TAG = HomeFragment.class.getName();

    @BindView(R2.id.teach_main_home_viewpager)
    ViewPager mViewPager;

    private MainActivity mainActivity;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_main_home;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            mainActivity = (MainActivity) context;
        }
    }

    @Override
    protected void initView() {
        CommonFragmentPagerAdapter adapter = new CommonFragmentPagerAdapter(getChildFragmentManager(), getFragments());
        mViewPager.setAdapter(adapter);
        mViewPager.addOnPageChangeListener(this);
        mRxManager.on(EventParams.MAIN_TO_HOME_CHANGE_VIEWPAGER, new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                mViewPager.setCurrentItem(integer);
            }
        });
    }

    private List<Fragment> getFragments() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new MovieListFragment());
        fragments.add(new ChannelListFragment());
        return fragments;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        LogUtils.loge(String.valueOf(position + positionOffset));
        if (mainActivity != null) {
            mainActivity.viewPagerOffset(position +  positionOffset);
        }
    }

    @Override
    public void onPageSelected(int position) {
        mRxManager.post(EventParams.HOME_TO_MAIN_CHANGE_COLOR,position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
