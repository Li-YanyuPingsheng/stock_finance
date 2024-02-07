package com.li.stock.controller;

import com.li.stock.pojo.entity.SysUser;
import com.li.stock.service.UserService;
import com.li.stock.vo.req.LoginReqVo;
import com.li.stock.vo.resp.LoginRespVo;
import com.li.stock.vo.resp.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author LiMingYu
 * @Create 2024-02-07 14:40
 * @Description 功能描述
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{userName}")
    public SysUser getUserInfoByUserName(@PathVariable("userName") String userName) {
        return userService.findByUsername(userName);
    }

    @PostMapping("/login")
    public R<LoginRespVo> login(@RequestBody LoginReqVo loginReqVo) {

        return userService.login(loginReqVo);
    }

}
