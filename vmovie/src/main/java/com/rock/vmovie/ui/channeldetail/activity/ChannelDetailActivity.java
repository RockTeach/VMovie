package com.rock.vmovie.ui.channeldetail.activity;


import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.rock.teachlibrary.base.BaseActivity;
import com.rock.vmovie.R;
import com.rock.vmovie.R2;
import com.rock.vmovie.bean.ChannelDetail;
import com.rock.vmovie.ui.channeldetail.adapters.ChannelDetailAdapter;
import com.rock.vmovie.ui.channeldetail.contract.ChannelDetailContract;
import com.rock.vmovie.ui.channeldetail.model.ChannelDetailModel;
import com.rock.vmovie.ui.channeldetail.presenter.ChannelDetailPresenter;
import butterknife.BindView;
import butterknife.OnClick;

public class ChannelDetailActivity extends BaseActivity<ChannelDetailModel, ChannelDetailPresenter> implements ChannelDetailContract.View, SwipeRefreshLayout.OnRefreshListener {

    public static final String TITLE = "title";
    public static final String TYPE = "type";
    public static final String JOINT = "joint";
    public static final String ALIAS = "";

    private static final int SIZE = 10;

    @BindView(R2.id.teach_channel_detail_recycler)
    RecyclerView mRecyclerView;

    @BindView(R2.id.teach_channel_detail_refresh)
    SwipeRefreshLayout mRefreshLayout;

    @BindView(R2.id.teach_channel_detail_type)
    TextView mType;

    private ChannelDetailAdapter adapter;

    private String cateid;

    private int page = 1;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_channel_detail;
    }

    @Override
    protected void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {
        mRefreshLayout.setOnRefreshListener(this);

        adapter = new ChannelDetailAdapter(this, null);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                if (adapter.isHaveMore() && !mRefreshLayout.isRefreshing() && !adapter.isLoadMore() && layoutManager.findLastVisibleItemPosition() == adapter.getItemCount() - 3) {
                    adapter.setLoadMore(true);
                    // 调用加载更多
                    mPresenter.getChannelDetailRequest(++page, SIZE, cateid);
                }
            }
        });
        mRefreshLayout.setOnChildScrollUpCallback(new SwipeRefreshLayout.OnChildScrollUpCallback() {
            @Override
            public boolean canChildScrollUp(SwipeRefreshLayout parent, @Nullable View child) {
                return adapter.isLoadMore() && adapter.isHaveMore();
            }
        });
        mType.setText(getIntent().getStringExtra(TITLE));
        cateid = getIntent().getStringExtra(JOINT);
        mPresenter.getChannelDetailRequest(page, SIZE, cateid);
    }

    @Override
    public void returnChannelDetail(ChannelDetail channelDetail) {
        if (channelDetail.getData() != null && channelDetail.getData().size() > 0) {
            if (adapter.isLoadMore() && adapter.isHaveMore()) {
                adapter.setLoadMore(false);
                if (channelDetail.getData().size() != SIZE) {
                    adapter.setLoadMore(true);
                    adapter.setHaveMore(false);
                }
                adapter.addRes(channelDetail.getData());
            } else {
                adapter.updateRes(channelDetail.getData());
                adapter.setHaveMore(true);
                adapter.setLoadMore(false);
                mRefreshLayout.setRefreshing(false);
            }
        } else {
            adapter.setLoadMore(true);
            adapter.setHaveMore(false);
            adapter.notifyDataSetChanged();
        }
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

    @Override
    public void onRefresh() {
        page = 1;
        mPresenter.getChannelDetailRequest(page, SIZE, cateid);
    }

    @OnClick(R2.id.teach_channel_detail_back)
    void clickBack(){
        finish();
    }

}
