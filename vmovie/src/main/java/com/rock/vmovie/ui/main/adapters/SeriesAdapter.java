package com.rock.vmovie.ui.main.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rock.teachlibrary.utils.LogUtils;
import com.rock.vmovie.R;
import com.rock.vmovie.R2;
import com.rock.vmovie.bean.SeriesList;
import com.rock.vmovie.ui.login.activity.LoginActivity;
import com.rock.vmovie.utils.UserController;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SeriesAdapter extends RecyclerView.Adapter<SeriesAdapter.ViewHolder> implements View.OnClickListener {

    private final Context mContext;

    private List<SeriesList.SeriesBean> data;

    private LayoutInflater inflater;

    public static final int TYPE_FOOTER = 100;

    private boolean loadMore;
    private RecyclerView mRecyclerView;

    public boolean isLoadMore() {
        return loadMore;
    }

    public void setLoadMore(boolean loadMore) {
        this.loadMore = loadMore;
    }

    public SeriesAdapter(Context context, List<SeriesList.SeriesBean> data){
        inflater = LayoutInflater.from(context);
        mContext = context;
        if (data != null) {
            this.data = data;
        }else{
            this.data = new ArrayList<>();
        }
    }

    public void updateRes(List<SeriesList.SeriesBean> data){
        if (data != null && data.size() != 0) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    public void addRes(List<SeriesList.SeriesBean> data){
        if (data != null && data.size() != 0) {
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() > 0 ? loadMore ? data.size() + 1 : data.size() : 0 : 0;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;
        switch (viewType) {
            case TYPE_FOOTER:
                itemView = inflater.inflate(R.layout.load_more,parent,false);
                break;
            default:
                itemView = inflater.inflate(R.layout.fragment_series_item,parent,false);
                break;
        }
        return new ViewHolder(itemView);
    }

    @Override
    public int getItemViewType(int position) {
        int itemCount = data.size();
        if (position == itemCount){
            return TYPE_FOOTER;
        }
        return super.getItemViewType(position);
    }

    public SeriesList.SeriesBean getItem(int position){
        return data.get(position);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        LogUtils.loge(String.valueOf(itemViewType));
        switch (itemViewType) {
            case TYPE_FOOTER:
                if (loadMore) {
                    holder.itemView.setVisibility(View.VISIBLE);
                }else{
                    holder.itemView.setVisibility(View.GONE);
                }
                break;
            default:
                Glide.with(mContext).load(getItem(position).getImage()).into(holder.image);
                holder.title.setText(getItem(position).getTitle());
                holder.info.setText(String.format("已更新%s集  %s人已订阅",getItem(position).getUpdate_to(),getItem(position).getFollower_num()));
                holder.subscribe.setChecked(!"0".equals(getItem(position).getIsfollow()));
                holder.image.setOnClickListener(this);
                holder.subscribe.setOnClickListener(this);
                break;
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView = recyclerView;
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        mRecyclerView = null;
    }

    @Override
    public void onClick(View v) {
        if (mRecyclerView != null) {
            int position = mRecyclerView.getChildAdapterPosition(getItemView(v));
            LogUtils.loge(String.valueOf(position));
            switch (v.getId()) {
                case R.id.teach_series_image:

                    break;
                case R.id.teach_series_subscribe:
                    if (UserController.isLogin()) {
                        // 做订阅操作

                    }else{
                        CheckBox checkBox = (CheckBox) v;
                        checkBox.setChecked(false);
                        Intent intent = new Intent(mContext, LoginActivity.class);
                        mContext.startActivity(intent);
                    }
                    break;
            }
        }
    }

    public View getItemView(View view){
        View parent = (View) view.getParent();
        if (parent.getLayoutParams() instanceof RecyclerView.LayoutParams) {
            return parent;
        }
        return getItemView(parent);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R2.id.teach_series_image)
        ImageView image;
        @BindView(R2.id.teach_series_title)
        TextView title;
        @BindView(R2.id.teach_series_info)
        TextView info;
        @BindView(R2.id.teach_series_subscribe)
        CheckBox subscribe;

        public ViewHolder(View itemView) {
            super(itemView);
            try {
                ButterKnife.bind(this,itemView);
            }catch (Exception ignored){
                ignored.printStackTrace();
            }

        }
    }

}
