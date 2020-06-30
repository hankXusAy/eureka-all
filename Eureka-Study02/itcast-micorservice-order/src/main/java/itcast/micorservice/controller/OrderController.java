package itcast.micorservice.controller;

import itcast.micorservice.entity.OrderInfo;
import itcast.micorservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    LoadBalancerClient loadBalancerClient;

    @GetMapping("/v1/order/{orderId}")
    public OrderInfo queryOrder(@PathVariable("orderId")String orderId){
        return orderService.queryOrderInfo(orderId);
    }
}
