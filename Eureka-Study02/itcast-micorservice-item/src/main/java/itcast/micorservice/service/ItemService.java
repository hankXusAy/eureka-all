package itcast.micorservice.service;

import itcast.micorservice.entity.Item;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class ItemService {
    public static Map<Long,Item> MAP = new HashMap<>();
    static {
        MAP.put(1L,new Item(1008801L,"电视机",2300));
        MAP.put(2L,new Item(1008802L,"电冰箱",4300));
        MAP.put(3L,new Item(1008803L,"电风扇",999));
        MAP.put(4L,new Item(1008804L,"电热毯",678));
        MAP.put(5L,new Item(1008805L,"电水壶",89));
        MAP.put(6L,new Item(1008806L,"被子",1876));
        MAP.put(7L,new Item(1008807L,"沙发",4444));
    }
    public Item getItem(Long num){
        return MAP.get(num);
    }
}
