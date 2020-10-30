package com.miaomu.common.utils;

import com.miaomu.common.excepitons.NoLoginException;
import com.miaomu.common.excepitons.ParamException;

/**
 * @author Jeff·Tang
 * @version 1.0
 * @date 2020/10/30 13:52
 */
public class AsserUtils {
    public static void isTrue(boolean t, String msg) {
        if (t) {
            throw new ParamException(msg);
        }
    }

    public static void isTrue(boolean t, String msg, Integer code) {
        if (t) {
            throw new ParamException(code, msg);
        }
    }

    public static void isTrue(boolean t) {
        if (t) {
            throw new ParamException();
        }
    }

    public static void noLogin(boolean t, String msg, Integer code) {
        if (t) {
            throw new NoLoginException(code, msg);
        }
    }

    public static void noLogin(boolean t, String msg) {
        if (t) {
            throw new NoLoginException(msg);
        }
    }

    public static void noLogin(boolean t) {
        if (t) {
            throw new NoLoginException();
        }
    }
}
