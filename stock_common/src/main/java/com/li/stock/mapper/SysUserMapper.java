package com.li.stock.mapper;

import com.li.stock.pojo.entity.SysUser;
import org.apache.ibatis.annotations.Param;

/**
* @author LiMY
* @description 针对表【sys_user(用户表)】的数据库操作Mapper
* @createDate 2024-02-05 16:33:03
* @Entity com.li.stock.pojo.entity.SysUser
*/
public interface SysUserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser findUserInfoByName(@Param("userName") String userName);
}
