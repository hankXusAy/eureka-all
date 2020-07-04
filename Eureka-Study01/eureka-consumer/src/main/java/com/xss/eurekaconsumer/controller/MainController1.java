package com.xss.eurekaconsumer.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @ClassName MainController
 * @Description
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/6/29 4:34 下午
 * @Return
 */
@RestController
public class MainController1 {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/client7")
    public Object client7(){
        String url ="http://provider/getHi";
        String respStr = restTemplate.getForObject(url, String.class);
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        System.out.println(forEntity);
        return respStr;
    }
    @GetMapping("/client8")
    public Object client8(){
        String url ="http://provider/getMap";
        Map forObject = restTemplate.getForObject(url, Map.class);
        return forObject;
    }

    @GetMapping("/client9")
    public Student client9(){
        String url ="http://provider/getS";
        Student student = restTemplate.getForObject(url,Student.class);
        return student;
    }
    @GetMapping("/client10")
    public Student client10(){
        String url ="http://provider/getS2?name={1}";
        Student student = restTemplate.getForObject(url,Student.class,"laowang");
        return student;
    }
    @GetMapping("/client11")
    public Student client11(){
        String url ="http://provider/getS2?name={name}";
        Map<String, String> map = Collections.singletonMap("name", "tom");
        Student student = restTemplate.getForObject(url,Student.class,map);
        return student;
    }
    @GetMapping("/client12")
    public Object client12(HttpServletResponse response) throws IOException {
        String url ="http://provider/postLocation";
        Map<String, String> map = Collections.singletonMap("name", "memeda");
        URI uri = restTemplate.postForLocation(url, map, Student.class);
        response.sendRedirect(uri.toURL().toString());
        return null;
    }
}
