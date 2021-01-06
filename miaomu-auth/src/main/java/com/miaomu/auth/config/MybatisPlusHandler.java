package com.miaomu.auth.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author Jeff·Tang
 * @version 1.0
 * @date 2021/1/6 14:06
 */
@Component
public class MybatisPlusHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("create_time", LocalDateTime.now(ZoneOffset.UTC), metaObject)
                .setFieldValByName("update_time", LocalDateTime.now(ZoneOffset.UTC), metaObject)
                .setFieldValByName("first_time", LocalDateTime.now(ZoneOffset.UTC), metaObject)
                .setFieldValByName("last_time", LocalDateTime.now(ZoneOffset.UTC), metaObject);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("update_time", LocalDateTime.now(ZoneOffset.UTC), metaObject)
                .setFieldValByName("last_time", LocalDateTime.now(ZoneOffset.UTC), metaObject);
    }
}
