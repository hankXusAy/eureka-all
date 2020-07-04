package com.xss.eurekaprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
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
public class MainController {

    @Value("${server.port}")
    String port;

    @GetMapping("/getHi")
    public String getHi() {

        return "Hi!,我的port：" + port;
    }
    @GetMapping("/getMap")
    public Map getMap() {
        return Collections.singletonMap("id","10001");
    }

    @GetMapping("/getS")
    public Student getStudent() {
        Student student = new Student(1, "xiaoming");
        return student;
    }
    @GetMapping("/getS2")
    public Student getStudent2(String name) {
        Student student = new Student(1, name);
        return student;
    }
    @Autowired
    private HealthStatusService hsv;

    @GetMapping("/health")
    public String health(@RequestParam("status")Boolean status){
        hsv.setStatus(status);
        return hsv.getStatus();
    }

    @PostMapping("/postLocation")
    public URI postParm(@RequestBody Student student, HttpServletResponse response) throws URISyntaxException {
        URI uri = new URI("http://baidu.com/s?wd=" + student.getName());
        response.addHeader("Location",uri.toString());
        return uri;
    }
}
