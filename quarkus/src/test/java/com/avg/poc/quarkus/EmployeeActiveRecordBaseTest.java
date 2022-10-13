package com.avg.poc.quarkus;

import com.avg.poc.quarkus.activerecordpattern.EmployeeActiveRecordPanacheEntity;
import com.avg.poc.quarkus.activerecordpattern.EmployeeActiveRecordEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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

    @Test
    public void testPanacheMocking() {
        PanacheMock.mock(EmployeeActiveRecordEntityBase.class);
        // Mocked classes always return a default value
        Assertions.assertEquals(0, EmployeeActiveRecordEntityBase.count());

        // Now let's specify the return value
        Mockito.when(EmployeeActiveRecordEntityBase.count()).thenReturn(23L);
        Assertions.assertEquals(23, EmployeeActiveRecordEntityBase.count());

    }

}
