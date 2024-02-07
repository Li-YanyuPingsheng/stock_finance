package com.li.stock.mapper;

import com.li.stock.pojo.entity.SysRole;

/**
* @author LiMY
* @description 针对表【sys_role(角色表)】的数据库操作Mapper
* @createDate 2024-02-05 16:33:03
* @Entity com.li.stock.pojo.entity.SysRole
*/
public interface SysRoleMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

}
