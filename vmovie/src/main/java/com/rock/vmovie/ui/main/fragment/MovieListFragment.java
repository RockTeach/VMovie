package com.rock.vmovie.ui.main.fragment;

import com.rock.teachlibrary.base.BaseFragment;
import com.rock.vmovie.R;
import com.rock.vmovie.bean.MovieList;
import com.rock.vmovie.bean.MovieListBanner;
import com.rock.vmovie.ui.main.contract.MovieListContract;
import com.rock.vmovie.ui.main.model.MovieListModel;
import com.rock.vmovie.ui.main.presenter.MovieListPresenter;


public class MovieListFragment extends BaseFragment<MovieListModel,MovieListPresenter> implements MovieListContract.View{

    private int page = 1;

    private int size = 20;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_movie_list;
    }

    @Override
    protected void initPresenter() {
        mPresenter.setVM(this,mModel);
    }

    @Override
    protected void initView() {



        mPresenter.getNewMovieListRequest(page,size);
        mPresenter.getNewMoviewBanner();
    }


    @Override
    public void returnNewMovieList(MovieList movieList) {

    }

    @Override
    public void returnNewMovieBanner(MovieListBanner movieBanner) {

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
