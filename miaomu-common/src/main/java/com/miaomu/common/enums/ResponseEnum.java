package com.miaomu.common.enums;

/**
 * @author Jeff·Tang
 * @version 1.0
 * @date 2020/11/17 12:47
 */
public enum ResponseEnum {
    /**
     * 定义了公共的返回类型
     */
    RESPONSE_ENUM_SUCCESS(200, "SUCCESS"),

    RESPONSE_ENUM_ERROR(40001, "ERROR"),

    RESPONSE_ENUM_PARAM_ERROR(41001, "PARAM ERROR"),

    RESPONSE_ENUM_PARAM_ERROR_TYPE(41002, "PARAM TYPE ERROR"),

    RESPONSE_ENUM_PARAM_ERROR_FORMAT(41003, "PARAM FORMAT ERROR"),

    RESPONSE_ENUM_USER_ERROR(50001, "USER ERROR"),

    RESPONSE_ENUM_USER_ERROR_PASSWORD(51001, "PASSWORD ERROR"),

    RESPONSE_ENUM_USER_ERROR_ACCOUNT(51002, "ACCOUNT ERROR"),

    RESPONSE_ENUM_USER_ERROR_LOGIN(52001, "NO LOGIN"),

    RESPONSE_ENUM_USER_ERROR_UNAUTHORIZED(53001, "UNAUTHORIZED");

    private final Integer code;

    private final String message;

    ResponseEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
