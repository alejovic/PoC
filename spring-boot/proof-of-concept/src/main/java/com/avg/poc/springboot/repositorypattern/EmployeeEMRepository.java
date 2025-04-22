package com.avg.poc.springboot.repositorypattern;

import java.util.List;

public interface EmployeeEMRepository {

    List<Employee> findEmployeeByNameContaining(String str);
}
