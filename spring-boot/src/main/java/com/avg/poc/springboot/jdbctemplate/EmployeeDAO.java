package com.avg.poc.springboot.jdbctemplate;

import java.util.List;

//CRUD operations
public interface EmployeeDAO {

    //Create
    boolean save(Employee employee);
    //Read
    Employee getById(long id);
    //Update
    boolean update(Employee employee);
    //Delete
    boolean deleteById(long id);
    //Get All
    List<Employee> getAll();
}
