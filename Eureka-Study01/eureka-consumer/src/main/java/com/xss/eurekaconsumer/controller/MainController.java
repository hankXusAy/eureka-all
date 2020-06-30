package com.xss.eurekaconsumer.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @ClassName MainController
 * @Description
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/6/29 4:34 下午
 * @Return
 */
@RestController
public class MainController {

    @Autowired
    private DiscoveryClient client;
    @Autowired
    private EurekaClient eurekaClient;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/getHi")
    public String getHi(){
        return "hi";
    }

    @GetMapping("/client")
    public String client(){
        List<String> services = client.getServices();
        for (String service : services) {
            System.out.println(service);
        }
        return "hi";
    }

    @GetMapping("/client2")
    public Object client2(){
        return client.getInstances("provider");
    }
    @GetMapping("/client3")
    public Object client3(){
        List<ServiceInstance> provider = client.getInstances("provider");
        for (ServiceInstance instance : provider) {
            System.out.println(instance.getServiceId());
            System.out.println(instance.getUri());
            System.out.println(instance.getHost());
            System.out.println(instance.getMetadata());
            System.out.println(instance.getPort());
        }
        return "xxxx";
    }

    @GetMapping("/client4")
    public Object client4(){
        //具体的服务
        //List<InstanceInfo> instances = eurekaClient.getInstancesById("macbook-pro.lan:provider:80");
        //找列表
        List<InstanceInfo> instances = eurekaClient.getInstancesByVipAddress("provider", false);
        for (InstanceInfo instance : instances) {
            System.out.println(ToStringBuilder.reflectionToString(instance));
        }
        if (instances.size() > 0 ){
            InstanceInfo instanceInfo = instances.get(0);
            if(instanceInfo.getStatus() == InstanceInfo.InstanceStatus.UP){
                String url ="http://" + instanceInfo.getHostName() + ":"+  instanceInfo.getPort() + "/getHi";
                System.out.println("url: " + url);
                RestTemplate restTemplate = new RestTemplate();
                String forObject = restTemplate.getForObject(url, String.class);
                System.out.println("result: " + forObject);
            }
        }
        return "xxxx";
    }


    @GetMapping("/client5")
    public Object client5(){
        //ribbon 完成客户端的负载均衡,过滤掉down了的节点
        ServiceInstance instance = loadBalancerClient.choose("provider");
        String url ="http://" + instance.getHost() + ":"+  instance.getPort() + "/getHi";
        System.out.println("url: " + url);
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject(url, String.class);
        System.out.println("result: " + forObject);
        return "xxxx";
    }
}
