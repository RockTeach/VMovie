package com.rock.vmovie.utils;

import com.rock.teachlibrary.utils.SharedUtil;
import com.rock.vmovie.constants.SharedParams;

/**
 * Created by Rock on 16/11/30.
 */

public class UserController {

    public static boolean isLogin(){
        return SharedUtil.getFlag(SharedParams.LOGIN_FLAG);
    }

}
