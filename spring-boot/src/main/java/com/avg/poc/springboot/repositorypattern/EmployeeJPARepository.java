package com.avg.poc.springboot.repositorypattern;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeJPARepository extends CrudRepository<Employee, Long> {

    List<Employee> findEmployeeByNameContaining(String str);

}
