package com.avg.poc.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @Autowired
    PropertyPoC propertyPoC;

    @GetMapping("/hello")
    public String getMessage() {
        return "Hello world spring-boot!! " + "properties -> " + propertyPoC.toString();
    }

    @GetMapping("/show")
    public String showEmployeeByName() {
        return service.showEmployeeByName("Ale");
    }

    @GetMapping("/")
    public String showEmployees() {
        return service.showEmployees();
    }

}
