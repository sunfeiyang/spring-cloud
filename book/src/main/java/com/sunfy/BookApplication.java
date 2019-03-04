package com.sunfy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BookApplication {

    @RequestMapping("/available")
    public String available(){
        return "Spring in action" ;
    }

    @RequestMapping("/checked-out")
    public String checkedout(){
        return "Spring boot in action" ;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class, args);
    }
}
