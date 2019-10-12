package com.function.hellodubboserviceuserconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;

@EnableHystrix//开启熔断功能
@EnableHystrixDashboard
@SpringBootApplication
@ComponentScan(basePackages = {"org.apache.dubbo.spring.boot.actuate.endpoint.metadata","com.function.hellodubboserviceuserconsumer"})//不知道是不是dubbo的小bug
public class HelloDubboServiceUserConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloDubboServiceUserConsumerApplication.class, args);
    }

}
