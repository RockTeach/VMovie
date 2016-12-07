package com.rock.vmovie.ui.main.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.rock.vmovie.bean.TabList;
import com.rock.vmovie.ui.main.fragment.BehindTabFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Rock on 16/12/7.
 */

public class TabPagerAdapter extends FragmentPagerAdapter {

    private List<TabList.TabBean> data;

    private Map<String,Fragment> cacheFragment;

    public TabPagerAdapter(FragmentManager fm,List<TabList.TabBean> data) {
        super(fm);
        if (data != null) {
            this.data = data;
        }else{
            this.data = new ArrayList<>();
        }
        cacheFragment = new HashMap<>();
    }

    public void updateRes(List<TabList.TabBean> data){
        if (data != null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    @Override
    public Fragment getItem(int position) {
        String cateid = data.get(position).getCateid();
        Fragment fragment = null;
        if (cacheFragment.containsKey(cateid)) {
            fragment = cacheFragment.get(cateid);
        }else{
            fragment = new BehindTabFragment();
            Bundle bundle = new Bundle();
            bundle.putString(BehindTabFragment.CATE_ID,cateid);
            fragment.setArguments(bundle);
            cacheFragment.put(cateid,fragment);
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
    }
}
