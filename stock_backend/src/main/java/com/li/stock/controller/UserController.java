package com.li.stock.controller;

import com.li.stock.pojo.entity.SysUser;
import com.li.stock.service.UserService;
import com.li.stock.vo.req.LoginReqVo;
import com.li.stock.vo.resp.LoginRespVo;
import com.li.stock.vo.resp.R;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author LiMingYu
 * @Create 2024-02-07 14:40
 * @Description 功能描述
 */
@RestController
@RequestMapping("/api")
@Api(tags = "用户相关接口")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取用户信息")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "userName", value = "用户名", required = true, dataType = "String", paramType = "path")
    )
    @GetMapping("/user/{userName}")
    public SysUser getUserInfoByUserName(@PathVariable("userName") String userName) {
        return userService.findByUsername(userName);
    }

    @ApiOperation(value = "用户登录")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "loginReqVo", value = "登录信息", required = true, dataType = "LoginReqVo", paramType = "body")
    )
    @PostMapping("/login")
    public R<LoginRespVo> login(@RequestBody LoginReqVo loginReqVo) {

        return userService.login(loginReqVo);
    }

    @GetMapping("/captcha")
    public R<Map> getCaptcha() {
        return userService.getCaptchaCode();
    }
}
