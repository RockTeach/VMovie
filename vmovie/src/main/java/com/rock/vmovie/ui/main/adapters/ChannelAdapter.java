package com.rock.vmovie.ui.main.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rock.teachlibrary.utils.ScreenUtil;
import com.rock.vmovie.R;
import com.rock.vmovie.R2;
import com.rock.vmovie.bean.ChannelList;
import com.rock.vmovie.ui.channeldetail.activity.ChannelDetailActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Rock on 16/12/6.
 */

public class ChannelAdapter extends RecyclerView.Adapter<ChannelAdapter.ViewHolder> implements View.OnClickListener {

    private List<ChannelList.ChannelBean> data;

    private LayoutInflater inflater;

    private Context context;
    private RecyclerView mRecyclerView;

    public ChannelAdapter(Context context, List<ChannelList.ChannelBean> data){
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    public void addRes(List<ChannelList.ChannelBean> data){
        if (data != null) {
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.fragment_channel_item, parent, false);
        itemView.getLayoutParams().height = ScreenUtil.getScreenWidth() / 2 ;
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.catename.setText(String.format("#%s#",data.get(position).getCatename()));
        Glide.with(context).load(data.get(position).getIcon()).into(holder.image);
        holder.catename.setOnClickListener(this);
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
            v = (View) v.getParent();
            int childAdapterPosition = mRecyclerView.getChildAdapterPosition(v);
            ChannelList.ChannelBean channelBean = data.get(childAdapterPosition);
            Intent intent = new Intent(context, ChannelDetailActivity.class);
            intent.putExtra(ChannelDetailActivity.JOINT,channelBean.getCateid());
            intent.putExtra(ChannelDetailActivity.ALIAS,channelBean.getAlias());
            intent.putExtra(ChannelDetailActivity.TITLE,channelBean.getCatename());
            intent.putExtra(ChannelDetailActivity.TYPE,channelBean.getCate_type());
            context.startActivity(intent);
        }
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R2.id.teach_channel_image)
        ImageView image;

        @BindView(R2.id.teach_channel_catename)
        Button catename;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }


}
