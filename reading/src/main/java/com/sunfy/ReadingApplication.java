package com.sunfy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
//启用熔断器
@EnableCircuitBreaker
public class ReadingApplication {

    @Autowired
    private BookService  bookService ;

    @RequestMapping("/to-read")
    public String toRead(){
        return bookService.readingList() ;
    }

    public static void main(String[] args) {
        SpringApplication.run(ReadingApplication.class, args);
    }
}
