package com.rock.teachlibrary.utils;

import java.lang.reflect.ParameterizedType;

/**
 * Created by Rock on 16/11/28.
 */

public class TypeUtil {

    public static <T> T getTypeObject(Object o, int i) {

        try {
            return ((Class<T>) ((ParameterizedType) (o.getClass()
                    .getGenericSuperclass())).getActualTypeArguments()[i]).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }

        return null;
    }


}
