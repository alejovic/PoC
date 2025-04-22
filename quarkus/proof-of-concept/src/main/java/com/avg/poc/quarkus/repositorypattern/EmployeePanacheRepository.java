package com.avg.poc.quarkus.repositorypattern;


import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Using the active repository pattern.
@ApplicationScoped
public class EmployeePanacheRepository implements PanacheRepository<Employee> {

    public List<Employee> findEmployeeByNameContaining(String str) {
        Map<String, Object> params = new HashMap<>();
        params.put("nameStartsWith", "%"+ str + "%");
        return list("name like :nameStartsWith" ,params);
    }


}
