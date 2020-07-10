package com.xss.userconsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName RestService
 * @Description
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/7/10 7:48 下午
 * @Return
 */
@Service
public class RestService {

    @Autowired
    RestTemplate restTemplate;
    @HystrixCommand(defaultFallback = "back")
    public String alive() {
        String url ="http://user-provider/alive";
        String respStr = restTemplate.getForObject(url, String.class);
        return respStr;
    }
    public String back(){
        return "呵呵呵";
    }
}
