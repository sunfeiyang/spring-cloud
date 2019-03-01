package com.sunfy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

// 添加RestController 修改为一个服务
@RestController
@SpringBootApplication
public class SayHelloApplication {

    /**
     * 问候语（模拟服务）
     */
    @RequestMapping("/greeting")
    public String greet(){
        List<String> greetings = Arrays.asList("hello1" ,"hello2" ,"hello3") ;
        Random r = new Random() ;
        // 每次调用时，随机返回字符串中的一个
        return greetings.get(r.nextInt(3)) ;
    }

    @RequestMapping("/")
    public String home(){
        return "Hi!!" ;
    }


    public static void main(String[] args) {
        SpringApplication.run(SayHelloApplication.class, args);
    }
}
