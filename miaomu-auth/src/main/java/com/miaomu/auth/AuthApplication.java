package com.miaomu.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * @author Jeff·Tang
 * @version 1.0
 * @date 2020/11/9 15:27
 */
@SpringBootApplication
@MapperScan("com.miaomu.auth.mapper")
@EnableFeignClients
@EnableDiscoveryClient
@EnableCaching
public class AuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }
}

