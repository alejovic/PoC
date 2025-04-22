package com.avg.poc.springboot.repositorypattern;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeCrudRepository extends CrudRepository<Employee, Long> {

    List<Employee> findEmployeeByNameContaining(String str);
}
