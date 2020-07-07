package com.xss.userconsumer.controller;

import com.xss.userconsumer.service.UserApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName MainController
 * @Description
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/7/7 5:36 下午
 * @Return
 */
@RestController
public class MainController {

    @Autowired
    UserApi userApi;

    @GetMapping("/alive")
    public String alive(){
        return userApi.alive();
    }
    @GetMapping("/register")
    public String register(){
        return userApi.register();
    }
}
