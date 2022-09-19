package com.avg.poc.springboot;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    List<Employee> findEmployeeByNameContaining(String str);
}
