package com.rock.vmovie.ui.main.fragment;

import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.rock.teachlibrary.base.BaseFragment;
import com.rock.vmovie.R;
import com.rock.vmovie.R2;
import com.rock.vmovie.bean.SeriesList;
import com.rock.vmovie.ui.main.adapters.SeriesAdapter;
import com.rock.vmovie.ui.main.contract.SeriesListContract;
import com.rock.vmovie.ui.main.model.SeriesListModel;
import com.rock.vmovie.ui.main.presenter.SeriesListPresenter;

import butterknife.BindView;

/**
 * Created by Rock on 16/11/30.
 */

public class SeriesFragment extends BaseFragment<SeriesListModel,SeriesListPresenter> implements SeriesListContract.View, SwipeRefreshLayout.OnRefreshListener {

    public static final String TAG = SeriesFragment.class.getName();

    private static final int SIZE = 10;

    private int page = 1;

    private SeriesAdapter adapter;

    @BindView(R2.id.teach_series_recycler)
    RecyclerView mRecyclerView;

    @BindView(R2.id.teach_series_refresh)
    SwipeRefreshLayout mRefreshLayout;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_main_series;
    }

    @Override
    protected void initView() {
        adapter = new SeriesAdapter(getContext(), null);
        mRecyclerView.setAdapter(adapter);
        mRefreshLayout.setOnRefreshListener(this);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                if (!mRefreshLayout.isRefreshing() && !adapter.isLoadMore() && layoutManager.findLastVisibleItemPosition() == adapter.getItemCount() - 3) {
                    adapter.setLoadMore(true);
                    // 调用加载更多
                    mPresenter.getSeriesListRequest(++page,SIZE);
                }
            }
        });
        mRefreshLayout.setOnChildScrollUpCallback(new SwipeRefreshLayout.OnChildScrollUpCallback() {
            @Override
            public boolean canChildScrollUp(SwipeRefreshLayout parent, @Nullable View child) {
                return adapter.isLoadMore();
            }
        });
        mPresenter.getSeriesListRequest(page,SIZE);
    }

    @Override
    protected void initPresenter() {
        mPresenter.setVM(this,mModel);
    }

    @Override
    public void returnSeriesList(SeriesList seriesList) {
        if (adapter.isLoadMore()) {
            adapter.setLoadMore(false);
            adapter.addRes(seriesList.getData());
        }else{
            adapter.updateRes(seriesList.getData());
            mRefreshLayout.setRefreshing(false);
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
        mPresenter.getSeriesListRequest(++page,SIZE);
        page = 1;
    }
}
