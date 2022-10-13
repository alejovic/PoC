package com.avg.poc.quarkus;

import com.avg.poc.quarkus.activerecordpattern.EmployeeActiveRecordPanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.transaction.Transactional;
import java.util.List;

@QuarkusTest
public class EmployeeActiveRecordPanacheTest {

    @InjectMock
    Session session;

    @BeforeEach
    public void setup() {
        Query mockQuery = Mockito.mock(Query.class);
        Mockito.doNothing().when(session).persist(Mockito.any());
        Mockito.when(session.createQuery(Mockito.anyString())).thenReturn(mockQuery);
        Mockito.when(mockQuery.getSingleResult()).thenReturn(0l);
    }

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

    @Test
    public void testPanacheMocking() {
        PanacheMock.mock(EmployeeActiveRecordPanacheEntity.class);
        // Mocked classes always return a default value
        Assertions.assertEquals(0, EmployeeActiveRecordPanacheEntity.count());

        // Now let's specify the return value
        Mockito.when(EmployeeActiveRecordPanacheEntity.count()).thenReturn(23L);
        Assertions.assertEquals(23, EmployeeActiveRecordPanacheEntity.count());

    }

    @Test
    public void testPanachePersistMocking() {
        EmployeeActiveRecordPanacheEntity p = new EmployeeActiveRecordPanacheEntity();
        // mocked via EntityManager mocking
        p.persist();
        Assertions.assertNull(p.id);

        Mockito.verify(session, Mockito.times(1)).persist(Mockito.any());
    }

}
