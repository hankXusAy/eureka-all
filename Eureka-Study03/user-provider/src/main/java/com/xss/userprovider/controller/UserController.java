package com.xss.userprovider.controller;

import com.xss.userapi.UserAPI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

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


    @Value("${server.port}")
    String port;


    private AtomicInteger count = new AtomicInteger();

//    @Override
//    public String alive() {
//        /*所有的超时时间设置和重试次数和负载设置,都是在客户端设置,服务提供方只提供服务,
//        调用某个节点失败,6s之内不会再调取这个节点(有可能是因为网络的原因导致的,不会下线服务,6s后还是会访问这个节点),
//        但是如果服务已经死了,6s后还是会调用这个节点,因此不够灵活,也不是最好的方案*/
//
//        try {
//            System.out.println("准备睡");
//            Thread.sleep(400);
////            Thread.sleep(400);
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//        int i = count.getAndIncrement();
////        System.out.println(port + "====坏的第：" + i + "次调用");
//        System.out.println(port + "====好的第：" + i + "次调用");
//        return "port:" + port;
//    }
    @Override
    public String alive() {
       int i = 1/0;
        return "port:" + port;
    }
    @Override
    public String getById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @GetMapping("/getMap")
    public Map<Integer, String> getMap(@RequestParam("id") Integer id) {
        // TODO Auto-generated method stub
        System.out.println(id);
        return Collections.singletonMap(id, "mmeme");
    }
    @GetMapping("/getMap2")
    public Map<Integer, String> getMap2(Integer id,String name) {
        // TODO Auto-generated method stub
        System.out.println(id);
        return Collections.singletonMap(id, name);
    }

    @GetMapping("/getMap3")
    public Map<Integer, String> getMap3(@RequestParam Map<String, Object> map) {
        // TODO Auto-generated method stub
        System.out.println(map);
        return Collections.singletonMap(Integer.parseInt(map.get("id").toString()), map.get("name").toString());
    }


    @PostMapping("/postMap")
    public Map<Integer, String> postMap(@RequestBody Map<String, Object> map) {
        // TODO Auto-generated method stub
        System.out.println(map);
        return Collections.singletonMap(Integer.parseInt(map.get("id").toString()), map.get("name").toString());
    }



}
