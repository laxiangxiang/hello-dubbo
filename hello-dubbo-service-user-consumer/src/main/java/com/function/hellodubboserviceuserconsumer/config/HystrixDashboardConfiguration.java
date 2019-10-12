package com.function.hellodubboserviceuserconsumer.config;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Springboot 2.x开启hystrix dashboard需要增加一个hystrixMetricsStreamServlet
 * 的配置，speingboot 1.x不用
 * 访问/hystrix打开页面,输入localhost:8081/hystrix.stream，其他随便输。多熔断几次即可观察到现象。
 */
@Configuration
public class HystrixDashboardConfiguration {

    /**
     * springboot注册bean的通用方式
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean();
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        registrationBean.setServlet(streamServlet);
        return registrationBean;
    }
}
