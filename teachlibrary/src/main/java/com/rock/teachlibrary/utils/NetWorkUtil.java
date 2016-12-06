package com.rock.teachlibrary.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.rock.teachlibrary.Rock;

/**
 * 网络工具类，需要 android.permission.ACCESS_NETWORK_STATE 权限
 */

public class NetWorkUtil {

    /**
     * 判断设备有没有网络
     */
    public static boolean isNetConnected(Context context) {
        NetworkInfo localNetworkInfo = ((ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        return (localNetworkInfo != null) && (localNetworkInfo.isAvailable());
    }

    public static boolean isNetConnected(){
        return isNetConnected(Rock.getContext());
    }


}
