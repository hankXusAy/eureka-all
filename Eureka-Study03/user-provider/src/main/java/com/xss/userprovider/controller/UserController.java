package com.xss.userprovider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/7/4 5:51 下午
 * @Return
 */
@RestController
public class UserController {

    @GetMapping("/alive")
    public String alive() {
        return "ok";
    }
}
