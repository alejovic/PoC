package com.avg.poc.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

    @GetMapping("/hello")
    public String getMessage(){
        return "Hello world spring-boot!!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
