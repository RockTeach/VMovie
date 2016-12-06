package com.rock.vmovie.ui.main.adapters;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rock.vmovie.R;
import com.rock.vmovie.R2;
import com.rock.vmovie.bean.MovieList;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MovieListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int HEADER_TYPE = 100;

    private static final int FOOTER_TYPE = 101;

    private List<MovieList.MovieBean> data;

    private LayoutInflater inflater;

    private Context context;

    private boolean loadMore;

    public boolean isLoadMore() {
        return loadMore;
    }

    public void setLoadMore(boolean loadMore) {
        this.loadMore = loadMore;
    }

    public MovieListAdapter(Context context, List<MovieList.MovieBean> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        if (data != null) {
            this.data = data;
        } else {
            this.data = new ArrayList<>();
        }
    }

    public int getHeaderCount() {
        return 0;
    }

    public void updateRes(List<MovieList.MovieBean> data) {
        if (data != null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    public void addRes(List<MovieList.MovieBean> data) {
        if (data != null) {
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        return data != null ? loadMore ? data.size() + 1 : data.size() : 0;
    }

    public MovieList.MovieBean getItem(int position){
        position = position - getHeaderCount();
        return data.get(position);
    }


    @Override
    public int getItemViewType(int position) {
        if (position < getHeaderCount()) {
            return HEADER_TYPE;
        } else if (position >= data.size() + getHeaderCount()) {
            return FOOTER_TYPE;
        }
        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;
        switch (viewType) {
            case FOOTER_TYPE:
                itemView = inflater.inflate(R.layout.load_more, parent, false);
                return new FooterViewHolder(itemView);
            case HEADER_TYPE:

                return new HeaderViewHolder(itemView);
            default:
                itemView = inflater.inflate(R.layout.fragment_movie_item, parent, false);
                return new ViewHolder(itemView);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case FOOTER_TYPE:

                break;
            case HEADER_TYPE:

                break;
            default:
                if (holder instanceof ViewHolder) {

                    ViewHolder holderItem = (ViewHolder) holder;

                    holderItem.movieDate.setText(dateParse(getItem(position).getPublish_time()));

                    holderItem.advert.setText(timeParse(getItem(position).getCates().get(0).getCatename(), getItem(position).getDuration()));

                    holderItem.title.setText(getItem(position).getTitle());

                    Glide.with(context).load(getItem(position).getImage()).into(holderItem.image);

                    /**
                     * 处理首次出现显示，二次出现隐藏
                     */
                    if (position - getHeaderCount() == 0) {
                        holderItem.movieDate.setVisibility(View.GONE);
                    } else {
                        if (TextUtils.equals(dateParse(getItem(position).getPublish_time()), dateParse(getItem(position-1).getPublish_time()))) {
                            holderItem.movieDate.setVisibility(View.GONE);
                        } else {
                            holderItem.movieDate.setVisibility(View.VISIBLE);
                        }
                    }
                    holder.itemView.setContentDescription(dateParse(getItem(position).getPublish_time()));

                }
                break;
        }

    }

    public String dateParse(String time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM.d", Locale.ENGLISH);
        String parseDate = dateFormat.format(new Date(Long.parseLong(time) * 1000));
        return parseDate.equals(dateFormat.format(new Date())) ? "最新" : parseDate;
    }

    public String timeParse(String catename, String duration) {
        int durationInt = Integer.parseInt(duration);
        return String.format(Locale.CHINA, "%s / %d'%d\"", catename, durationInt / 60, durationInt % 60);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R2.id.teach_movie_date)
        TextView movieDate;

        @BindView(R2.id.teach_movie_image)
        ImageView image;

        @BindView(R2.id.teach_movie_advert)
        TextView advert;

        @BindView(R2.id.teach_movie_title)
        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {

        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }

    public static class FooterViewHolder extends RecyclerView.ViewHolder {

        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }

}
