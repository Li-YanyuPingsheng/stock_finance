package com.li.stock.mapper;

import com.li.stock.pojo.entity.StockBusiness;

/**
* @author LiMY
* @description 针对表【stock_business(主营业务表)】的数据库操作Mapper
* @createDate 2024-02-05 16:33:03
* @Entity com.li.stock.pojo.entity.StockBusiness
*/
public interface StockBusinessMapper {

    int deleteByPrimaryKey(Long id);

    int insert(StockBusiness record);

    int insertSelective(StockBusiness record);

    StockBusiness selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StockBusiness record);

    int updateByPrimaryKey(StockBusiness record);

}
