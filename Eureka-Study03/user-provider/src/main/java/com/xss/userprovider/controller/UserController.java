package com.xss.userprovider.controller;

import com.xss.userapi.UserAPI;
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
public class UserController implements UserAPI {

    @Override
    public String alive() {
        return "ooxxoo";
    }

    @Override
    public String getById(Integer id) {
        return "我的id是"+id;
    }

}
