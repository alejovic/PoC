package com.avg.poc.quarkus;

import com.avg.poc.quarkus.repositorypattern.EmployeePanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class EmployeeService {

    @Inject
    EmployeePanacheRepository panacheRepository;// a repository is a service (also).

    public String showEmployees(){
        return panacheRepository.findAll() + "";
    }

    public String showEmployeeByName(String name) {
        return panacheRepository.findEmployeeByNameContaining(name).toString();
    }

}
