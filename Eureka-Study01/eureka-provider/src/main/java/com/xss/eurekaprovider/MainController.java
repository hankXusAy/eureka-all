package com.xss.eurekaprovider;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/getHi")
    public String getHi(){
        return "hi";
    }
}
