package com.xss.eurekaconsumer.controller;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * @ClassName LoggingClientHttpRequestInterceptor
 * @Description rest请求拦截器
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/7/4 5:28 下午
 * @Return
 */
public class LoggingClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {

        System.out.println("拦截啦！！！");
        System.out.println(request.getURI());

        ClientHttpResponse response = execution.execute(request, body);

        System.out.println(response.getHeaders());
        return response;
    }
}