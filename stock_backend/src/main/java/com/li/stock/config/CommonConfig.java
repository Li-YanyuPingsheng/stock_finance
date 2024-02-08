package com.li.stock.config;

import com.li.stock.pojo.vo.StockInfoConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author LiMingYu
 * @Create 2024-02-07 16:38
 * @Description 功能描述
 */
@Configuration
@EnableConfigurationProperties({StockInfoConfig.class})
public class CommonConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
