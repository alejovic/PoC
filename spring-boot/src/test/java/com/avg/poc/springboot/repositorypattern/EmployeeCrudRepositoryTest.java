package com.avg.poc.springboot.repositorypattern;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.LinkedList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class EmployeeCrudRepositoryTest {

    @Autowired
    EmployeeCrudRepository repository;

    @Test
    void crud_repository_listAllEmployees() {
        final List<Employee> employees = new LinkedList<>();
        Iterable<Employee> iterator = repository.findAll();
        iterator.forEach(employees::add);

        employees.stream().forEach(System.out::println);
    }


}
