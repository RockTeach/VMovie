package com.rock.vmovie.utils;

import android.text.format.DateFormat;

/**
 * Created by Rock on 2016/12/27.
 */

public class TimeUtil {

    public static CharSequence parseToMMSS(int time){
        return DateFormat.format("mm:ss", time);
    }

}
