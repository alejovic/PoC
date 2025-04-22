package com.example.demo.repository;

import com.example.demo.model.Employee;
import com.example.demo.model.Manager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@DataJpaTest
public class ApplicationRepositoryWithDatabaseTest {

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    private Manager mockManager;

    @BeforeEach
    public void init() {
        Employee mockEmployee1 = new Employee();
        mockEmployee1.setName("mockEmployee01");

        Employee mockEmployee2 = new Employee();
        mockEmployee2.setName("mockEmployee02");

        mockManager = new Manager();
        mockManager.setName("mockManager01");

        mockManager.setEmployees(List.of(mockEmployee1, mockEmployee2));
    }

    @Test
    @Transactional
    public void givenAnManager_whenSaveManager_thenSaveEmployee() {
        // act
        Manager savedManager = managerRepository.save(mockManager);
        List<Manager> retrievedManagers = managerRepository.findAll();
        List<Employee> retrievedEmployees = employeeRepository.findAll();

        // then
        Assertions.assertThat(savedManager.getId()).isEqualTo(1);
        Assertions.assertThat(retrievedManagers.size()).isEqualTo(1);
        Assertions.assertThat(retrievedEmployees.size()).isEqualTo(2);
    }

    @Test
    @Transactional
    public void givenAnManager_whenDeleteManager_thenEmptyManager() {
        // given
        List<Manager> retrievedManagers = managerRepository.findAll();
        for (Manager manager : retrievedManagers) {
            System.out.printf("Manager: %s%n", manager);
        }
        Manager retrievedManager = managerRepository.findById(1L).get();
        // when
        managerRepository.delete(retrievedManager);
        retrievedManagers = managerRepository.findAll();
        List<Employee> retrievedEmployees = employeeRepository.findAll();

        // then
        Assertions.assertThat(retrievedManagers).isEmpty();
        Assertions.assertThat(retrievedEmployees).isEmpty();
    }
}