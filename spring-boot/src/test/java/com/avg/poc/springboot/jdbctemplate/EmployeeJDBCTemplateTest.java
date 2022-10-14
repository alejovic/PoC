package com.avg.poc.springboot.jdbctemplate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class EmployeeJDBCTemplateTest {

    @Autowired
    EmployeeDAOImpl employeeDAO;

    @Test
    void jdbctemplate_listAllEmployees() {
        employeeDAO.getAll().stream().forEach(System.out::println);
    }


}
