package com.miaomu.common.excepitons;

import com.miaomu.common.enums.ResponseEnum;
import lombok.Data;

/**
 * @author Jeff·Tang
 * @version 1.0
 * @date 2020/10/30 13:50
 */
@Data
public class NoLoginException extends RuntimeException {

    private Integer code = ResponseEnum.RESPONSE_ENUM_USER_ERROR_LOGIN.getCode();

    private String msg = ResponseEnum.RESPONSE_ENUM_USER_ERROR_LOGIN.getMessage();

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


}
