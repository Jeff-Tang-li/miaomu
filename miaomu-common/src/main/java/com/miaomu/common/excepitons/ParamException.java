package com.miaomu.common.excepitons;

/**
 * @author Jeff·Tang
 * @version 1.0
 * @date 2020/10/30 13:44
 */

public class ParamException extends RuntimeException {
    private Integer code = 40001;
    private String msg = "参数错误";

    public ParamException() {
    }

    public ParamException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public ParamException(Integer code) {
        this.code = code;
    }

    public ParamException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
