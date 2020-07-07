package com.xss.userconsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(name = "userApi",url = "http://user-provider/alive")
@FeignClient(name = "userApi",url = "http://localhost:85/")
public interface UserApi {

    @GetMapping("/alive")
    String alive();

    @GetMapping("/register")
    String register();
}
