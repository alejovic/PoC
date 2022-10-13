package com.avg.poc.quarkus.activerecordpattern;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Using the active record pattern.
@Entity
@Table(name = "EMPLOYEES")
public class EmployeeActiveRecordEntityBase extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;

    public List<EmployeeActiveRecordEntityBase> findEmployeeByNameContaining(String str) {
        Map<String, Object> params = new HashMap<>();
        params.put("nameStartsWith", "%"+ str + "%");
        return list("name like :nameStartsWith" ,params);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
