package com.rock.vmovie.ui.main.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.rock.teachlibrary.base.BaseFragment;
import com.rock.teachlibrary.utils.LogUtils;
import com.rock.vmovie.R;
import com.rock.vmovie.R2;
import com.rock.vmovie.bean.BehindList;
import com.rock.vmovie.ui.main.adapters.BehindTabAdapter;
import com.rock.vmovie.ui.main.contract.BehindTabContract;
import com.rock.vmovie.ui.main.model.BehindTabModel;
import com.rock.vmovie.ui.main.presenter.BehindTabPresenter;

import butterknife.BindView;


/**
 * Created by Rock on 16/12/7.
 */

public class BehindTabFragment extends BaseFragment<BehindTabModel,BehindTabPresenter> implements BehindTabContract.View, SwipeRefreshLayout.OnRefreshListener {

    public static final String CATE_ID = "cate_id";

    private static final String DEFAULT_CATE_ID = "2";

    private static final int SIZE = 10;

    @BindView(R2.id.teach_behind_tab_refresh)
    SwipeRefreshLayout mRefreshLayout;

    @BindView(R2.id.teach_behind_tab_recycler)
    RecyclerView mRecyclerView;

    private String cateId;

    private int page = 1;

    private BehindTabAdapter adapter;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_behind_tab;
    }

    @Override
    protected void initPresenter() {
        mPresenter.setVM(this,mModel);
    }

    @Override
    protected void initView() {
        adapter = new BehindTabAdapter(getActivity(),null);
        mRecyclerView.setAdapter(adapter);
        mRefreshLayout.setOnRefreshListener(this);

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                if (adapter.isHaveMore() && !mRefreshLayout.isRefreshing() && !adapter.isLoadMore() && layoutManager.findLastVisibleItemPosition() == adapter.getItemCount() - 1) {
                    adapter.setLoadMore(true);
                    // 调用加载更多
                    mPresenter.getBehindListRequest(++page, SIZE,cateId);
                }
            }
        });
        mRefreshLayout.setOnChildScrollUpCallback(new SwipeRefreshLayout.OnChildScrollUpCallback() {
            @Override
            public boolean canChildScrollUp(SwipeRefreshLayout parent, @Nullable View child) {
                return adapter.isLoadMore() && adapter.isHaveMore();
            }
        });

        Bundle bundle = getArguments();
        cateId = bundle.getString(CATE_ID,DEFAULT_CATE_ID);
        LogUtils.loge(cateId);

        mPresenter.getBehindListRequest(page,SIZE,cateId);
    }

    @Override
    public void returnBehindList(BehindList behindList) {

        if (behindList.getData() != null && behindList.getData().size() > 0) {
            if (adapter.isLoadMore() && adapter.isHaveMore()) {
                adapter.setLoadMore(false);
                if (behindList.getData().size() != SIZE) {
                    adapter.setLoadMore(true);
                    adapter.setHaveMore(false);
                }
                adapter.addRes(behindList.getData());
            } else {
                adapter.updateRes(behindList.getData());
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
        mPresenter.getBehindListRequest(page,SIZE,cateId);
    }
}
