package com.li.stock;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author LiMingYu
 * @Create 2024-02-07 16:41
 * @Description 功能描述
 */
@SpringBootTest
public class TestPassword {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void testPassword1(){
        String pwd = "sb";
        String encode = passwordEncoder.encode(pwd);
        System.out.println(encode);
    }

    @Test
    public void testPassword2(){
        String pwd = "sb";
        boolean matches = passwordEncoder.matches(pwd, "$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.");
        System.out.println(matches ? "成功" : "失败");
    }
}
