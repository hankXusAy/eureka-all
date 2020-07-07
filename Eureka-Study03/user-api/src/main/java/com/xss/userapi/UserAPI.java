package com.xss.userapi;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
public interface UserAPI {

    /***
     * @ClassName UserAPI
     * @Description 查看当前服务状态~~~~
     * @Author xushaoshuai
     * @Parameters []
     * @Date 2020/7/7 7:15 下午
     * @Return (づ￣ 3￣)づ
     **/
    @RequestMapping("/alive")
    String alive();

    @RequestMapping("/getById")
    String getById(Integer id);

}
