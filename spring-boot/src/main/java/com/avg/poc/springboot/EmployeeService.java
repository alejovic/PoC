package com.avg.poc.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;// a repository is a service (also).

    public String showEmployees(){
        return repository.findAll() + "";
    }

    public String showEmployeeByName(String name) {
        return repository.findEmployeeByNameContaining(name).toString();
    }

}
