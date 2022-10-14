package com.avg.poc.springboot;

import com.avg.poc.springboot.repositorypattern.EmployeeCrudRepository;
import com.avg.poc.springboot.repositorypattern.EmployeeEMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService {

    @Autowired
    EmployeeCrudRepository repository;// a repository is a service (also).

    @Autowired
    EmployeeEMRepository repositoryWithEM;// a repository with EM

    public String showEmployees(){
        return repository.findAll() + "";
    }

    public String showEmployeeByName(String name) {
        //return repository.findEmployeeByNameContaining(name).toString();
        return repositoryWithEM.findEmployeeByNameContaining(name).toString();
    }

}
