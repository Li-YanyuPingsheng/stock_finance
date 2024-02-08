package com.li.stock.pojo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @Author LiMingYu
 * @Create 2024-02-08 21:40
 * @Description 功能描述
 */
@Data
@ApiModel("大盘数据")
public class InnerMarketDomain {
    /**
     * 大盘
     */
    @ApiModelProperty("大盘名称")
    private String code;
    private String name;
    /**
     * 开盘点
     */
    private BigDecimal openPoint;
    /**
     * 当前点
     */
    private BigDecimal curPoint;
    /**
     * 收盘点
     */
    private BigDecimal preClosePoint;
    /**
     *  涨跌点
     */
    private Long tradeAmt;
    /**
     *  成交量
     */
    private BigDecimal tradeVol;
    /**
     *   涨跌幅
     */
    private BigDecimal upDown;
    /**
     *    振幅
     */
    private BigDecimal amplitude;
    private BigDecimal rose;
    @JsonFormat(pattern = "yyyy-MM-dd HH:m", timezone = "GMT+8")
    private Date curTime;

}
