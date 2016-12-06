package com.rock.teachlibrary.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Rock on 16/11/29.
 */

public class CommonFragmentPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> data;

    public CommonFragmentPagerAdapter(FragmentManager fm,List<Fragment> data) {
        super(fm);
        this.data = data;
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data != null ? data.size() : 0;
    }
}
