package com.xss.userconsumer.controller;

import com.xss.userconsumer.service.UserConsumerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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
    UserConsumerApi api;

//    @Autowired
//    MashibingApi mapi;

    @GetMapping("/alive")
    public String alive() {
        /**
         * URL 不能变
         *
         * jar
         * 文档
         */
        return api.alive();
    }


//    @GetMapping("/vip")
//    public String vip() {
//
//        return mapi.getVip();
//    }

    @GetMapping("/map")
    public Map<Integer, String> map(Integer id) {
        System.out.println(id);
        return api.getMap(id);
    }

    @GetMapping("/map2")
    public Map<Integer, String> map2(Integer id,String name) {
        System.out.println(id);
        return api.getMap2(id,name);
    }


    @GetMapping("/map3")
    public Map<Integer, String> map3(@RequestParam Map<String, Object> map) {
//		System.out.println(id);
//		HashMap<String, Object> map = new HashMap<>(2);
//
//		map.put("id", id);
//		map.put("name", name);
//		syso
        System.out.println(map);
        return api.getMap3(map);
    }


    @GetMapping("/map4")
    public Map<Integer, String> map4(@RequestParam Map<String, Object> map) {
//		System.out.println(id);
//		HashMap<String, Object> map = new HashMap<>(2);
//
//		map.put("id", id);
//		map.put("name", name);
//		syso
        System.out.println(map);
        return api.postMap(map);
    }
}
