package com.sunfy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
// 成为一个服务
@RestController
// 申明为ribbon客户端
@EnableDiscoveryClient
public class UserApplication {

    @Bean
    // 负载均衡注解
    @LoadBalanced
    // 访问SpringCloud的关键
    RestTemplate restTemplate(){
        return new RestTemplate() ;
    }

    @Autowired
    // 自动装配对象
    private RestTemplate restTemplate ;

    @RequestMapping("/hi")
    public String hi(@RequestParam(value="name" , defaultValue = "springcloud") String name){
        // say-hello 为应用名称
        String greeting = this.restTemplate.getForObject("http://say-hello/greeting",String.class) ;
        // 返回值格式化
        return String.format("%s , %s!" ,greeting , name) ;
    }

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
