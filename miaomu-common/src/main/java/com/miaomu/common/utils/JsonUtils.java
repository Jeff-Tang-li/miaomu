package com.miaomu.common.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

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
