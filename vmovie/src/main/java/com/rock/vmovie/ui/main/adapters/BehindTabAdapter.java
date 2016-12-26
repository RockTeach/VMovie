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
import com.rock.vmovie.bean.BehindList;
import com.rock.vmovie.bean.SeriesList;
import com.rock.vmovie.ui.behindtabdetail.activity.BehindTabDetailActivity;
import com.rock.vmovie.ui.login.activity.LoginActivity;
import com.rock.vmovie.utils.UserController;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class BehindTabAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    private final Context mContext;

    private List<BehindList.BehindBean> data;

    private LayoutInflater inflater;

    private static final int TYPE_FOOTER = 100;

    private boolean loadMore;

    private RecyclerView mRecyclerView;

    private boolean haveMore = true;

    public boolean isHaveMore() {
        return haveMore;
    }

    public void setHaveMore(boolean haveMore) {
        this.haveMore = haveMore;
    }

    public boolean isLoadMore() {
        return loadMore;
    }

    public void setLoadMore(boolean loadMore) {
        this.loadMore = loadMore;
    }

    public BehindTabAdapter(Context context, List<BehindList.BehindBean> data) {
        inflater = LayoutInflater.from(context);
        mContext = context;
        if (data != null) {
            this.data = data;
        } else {
            this.data = new ArrayList<>();
        }
    }

    public void updateRes(List<BehindList.BehindBean> data) {
        if (data != null && data.size() != 0) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    public void addRes(List<BehindList.BehindBean> data) {
        if (data != null && data.size() != 0) {
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        return data.size() > 0 ? data.size() + 1 : 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;
        switch (viewType) {
            case TYPE_FOOTER:
                itemView = inflater.inflate(R.layout.load_more, parent, false);
                return new FooterViewHolder(itemView);
            default:
                itemView = inflater.inflate(R.layout.fragment_behind_tab_item, parent, false);
                return new ViewHolder(itemView);
        }

    }


    @Override
    public int getItemViewType(int position) {
        int itemCount = data.size();
        if (position >= itemCount) {
            return TYPE_FOOTER;
        }
        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        LogUtils.loge(String.valueOf(itemViewType));
        switch (itemViewType) {
            case TYPE_FOOTER:
                if (holder instanceof FooterViewHolder) {
                    FooterViewHolder footerViewHolder = (FooterViewHolder) holder;
                    if (haveMore) {
                        footerViewHolder.loadMore.setVisibility(View.VISIBLE);
                        footerViewHolder.loadEnd.setVisibility(View.GONE);
                    } else {
                        footerViewHolder.loadMore.setVisibility(View.GONE);
                        footerViewHolder.loadEnd.setVisibility(View.VISIBLE);
                    }
                }
                break;
            default:
                if (holder instanceof ViewHolder) {
                    ViewHolder holderBehind = (ViewHolder) holder;
                    holder.itemView.setOnClickListener(this);
                    holderBehind.title.setText(getItem(position).getTitle());
                    holderBehind.share.setText(getItem(position).getShare_num());
                    holderBehind.collection.setText(getItem(position).getLike_num());
                    Glide.with(mContext).load(getItem(position).getImage()).into(holderBehind.image);
                }
                break;
        }
    }

    public BehindList.BehindBean getItem(int position) {
        return data.get(position);
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
            int position = mRecyclerView.getChildAdapterPosition(v);
            LogUtils.logd(String.valueOf(position));
            Intent intent = new Intent(mContext, BehindTabDetailActivity.class);
            // 传值
            mContext.startActivity(intent);
        }
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R2.id.teach_behind_tab_image)
        ImageView image;

        @BindView(R2.id.teach_behind_tab_title)
        TextView title;

        @BindView(R2.id.teach_behind_tab_share)
        TextView share;

        @BindView(R2.id.teach_behind_tab_collection)
        TextView collection;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public static class FooterViewHolder extends RecyclerView.ViewHolder {

        @BindView(R2.id.teach_load_more)
        View loadMore;

        @BindView(R2.id.teach_load_end)
        View loadEnd;

        public FooterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
