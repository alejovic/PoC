package com.example.demo.repository;


import com.example.demo.model.Employee;
import com.example.demo.model.Manager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ApplicationRepositoryTest {

    @Mock
    private ManagerRepository managerRepository;
    @Mock
    private EmployeeRepository employeeRepository;

    Manager mockManager;

    @BeforeEach
    public void init() {
        Employee mockEmployee1 = new Employee();
        mockEmployee1.setId(1L);
        mockEmployee1.setName("mockEmployee01");

        Employee mockEmployee2 = new Employee();
        mockEmployee2.setId(2L);
        mockEmployee2.setName("mockEmployee02");

        mockManager = new Manager();
        mockManager.setId(1L);
        mockManager.setName("mockManager01");

        mockManager.setEmployees(List.of(mockEmployee1, mockEmployee2));
    }

    @Test
    @Transactional
    public void givenAnManager_whenSaveManager_thenSaveEmployee() {
        // given

        // when
        when(managerRepository.save(any(Manager.class))).thenReturn(mockManager);
        when(managerRepository.findAll()).thenReturn(List.of(mockManager));
        when(employeeRepository.findAll()).thenReturn(mockManager.getEmployees());
        // act
        Manager retrievedManager = managerRepository.save(mockManager);
        List<Manager> retrievedManagers = managerRepository.findAll();
        List<Employee> retrievedEmployes = employeeRepository.findAll();
        // then
        Assertions.assertThat(retrievedManager.getId()).isEqualTo(1);
        Assertions.assertThat(retrievedManagers.size()).isEqualTo(1);
        Assertions.assertThat(retrievedEmployes.size()).isEqualTo(2);

        verify(managerRepository).save(mockManager);
        verify(managerRepository).findAll();
        verify(employeeRepository).findAll();
    }

    @Test
    @Transactional
    public void givenAnManager_whenDeleteManager_thenEmptyManager() {
        // given

        //when
        when(managerRepository.findAll()).thenReturn(Collections.EMPTY_LIST);
        when(employeeRepository.findAll()).thenReturn(Collections.EMPTY_LIST);
        managerRepository.delete(mockManager);
        List<Manager> retrievedManagers = managerRepository.findAll();
        List<Employee> retrievedEmployes = employeeRepository.findAll();
        Assertions.assertThat(retrievedManagers).isEmpty();
        Assertions.assertThat(retrievedEmployes).isEmpty();

        verify(managerRepository).delete(mockManager);
        verify(managerRepository).findAll();
        verify(employeeRepository).findAll();
    }

}
