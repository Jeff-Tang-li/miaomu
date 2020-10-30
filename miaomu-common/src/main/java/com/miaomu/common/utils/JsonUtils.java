package com.miaomu.common.utils;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Jeff·Tang
 * @version 1.0
 * @date 2020/10/30 13:55
 */
public class JsonUtils<T> {

    private T toObject(Object o, Class<T> z) {
        return JSONObject.parseObject(JSONObject.toJSONString(o), z);
    }

    private List<T> toArray(Object o, Class<T> z) {
        return JSONObject.parseArray(JSONObject.toJSONString(o), z);
    }

}
