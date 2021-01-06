package com.miaomu.common.excepitons;

import com.miaomu.common.enums.ResponseEnum;
import lombok.Data;

/**
 * @author Jeff·Tang
 * @version 1.0
 * @date 2020/10/30 13:44
 */
@Data
public class ParamException extends RuntimeException {

    private Integer code = ResponseEnum.RESPONSE_ENUM_PARAM_ERROR.getCode();

    private String msg = ResponseEnum.RESPONSE_ENUM_PARAM_ERROR.getMessage();

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

}
