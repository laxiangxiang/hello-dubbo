package com.function.hellodubboserviceuserconsumer.controller;

import com.function.hello.dubbo.service.user.api.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Reference(version = "${user.service.version}")
    private UserService userService;

    @HystrixCommand(fallbackMethod = "error")
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi(){
        String msg = "LXX";
        return userService.sayHi(msg);
    }

    @HystrixCommand(fallbackMethod = "error")
    @RequestMapping("/testHystrix")
    public String testHystrix(){
        return userService.testHystrix();
    }

    /**
     * 熔断方法
     * @return
     */
    public String error(){
        return "hello hystrix";
    }
}
