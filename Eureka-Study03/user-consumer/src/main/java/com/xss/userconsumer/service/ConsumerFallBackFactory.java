package com.xss.userconsumer.service;

import feign.FeignException;
import feign.hystrix.FallbackFactory;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @ClassName ConsumerFallBackFactory
 * @Description
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/7/10 7:11 下午
 * @Return
 */
@Component
public class ConsumerFallBackFactory implements FallbackFactory<UserConsumerApi> {
    @Override
    public UserConsumerApi create(Throwable cause) {
        return new UserConsumerApi() {
            @Override
            public String alive() {
                System.out.println(cause);
                //打印栈信息
                cause.printStackTrace();
                if(cause instanceof FeignException.InternalServerError){
                    return "远程服务器错误" + cause.getLocalizedMessage();
                }
                System.out.println(ToStringBuilder.reflectionToString(cause));
                return "呵呵";
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
        };
    }
}
