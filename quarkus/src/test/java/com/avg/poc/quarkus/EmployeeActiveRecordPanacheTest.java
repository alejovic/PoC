package com.avg.poc.quarkus;

import com.avg.poc.quarkus.activerecordpattern.EmployeeActiveRecordPanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;
import java.util.List;

@QuarkusTest
public class EmployeeActiveRecordPanacheTest {

    @Test
    @Transactional
    public void whenValidEmployee_willBePersisted_ac() {
        EmployeeActiveRecordPanacheEntity employee = new EmployeeActiveRecordPanacheEntity();
        employee.name = "Alejandro";
        employee.persist();

        EmployeeActiveRecordPanacheEntity activeRecord = new EmployeeActiveRecordPanacheEntity();
        PanacheQuery<EmployeeActiveRecordPanacheEntity> list = activeRecord.findAll();
        list.stream().forEach(System.out::println);
    }

    @Test
    void listAllEmployees_ac() {
        EmployeeActiveRecordPanacheEntity activeRecord = new EmployeeActiveRecordPanacheEntity();
        PanacheQuery<EmployeeActiveRecordPanacheEntity> list = activeRecord.findAll();
        list.stream().forEach(System.out::println);
    }

    @Test
    void whenValidEmployeeName_willBeDisplayed_ac() {
        EmployeeActiveRecordPanacheEntity activeRecord = new EmployeeActiveRecordPanacheEntity();
        List<EmployeeActiveRecordPanacheEntity> list = activeRecord.findEmployeeByNameContaining("ua");
        list.stream().forEach(System.out::println);
    }

}
