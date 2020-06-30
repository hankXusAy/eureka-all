package itcast.micorservice.service;

import itcast.micorservice.entity.Item;
import itcast.micorservice.entity.OrderDetail;
import itcast.micorservice.entity.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class OrderService {
    @Autowired
    private ItemService itemService;
    private static final Map<String,Object> MAP = new HashMap<>();
    static {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderId("12345678");
        orderInfo.setCreateDate(new Date());
        orderInfo.setUpdateDate(orderInfo.getCreateDate());
        orderInfo.setUserId(1L);
        List<OrderDetail> list = new ArrayList<>();
        Item i1 = new Item();
        i1.setId(1L);
        Item i2 = new Item();
        i2.setId(2L);
        list.add(new OrderDetail(orderInfo.getOrderId(),i1));
        list.add(new OrderDetail(orderInfo.getOrderId(),i2));

        orderInfo.setList(list);
        MAP.put(orderInfo.getOrderId(),orderInfo);
    }
    public OrderInfo queryOrderInfo(String orderId){
        OrderInfo orderInfo = (OrderInfo)MAP.get(orderId);
        List<OrderDetail> orderDetails = orderInfo.getList();
        for (OrderDetail orderDetail : orderDetails) {
            Long id = orderDetail.getItem().getId();
            Item item = itemService.queryItemById(id);
            orderDetail.setItem(item);
        }
        return orderInfo;
    }
}
