package com.miaomu.auth.config;


import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class MybatisPlusHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill.......");
        this.strictInsertFill(metaObject, "createTime", () -> LocalDateTime.now(ZoneOffset.UTC), LocalDateTime.class)
                .strictInsertFill(metaObject, "updateTime", () -> LocalDateTime.now(ZoneOffset.UTC), LocalDateTime.class)
                .strictInsertFill(metaObject, "isValued", () -> true, Boolean.class);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "updateTime", () -> LocalDateTime.now(ZoneOffset.UTC), LocalDateTime.class);

    }

}
