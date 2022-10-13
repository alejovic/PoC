package com.avg.poc.quarkus;

import com.avg.poc.quarkus.activerecordpattern.EmployeeActiveRecordEntity;
import com.avg.poc.quarkus.repositorypattern.Employee;
import com.avg.poc.quarkus.repositorypattern.EmployeePanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@QuarkusTest
public class EmployeeActiveRecordTest {

    @Test
    @Transactional
    public void whenValidEmployee_willBePersisted_ac() {
        EmployeeActiveRecordEntity employee = new EmployeeActiveRecordEntity();
        employee.name = "Alejandro";
        employee.persist();

        EmployeeActiveRecordEntity activeRecord = new EmployeeActiveRecordEntity();
        PanacheQuery<EmployeeActiveRecordEntity> list = activeRecord.findAll();
        list.stream().forEach(System.out::println);
    }

    @Test
    void listAllEmployees_ac() {
        EmployeeActiveRecordEntity activeRecord = new EmployeeActiveRecordEntity();
        PanacheQuery<EmployeeActiveRecordEntity> list = activeRecord.findAll();
        list.stream().forEach(System.out::println);
    }

    @Test
    void whenValidEmployeeName_willBeDisplayed_ac() {
        EmployeeActiveRecordEntity activeRecord = new EmployeeActiveRecordEntity();
        List<EmployeeActiveRecordEntity> list = activeRecord.findEmployeeByNameContaining("ua");
        list.stream().forEach(System.out::println);
    }

}
