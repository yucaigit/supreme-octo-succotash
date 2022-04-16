package com.etc.demo.controller;

import com.etc.demo.entity.UserInfo;
import com.etc.demo.entity.Users;
import com.etc.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class UserController {
    private static String rquestUrl = "https://api.weixin.qq.com/sns/jscode2session?appid={appid}&secret={secret}&js_code={js_code}&grant_type={grant_type}";
    private static final String appId = "wx00184b78fbcf0d17";
    private static final String appSecret = "9f50f97c25b396f46a5de1879f15aed9";
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    UserService userService;

    @RequestMapping("/wxLogin")
    public Users wxLogin(UserInfo userInfo) {
//        返回一个用户对象
        Users user = userService.login(userInfo);
        return user;
    }
}

