package com.xss.userapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@RequestMapping("/user")
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

    /**
     * @ClassName UserAPI
     * @Description 这里的GetMapper是给Feign看的,用来组装url,组装一个get请求   user-provider/getById?id={占位符}
     *              @RequestParam("id")也是给Feign看的,只有写这个注解,Feign才会读到,并且组装参数
     *              Feign和OpenFeign的强制要求
     * @Author xushaoshuai
     * @Parameters [id]
     * @Date 2020/7/8 11:18 上午
     * @Return java.lang.String
     **/
    @GetMapping("/getById")
    String getById(@RequestParam("id") Integer id);

}
