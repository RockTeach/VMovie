package com.rock.teachlibrary.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.rock.teachlibrary.Rock;
import com.rock.teachlibrary.config.LibraryConfig;

/**
 * Created by Rock on 16/11/29.
 */

public class SharedUtil {

    public static boolean getFlag(String key){
        SharedPreferences sdf = getSdf();
        return sdf.getBoolean(key, false);

    }

    public static void putFlag(String key,boolean value){
        SharedPreferences sdf = getSdf();
        sdf.edit().putBoolean(key,value).apply();
    }

    private static SharedPreferences getSdf(){
        return Rock.getContext().getSharedPreferences(LibraryConfig.APP_NAME, Context.MODE_PRIVATE);
    }




}
