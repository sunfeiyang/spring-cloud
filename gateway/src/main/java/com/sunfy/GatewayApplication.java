package com.sunfy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
// 网关
@EnableZuulProxy
public class GatewayApplication {

    /**
     * 引入zuul过滤器
     * @return
     */
    @Bean
    public SimpleFilter simpleFilter(){
        return new SimpleFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

}
