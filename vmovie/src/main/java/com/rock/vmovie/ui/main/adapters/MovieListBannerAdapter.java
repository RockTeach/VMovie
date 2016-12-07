package com.rock.vmovie.ui.main.adapters;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.rock.vmovie.bean.MovieListBanner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rock on 16/12/7.
 */

public class MovieListBannerAdapter extends PagerAdapter {

    private List<MovieListBanner.MoviewBannerBean> data;

    public MovieListBannerAdapter(List<MovieListBanner.MoviewBannerBean> data){
        if (data != null) {
            this.data = data;
        }else{
            this.data = new ArrayList<>();
        }
    }

    public void updateRes(List<MovieListBanner.MoviewBannerBean> data){
        if (data != null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }


    @Override
    public int getCount() {
        return data != null ? data.size() * 200 : 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    public MovieListBanner.MoviewBannerBean getItem(int position){
        return data.get(position % data.size());
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(container.getContext());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        Glide.with(container.getContext()).load(getItem(position).getImage()).into(imageView);
        container.addView(imageView);
        return imageView;
    }
}
