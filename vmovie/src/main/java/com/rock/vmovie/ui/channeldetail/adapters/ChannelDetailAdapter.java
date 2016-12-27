package com.rock.vmovie.ui.channeldetail.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rock.teachlibrary.utils.LogUtils;
import com.rock.vmovie.R;
import com.rock.vmovie.R2;
import com.rock.vmovie.bean.ChannelDetail;
import com.rock.vmovie.ui.moviedetail.activity.MovieDetailActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ChannelDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    private final Context mContext;

    private List<ChannelDetail.ChannelDetailBean> data;

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

    public ChannelDetailAdapter(Context context, List<ChannelDetail.ChannelDetailBean> data) {
        inflater = LayoutInflater.from(context);
        mContext = context;
        if (data != null) {
            this.data = data;
        } else {
            this.data = new ArrayList<>();
        }
    }

    public void updateRes(List<ChannelDetail.ChannelDetailBean> data) {
        if (data != null && data.size() != 0) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    public void addRes(List<ChannelDetail.ChannelDetailBean> data) {
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
                itemView = inflater.inflate(R.layout.activity_channel_detail_item, parent, false);
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

    public ChannelDetail.ChannelDetailBean getItem(int position) {
        return data.get(position);
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
                    }else{
                        footerViewHolder.loadMore.setVisibility(View.GONE);
                        footerViewHolder.loadEnd.setVisibility(View.VISIBLE);
                    }
                }
                break;
            default:
                if (holder instanceof ViewHolder) {
                    ViewHolder holderChannelDetail = ((ViewHolder) holder);
                    holderChannelDetail.title.setText(getItem(position).getTitle());
                    holderChannelDetail.advert.setText(timeParse(getItem(position).getCates().get(0).getCatename(),getItem(position).getDuration()));
                    Glide.with(mContext).load(getItem(position).getImage()).into(holderChannelDetail.image);
                    holderChannelDetail.clickView.setOnClickListener(this);
                }
                break;
        }
    }

    public String timeParse(String catename, String duration) {
        int durationInt = Integer.parseInt(duration);
        return String.format(Locale.CHINA, "%s / %d'%d\"", catename, durationInt / 60, durationInt % 60);
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
            Intent intent = new Intent(mContext, MovieDetailActivity.class);
            intent.putExtra(MovieDetailActivity.POSTID,getItem(position).getPostid());
            intent.putExtra(MovieDetailActivity.LIKES,getItem(position).getLike_num());
            intent.putExtra(MovieDetailActivity.SHARES,getItem(position).getShare_num());
            mContext.startActivity(intent);
        }
    }

    public View getItemView(View view) {
        View parent = (View) view.getParent();
        if (parent.getLayoutParams() instanceof RecyclerView.LayoutParams) {
            return parent;
        }
        return getItemView(parent);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R2.id.teach_channel_detail_image)
        ImageView image;

        @BindView(R2.id.teach_channel_detail_advert)
        TextView advert;

        @BindView(R2.id.teach_channel_detail_title)
        TextView title;

        @BindView(R2.id.teach_channel_detail_click)
        View clickView;

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
