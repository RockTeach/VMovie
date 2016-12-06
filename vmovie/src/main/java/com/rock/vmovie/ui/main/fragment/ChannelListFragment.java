package com.rock.vmovie.ui.main.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rock.teachlibrary.base.BaseFragment;
import com.rock.teachlibrary.utils.LogUtils;
import com.rock.vmovie.R;
import com.rock.vmovie.R2;
import com.rock.vmovie.bean.ChannelList;
import com.rock.vmovie.ui.main.adapters.ChannelAdapter;
import com.rock.vmovie.ui.main.contract.ChannelListContract;
import com.rock.vmovie.ui.main.model.ChannelListModel;
import com.rock.vmovie.ui.main.presenter.ChannelListPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Rock on 16/11/30.
 */

public class ChannelListFragment extends BaseFragment<ChannelListModel,ChannelListPresenter> implements ChannelListContract.View{

    @BindView(R2.id.teach_channel_recycler)
    RecyclerView mRecycler;

    private ChannelAdapter adapter;


    @Override
    public int getLayoutResId() {
        return R.layout.fragment_channel_list;
    }

    @Override
    protected void initPresenter() {
        mPresenter.setVM(this,mModel);
    }

    @Override
    protected void initView() {
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        mRecycler.setLayoutManager(layoutManager);
        adapter = new ChannelAdapter(getActivity(),getData());
        mRecycler.setAdapter(adapter);

        mPresenter.getChannelListRequest();
    }
    // 接口内容没找到，仿造两条假数据
    private List<ChannelList.ChannelBean> getData() {
        List<ChannelList.ChannelBean> data = new ArrayList<>();
        ChannelList.ChannelBean channelBean = new ChannelList.ChannelBean();
        channelBean.setCate_type(String.valueOf(1));
        channelBean.setCatename("热门");
        channelBean.setIcon("http://cs.vmoiver.com/Uploads/Activity/2016-04-26/571ed9b5d2e44.jpg");
        channelBean.setAlias("hot");
        data.add(channelBean);
        channelBean = new ChannelList.ChannelBean();
        channelBean.setCate_type(String.valueOf(1));
        channelBean.setCatename("专题");
        channelBean.setIcon("http://cs.vmoiver.com/Uploads/Activity/2016-04-27/5720601258d7f.jpg");
        channelBean.setAlias("album");
        data.add(channelBean);
        return data;
    }


    @Override
    public void returnChannelList(ChannelList channelList) {
        adapter.addRes(channelList.getData());
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
}
