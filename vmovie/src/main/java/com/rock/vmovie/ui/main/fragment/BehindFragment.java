package com.rock.vmovie.ui.main.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.rock.teachlibrary.base.BaseFragment;
import com.rock.teachlibrary.utils.LogUtils;
import com.rock.vmovie.R;
import com.rock.vmovie.R2;
import com.rock.vmovie.bean.TabList;
import com.rock.vmovie.ui.main.adapters.TabPagerAdapter;
import com.rock.vmovie.ui.main.contract.BehindContract;
import com.rock.vmovie.ui.main.model.TabListModel;
import com.rock.vmovie.ui.main.presenter.TabListPresenter;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Rock on 16/11/30.
 */

public class BehindFragment extends BaseFragment<TabListModel,TabListPresenter> implements BehindContract.View{

    public static final String TAG = BehindFragment.class.getName();

    @BindView(R2.id.teach_behind_tablayout)
    TabLayout tabLayout;

    @BindView(R2.id.teach_behind_viewpager)
    ViewPager viewpager;
    private TabPagerAdapter adapter;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_main_behind;
    }

    @Override
    protected void initPresenter() {
        mPresenter.setVM(this,mModel);
    }

    @Override
    protected void initView() {
        adapter = new TabPagerAdapter(getChildFragmentManager(),null);
        viewpager.setAdapter(adapter);

        LogUtils.loge("获取Tab列表");
        mPresenter.getTabListRequest();
    }

    @Override
    public void returnTabList(TabList tabList) {
        List<TabList.TabBean> tabBeanList = tabList.getData();
        for (int i = 0; i < tabBeanList.size() ; i++) {
            tabLayout.addTab(tabLayout.newTab().setText(tabBeanList.get(i).getCatename()));
        }
        adapter.updateRes(tabBeanList);
        // 互相绑定
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewpager));
        viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

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
}
