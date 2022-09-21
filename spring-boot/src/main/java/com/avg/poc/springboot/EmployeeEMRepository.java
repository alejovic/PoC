package com.avg.poc.springboot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class EmployeeEMRepository {

    @Autowired
    private EntityManager entityManager;

    List<Employee> findEmployeeByNameContaining(String str) {
        String jpql = "SELECT e FROM Employee e where e.name like :nameStartsWith";
        TypedQuery<Employee> query = entityManager.createQuery(jpql, Employee.class);
        return query.setParameter("nameStartsWith", "%"+ str + "%").getResultList();
    }

}
