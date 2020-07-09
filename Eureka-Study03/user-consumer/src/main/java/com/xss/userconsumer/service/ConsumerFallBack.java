package com.xss.userconsumer.service;

import com.xss.userapi.UserAPI;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @ClassName ConsumerFallBack
 * @Description
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/7/9 4:28 下午
 * @Return
 */
@Component
public class ConsumerFallBack implements UserConsumerApi {

    @Override
    public String alive() {
        return "降级了";
    }

    @Override
    public String getById(Integer id) {
        return null;
    }

    @Override
    public Map<Integer, String> getMap(Integer id) {
        return null;
    }

    @Override
    public Map<Integer, String> getMap2(Integer id, String name) {
        return null;
    }

    @Override
    public Map<Integer, String> getMap3(Map<String, Object> map) {
        return null;
    }

    @Override
    public Map<Integer, String> postMap(Map<String, Object> map) {
        return null;
    }

}
