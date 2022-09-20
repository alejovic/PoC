package com.avg.poc.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository repository;// a repository is a service (also).

    @Autowired
    PropertyPoC propertyPoC;

    @GetMapping("/hello")
    public String getMessage(){
        return "Hello world spring-boot!! " + repository.findEmployeeByNameContaining("Ale")
                + "properties -> " + propertyPoC.toString();
    }


}
