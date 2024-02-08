package com.li.stock.pojo.vo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author LiMingYu
 * @Create 2024-02-08 22:04
 * @Description 功能描述
 */
@Data
//@Component
@ConfigurationProperties(prefix = "stock")
public class StockInfoConfig {
    private List<String> inner;
    private List<String> outer;
}
