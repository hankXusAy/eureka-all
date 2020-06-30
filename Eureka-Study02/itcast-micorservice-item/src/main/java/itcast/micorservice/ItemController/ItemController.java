package itcast.micorservice.ItemController;

import itcast.micorservice.entity.Item;
import itcast.micorservice.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/v1/item/{num}")
    public Item getItem(@PathVariable("num") Long num){
        return itemService.getItem(num);
    }
}
