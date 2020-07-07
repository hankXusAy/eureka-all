package com.xss.userconsumer.service;

import com.xss.userapi.UserAPI;
import org.springframework.cloud.openfeign.FeignClient;

//@FeignClient(name = "userApi",url = "http://user-provider/alive")
//@FeignClient(name = "userApi",url = "http://localhost:85/")
@FeignClient(name = "user-provider")
public interface UserConsumerApi extends UserAPI {

}
