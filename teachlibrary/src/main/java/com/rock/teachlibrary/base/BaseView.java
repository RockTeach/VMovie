package com.rock.teachlibrary.base;

/**
 * Created by Rock on 16/11/28.
 */

public interface BaseView {

    void showLoading(String title);

    void stopLoading();

    void showErrorTip(String msg);


}
