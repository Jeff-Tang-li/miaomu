package com.miaomu.common.excepitons;

/**
 * @author Jeff·Tang
 * @version 1.0
 * @date 2020/10/30 13:50
 */
public class NoLoginException extends RuntimeException {
    private Integer code = 50001;
    private String msg = "UnAuthorized ";

    public NoLoginException() {
    }

    public NoLoginException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public NoLoginException(Integer code) {
        this.code = code;
    }

    public NoLoginException(Integer code, String msg) {
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