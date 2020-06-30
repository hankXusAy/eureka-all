package itcast.micorservice.service;

import itcast.micorservice.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
//    @Value("${item.url}")
//    private String url;
//    public Item queryItemById(Long id){
//        Item item = restTemplate.getForObject(url+id,Item.class);
//        return item;
//    }
    public Item queryItemById(Long id){
        String serviceId = "itcast-micorservice-item";
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
//        int size = instances.size();
//        for (ServiceInstance instance : instances) {
//            int port = instance.getPort();
//            String host = instance.getHost();
//            Map<String, String> metadata = instance.getMetadata();
//            String serviceId1 = instance.getServiceId();
//            URI uri = instance.getUri();
//            System.out.println(instance.toString());
//        }
        ServiceInstance serviceInstance = instances.get(0);
        String url = "http://"+serviceInstance.getHost() + ":" + serviceInstance.getPort();
        Item item = restTemplate.getForObject(url + "/v1/item/" + id, Item.class);
        return item;
    }
}
