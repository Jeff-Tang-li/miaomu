package com.miaomu.goods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Jeff·Tang
 * @version 1.0
 * @date 2020/11/9 15:29
 */
@SpringBootApplication
@MapperScan("com.miaomu.goods.mapper")
@EnableFeignClients
@EnableDiscoveryClient
@EnableTransactionManagement
public class GoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class, args);
    }
}
