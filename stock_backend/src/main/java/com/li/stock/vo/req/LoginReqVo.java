package com.li.stock.vo.req;

import lombok.Data;

/**
 * @Author LiMingYu
 * @Create 2024-02-07 16:31
 * @Description 功能描述
 */
@Data
public class LoginReqVo {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    private String code;
    private String sessionId;
}