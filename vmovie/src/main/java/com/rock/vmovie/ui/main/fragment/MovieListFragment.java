package com.rock.vmovie.ui.main.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.rock.teachlibrary.base.BaseFragment;
import com.rock.teachlibrary.utils.LogUtils;
import com.rock.vmovie.R;
import com.rock.vmovie.R2;
import com.rock.vmovie.bean.MovieList;
import com.rock.vmovie.bean.MovieListBanner;
import com.rock.vmovie.constants.EventParams;
import com.rock.vmovie.ui.main.adapters.MovieListAdapter;
import com.rock.vmovie.ui.main.contract.MovieListContract;
import com.rock.vmovie.ui.main.model.MovieListModel;
import com.rock.vmovie.ui.main.presenter.MovieListPresenter;

import butterknife.BindView;


public class MovieListFragment extends BaseFragment<MovieListModel, MovieListPresenter> implements MovieListContract.View, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R2.id.teach_movie_refresh)
    SwipeRefreshLayout refreshLayout;

    @BindView(R2.id.teach_movie_recycler)
    RecyclerView mRecycler;

    private MovieListAdapter adapter;

    private int page = 1;

    private static final int SIZE = 20;

    private String cacheString = "最新";

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_movie_list;
    }

    @Override
    protected void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {

        refreshLayout.setOnRefreshListener(this);

        adapter = new MovieListAdapter(getActivity(), null);
        mRecycler.setAdapter(adapter);
        mRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                // 轮换标题
                View viewUnder = recyclerView.findChildViewUnder(50, 5);
                if (viewUnder != null && viewUnder.getContentDescription() != null) {
                    if (!TextUtils.equals(cacheString, viewUnder.getContentDescription())) {
                        cacheString = viewUnder.getContentDescription().toString();
                        LogUtils.loge(cacheString);
                        if (dy < 0) {
                            mRxManager.post(EventParams.MOVIE_TO_MAIN_CHANGE_DOWN_DATE, cacheString);
                        } else {
                            mRxManager.post(EventParams.MOVIE_TO_MAIN_CHANGE_UP_DATE, cacheString);
                        }
                    }
                }
                // 上拉加载逻辑
                LinearLayoutManager layoutManager = (LinearLayoutManager) mRecycler.getLayoutManager();
                if (!refreshLayout.isRefreshing() && !adapter.isLoadMore() && adapter.getItemCount() == layoutManager.findLastVisibleItemPosition() + 3) {
                    // 加载更多
                    adapter.setLoadMore(true);
                    mPresenter.getNewMovieListRequest(++page, SIZE);
                }
            }
        });


        mPresenter.getNewMovieListRequest(page, SIZE);
        mPresenter.getNewMoviewBanner();
    }


    @Override
    public void returnNewMovieList(MovieList movieList) {
        if (adapter.isLoadMore()) {
            adapter.setLoadMore(false);
            adapter.addRes(movieList.getData());
        }else{
            adapter.updateRes(movieList.getData());
            refreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void returnNewMovieBanner(MovieListBanner movieBanner) {
        adapter.updateViewPager(movieBanner.getData());
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
        mPresenter.getNewMovieListRequest(page, SIZE);

    }
}
