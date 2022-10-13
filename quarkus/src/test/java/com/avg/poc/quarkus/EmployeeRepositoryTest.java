package com.avg.poc.quarkus;

import com.avg.poc.quarkus.repositorypattern.Employee;
import com.avg.poc.quarkus.repositorypattern.EmployeePanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@QuarkusTest
public class EmployeeRepositoryTest {

    @Inject
    EmployeePanacheRepository panacheRepository;

    @InjectMock
    EmployeePanacheRepository panacheMockRepository;

    @Test
    @Transactional
    public void whenValidEmployee_willBePersisted() {
        Employee employee = new Employee();
        employee.setName("Alejandro");
        panacheRepository.persist(employee);

        PanacheQuery<Employee> list = panacheRepository.findAll();
        list.stream().forEach(System.out::println);
    }

    @Test
    void listAllEmployees() {
        PanacheQuery<Employee> list = panacheRepository.findAll();
        list.stream().forEach(System.out::println);
    }

    @Test
    void whenValidEmployeeName_willBeDisplayed() {
        List<Employee> list = panacheRepository.findEmployeeByNameContaining("ua");
        list.stream().forEach(System.out::println);
    }

    @Test
    public void testPanacheRepositoryMocking() throws Throwable {
        // Mocked classes always return a default value
        Assertions.assertEquals(0, panacheMockRepository.count());

        // Now let's specify the return value
        Mockito.when(panacheMockRepository.count()).thenReturn(23L);
        Assertions.assertEquals(23, panacheMockRepository.count());
    }

}
