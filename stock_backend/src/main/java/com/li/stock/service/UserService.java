package com.li.stock.service;

import com.li.stock.pojo.entity.SysUser;
import com.li.stock.vo.req.LoginReqVo;
import com.li.stock.vo.resp.LoginRespVo;
import com.li.stock.vo.resp.R;

import java.util.Map;

/**
 * @Author LiMingYu
 * @Create 2024-02-07 14:36
 * @Description 功能描述
 */
public interface UserService {
    /**
     *
     * @param username
     * @return
     */
    SysUser findByUsername(String username);

    R<LoginRespVo> login(LoginReqVo loginReqVo);

    R<Map> getCaptchaCode();
}
