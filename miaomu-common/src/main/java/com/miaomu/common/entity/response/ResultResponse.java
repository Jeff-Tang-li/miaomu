package com.miaomu.common.entity.response;

import lombok.Data;

@Data
public class ResultResponse {

    private Integer status;

    private String message;

    private Object t;


    public ResultResponse(Integer status, String message, Object t) {
        this.status = status;
        this.message = message;
        this.t = t;
    }

    public ResultResponse() {
    }

    public static ResultResponse successful(String message, Object t) {
        return new ResultResponse(200, message, t);
    }

    public static ResultResponse successful(Object t) {
        return new ResultResponse(200, "SUCCESS", t);
    }

    public static ResultResponse failure(Integer status, String message, Object t) {
        return new ResultResponse(status, message, t);
    }

    public static ResultResponse failure(String message, Object t) {
        return new ResultResponse(40001, message, t);
    }

    public static ResultResponse failure(Object t) {
        return new ResultResponse(40001, "FAILURE", t);
    }

}
