package com.miaomu.portal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Jeff·Tang
 * @version 1.0
 * @date 2020/9/28 9:24
 */
@SpringBootApplication
@MapperScan("com.miaomu.mapper")
public class PortalApplication {
    public static void main(String[] args) {
        SpringApplication.run(PortalApplication.class, args);
    }
}
