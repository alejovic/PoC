package com.avg.poc.quarkus;

import com.avg.poc.quarkus.activerecordpattern.EmployeeActiveRecordPanacheEntity;
import com.avg.poc.quarkus.activerecordpattern.EmployeeActiveRecordEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
public class EmployeeActiveRecordBaseTest {

    @Test
    @Transactional
    public void whenValidEmployee_willBePersisted_ac() {
        EmployeeActiveRecordEntityBase employee = new EmployeeActiveRecordEntityBase();
        employee.name = "Alejandro";
        employee.persist();
        assertThat(employee.isPersistent()).isTrue();

        EmployeeActiveRecordEntityBase activeRecord = new EmployeeActiveRecordEntityBase();
        PanacheQuery<EmployeeActiveRecordEntityBase> list = activeRecord.findAll();
        list.stream().forEach(System.out::println);
    }

    @Test
    void listAllEmployees_ac() {
        EmployeeActiveRecordEntityBase activeRecord = new EmployeeActiveRecordEntityBase();
        PanacheQuery<EmployeeActiveRecordPanacheEntity> list = activeRecord.findAll();
        list.stream().forEach(System.out::println);
    }

    @Test
    void whenValidEmployeeName_willBeDisplayed_ac() {
        EmployeeActiveRecordEntityBase activeRecord = new EmployeeActiveRecordEntityBase();
        List<EmployeeActiveRecordEntityBase> list = activeRecord.findEmployeeByNameContaining("ua");
        list.stream().forEach(System.out::println);
    }

}
