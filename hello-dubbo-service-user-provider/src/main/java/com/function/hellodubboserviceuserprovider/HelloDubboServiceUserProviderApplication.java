package com.function.hellodubboserviceuserprovider;

import org.apache.dubbo.container.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;

@EnableHystrix//开启熔断功能
@SpringBootApplication
@ComponentScan("org.apache.dubbo.spring.boot.actuate.endpoint.metadata")//不知道是不是dubbo的小bug
public class HelloDubboServiceUserProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloDubboServiceUserProviderApplication.class, args);
        Main.main(args);
    }

}
