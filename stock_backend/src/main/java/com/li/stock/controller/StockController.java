package com.li.stock.controller;

import com.li.stock.mapper.StockMarketIndexInfoMapper;
import com.li.stock.pojo.domain.InnerMarketDomain;
import com.li.stock.pojo.entity.StockMarketIndexInfo;
import com.li.stock.pojo.vo.StockInfoConfig;
import com.li.stock.utils.DateTimeUtil;
import com.li.stock.vo.resp.R;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @Author LiMingYu
 * @Create 2024-02-08 22:26
 * @Description 功能描述
 */
@RestController
@RequestMapping("/api/quot")
public class StockController {
    @Autowired
    private StockInfoConfig stockInfoConfig;
    @Autowired
    private StockMarketIndexInfoMapper stockMarketIndexInfoMapper;

    @GetMapping("/index/all")
    public R<List<InnerMarketDomain>> getAllStock(){
        //获取时间点
        DateTime lastDate4Stock = DateTimeUtil.getLastDate4Stock(DateTime.now());
        Date date = lastDate4Stock.toDate();
        //获取大盘集合
        List<String> inner = stockInfoConfig.getInner();
        //mapper调用
        List<InnerMarketDomain> innerMarketDomainList = stockMarketIndexInfoMapper.getMarketInfo(date, inner);
        //封装响应
        return R.ok(innerMarketDomainList);
    }
}
