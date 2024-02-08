package com.li.stock.service.impl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.li.stock.constant.StockConstant;
import com.li.stock.mapper.SysUserMapper;
import com.li.stock.pojo.entity.SysUser;
import com.li.stock.service.UserService;
import com.li.stock.utils.IdWorker;
import com.li.stock.vo.req.LoginReqVo;
import com.li.stock.vo.resp.LoginRespVo;
import com.li.stock.vo.resp.R;
import com.li.stock.vo.resp.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author LiMingYu
 * @Create 2024-02-07 14:38
 * @Description 功能描述
 */
@Service("userService")
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public SysUser findByUsername(String username) {
        return sysUserMapper.findUserInfoByName(username);
    }

    @Override
    public R<LoginRespVo> login(LoginReqVo loginReqVo) {
        //判断是否合法
        if (loginReqVo == null || StringUtils.isBlank(loginReqVo.getUsername()) || StringUtils.isBlank(loginReqVo.getPassword())) {
            return R.error(ResponseCode.DATA_ERROR);
        }

        if (StringUtils.isBlank(loginReqVo.getCode()) || StringUtils.isBlank(loginReqVo.getSessionId())) {
            return R.error(ResponseCode.DATA_ERROR);
        }

        //检验redis
        String redisCode = (String) redisTemplate.opsForValue().get(StockConstant.CHECK_PREFIX+loginReqVo.getSessionId());
        if (StringUtils.isBlank(redisCode)) {
            return R.error(ResponseCode.CHECK_TIMEOUT);
        }
        if (!redisCode.equalsIgnoreCase(loginReqVo.getCode())) {
            return R.error(ResponseCode.CHECK_CODE_ERROR);
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

    @Override
    public R<Map> getCaptchaCode() {
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(250, 40, 4, 5);
        String captchaCode = lineCaptcha.getCode();
        //获取base64后的数据
        String imageData = lineCaptcha.getImageBase64Data();
        //避免精度丢失
        String sessionId = String.valueOf(idWorker.nextId());
        //sessionId作为key，imageData为数据
        redisTemplate.opsForValue().set(StockConstant.CHECK_PREFIX +sessionId, captchaCode, 5, TimeUnit.MINUTES);
        //封装数据返回
        HashMap<String, String> data = new HashMap<>();
        data.put("imageData", imageData);
        data.put("sessionId", sessionId);
        return R.ok(data);
    }
}
