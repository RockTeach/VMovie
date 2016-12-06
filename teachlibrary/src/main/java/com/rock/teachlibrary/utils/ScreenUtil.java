package com.rock.teachlibrary.utils;

import android.content.Context;

/**
 * Created by Rock on 16/12/6.
 */

public class ScreenUtil {

    private static int screenWidth = 0;

    private static int screenHeight = 0;

    public static void init(Context context){
        screenHeight = context.getResources().getDisplayMetrics().heightPixels;
        screenWidth = context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenWidth() {
        return screenWidth;
    }

    public static int getScreenHeight() {
        return screenHeight;
    }
}
