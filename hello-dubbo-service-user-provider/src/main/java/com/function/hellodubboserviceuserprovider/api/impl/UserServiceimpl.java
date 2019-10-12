package com.function.hellodubboserviceuserprovider.api.impl;

import com.function.hello.dubbo.service.user.api.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

@Service(version = "${user.service.version}")
public class UserServiceimpl implements UserService {

    //默认${dubbo.application.name} is ${spring.application.name}
    @Value("${dubbo.application.name}")
    private String serviceName;

    @HystrixCommand//方法级别的
    @Override
    public String sayHi(String name) {
        return String.format("[%s] : Hello, %s", serviceName, name);
    }

    @HystrixCommand(commandProperties = {
            //2秒10次发生熔断
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutMilliseconds",value = "2000")
    })

    @Override
    public String testHystrix() {
        throw new RuntimeException("hello hystrix!");
    }
}
