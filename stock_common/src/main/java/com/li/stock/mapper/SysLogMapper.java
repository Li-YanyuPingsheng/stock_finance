package com.li.stock.mapper;

import com.li.stock.pojo.entity.SysLog;

/**
* @author LiMY
* @description 针对表【sys_log(系统日志)】的数据库操作Mapper
* @createDate 2024-02-05 16:33:03
* @Entity com.li.stock.pojo.entity.SysLog
*/
public interface SysLogMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysLog record);

    int insertSelective(SysLog record);

    SysLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysLog record);

    int updateByPrimaryKey(SysLog record);

}
