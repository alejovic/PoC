package com.avg.poc.springboot.daojdbc;

import java.util.List;

//CRUD operations
public interface EmployeeDAO {

    //Create
    void save(Employee employee);
    //Read
    Employee getById(long id);
    //Update
    void update(Employee employee);
    //Delete
    void deleteById(long id);
    //Get All
    List<Employee> getAll();
}
