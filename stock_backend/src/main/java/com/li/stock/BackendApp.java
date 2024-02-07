package com.li.stock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author LiMingYu
 * @Create 2024-02-05 16:42
 * @Description 功能描述
 */
@SpringBootApplication
@MapperScan("com.li.stock.mapper")//mapper接口，ioc容器处理
public class BackendApp {
    public static void main(String[] args) {
        SpringApplication.run(BackendApp.class, args);
    }
}
