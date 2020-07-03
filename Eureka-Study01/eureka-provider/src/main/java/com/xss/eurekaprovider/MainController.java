package com.xss.eurekaprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Value("${server.port}")
    String port;

    @GetMapping("/getHi")
    public String getHi() {

        return "Hi!,我的port：" + port;
    }
    @Autowired
    private HealthStatusService hsv;

    @GetMapping("/health")
    public String health(@RequestParam("status")Boolean status){
        hsv.setStatus(status);
        return hsv.getStatus();
    }
}
