package com.miaomu.common.entity.response;

import com.miaomu.common.enums.ResponseEnum;
import lombok.Data;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;

import java.util.Objects;

/**
 * @author tangxinli
 */
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

    public static ResultResponse successful(Integer status, String message, Object t) {
        return new ResultResponse(ResponseEnum.RESPONSE_ENUM_SUCCESS.getCode(), message, t);
    }

    public static ResultResponse successful(String message, Object t) {
        return successful(ResponseEnum.RESPONSE_ENUM_SUCCESS.getCode(), message, t);
    }


    public static ResultResponse successful(Object t) {
        return successful(ResponseEnum.RESPONSE_ENUM_SUCCESS.getCode(), "SUCCESS", t);
    }

    public static ResultResponse error(Integer status, String message, Object t) {
        return error(status, message, t);
    }

    public static ResultResponse error(String message, Object t) {
        return error(ResponseEnum.RESPONSE_ENUM_ERROR.getCode(), message, t);
    }

    public static ResultResponse error(Object t) {
        return new ResultResponse(ResponseEnum.RESPONSE_ENUM_USER_ERROR.getCode(), "FAILURE", t);
    }

    public static ResultResponse error(Integer status, BindingResult result, Object t) {
        if (result.hasErrors()) {
            if (StringUtils.isEmpty(status)) {
                return error(ResponseEnum.RESPONSE_ENUM_ERROR.getCode(), Objects.requireNonNull(result.getFieldError()).getDefaultMessage(), t);
            }
            return error(status, Objects.requireNonNull(result.getFieldError()).getDefaultMessage(), t);
        }
        return error(ResponseEnum.RESPONSE_ENUM_ERROR.getCode(), "FAILURE", t);
    }
}

