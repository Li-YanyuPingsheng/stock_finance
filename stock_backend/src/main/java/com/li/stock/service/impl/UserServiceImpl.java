package com.li.stock.service.impl;

import com.li.stock.mapper.SysUserMapper;
import com.li.stock.pojo.entity.SysUser;
import com.li.stock.service.UserService;
import com.li.stock.vo.req.LoginReqVo;
import com.li.stock.vo.resp.LoginRespVo;
import com.li.stock.vo.resp.R;
import com.li.stock.vo.resp.ResponseCode;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Author LiMingYu
 * @Create 2024-02-07 14:38
 * @Description 功能描述
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public SysUser findByUsername(String username) {
        return sysUserMapper.findUserInfoByName(username);
    }

    @Override
    public R<LoginRespVo> login(LoginReqVo loginReqVo) {
        //判断是否合法
        if (loginReqVo == null || StringUtils.isBlank(loginReqVo.getUsername()) || StringUtils.isBlank(loginReqVo.getPassword()) || StringUtils.isBlank(loginReqVo.getCode())) {
            return R.error(ResponseCode.DATA_ERROR);
        }
        //查询数据库，获取加密密码
        SysUser userInfoByName = sysUserMapper.findUserInfoByName(loginReqVo.getUsername());
        if (userInfoByName == null) {
            return R.error(ResponseCode.NO_RESPONSE_DATA);
        }
        //匹配密码
        if (passwordEncoder.matches(loginReqVo.getPassword(), userInfoByName.getPassword())) {
            return R.error(ResponseCode.USERNAME_OR_PASSWORD_ERROR);
        }
        LoginRespVo loginRespVo = new LoginRespVo();
        BeanUtils.copyProperties(userInfoByName, loginRespVo);
        return R.ok(loginRespVo);
    }
}
