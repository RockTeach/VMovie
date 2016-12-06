package com.rock.vmovie;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import com.rock.teachlibrary.Rock;
import com.rock.teachlibrary.utils.LogUtils;


public class VMovieApp extends Application {

    @SuppressLint("StaticFieldLeak")
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化
        Rock.init(this);
        sContext = this;
    }

    public static Context getContext() {
        return sContext;
    }
}
