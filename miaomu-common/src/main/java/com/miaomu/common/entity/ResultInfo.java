package com.miaomu.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Jeff·Tang
 * @version 1.0
 * @date 2021/1/26 10:32
 */
@Data
public class ResultInfo<T> implements Serializable {
    private String message;

    private String code;

    private T t;

    private ResultInfo(String message, String code, T t) {
        this.message = message;
        this.code = code;
        this.t = t;
    }

    public static <T> ResultInfo<T> success(String message, String code) {
        return new ResultInfo<T>(message, code, null);
    }

    public static <T> ResultInfo<T> success(String message, T t) {
        return new ResultInfo<T>(message, "10000", t);
    }

    public static <T> ResultInfo<T> success(T t) {
        return new ResultInfo<T>("success", "10000", t);
    }

    public static <T> ResultInfo<T> error(String message, String code) {
        return new ResultInfo<T>(message, code, null);
    }

    public static <T> ResultInfo<T> error(String message, T t) {
        return new ResultInfo<T>(message, "40000", t);
    }

    public static <T> ResultInfo<T> error(String message) {
        return new ResultInfo<T>(message, "40000", null);
    }
}
