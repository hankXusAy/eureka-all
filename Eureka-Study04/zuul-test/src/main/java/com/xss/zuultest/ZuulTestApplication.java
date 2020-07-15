package com.xss.zuultest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class ZuulTestApplication {

    /*通过主机名+服务名称(spring.application.name)+方法名,zuul会将该请求转发到后台的consumer上,帮我们完成一次服务的中转*/
    public static void main(String[] args) {
        SpringApplication.run(ZuulTestApplication.class, args);
    }

}
