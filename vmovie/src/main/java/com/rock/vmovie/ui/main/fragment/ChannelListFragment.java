package com.rock.vmovie.ui.main.fragment;

import com.rock.teachlibrary.base.BaseFragment;
import com.rock.vmovie.R;
import com.rock.vmovie.bean.ChannelList;
import com.rock.vmovie.ui.main.contract.ChannelListContract;
import com.rock.vmovie.ui.main.model.ChannelListModel;
import com.rock.vmovie.ui.main.presenter.ChannelListPresenter;

/**
 * Created by Rock on 16/11/30.
 */

public class ChannelListFragment extends BaseFragment<ChannelListModel,ChannelListPresenter> implements ChannelListContract.View{
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


        mPresenter.getChannelListRequest();
    }



    @Override
    public void returnChannelList(ChannelList channelList) {

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
