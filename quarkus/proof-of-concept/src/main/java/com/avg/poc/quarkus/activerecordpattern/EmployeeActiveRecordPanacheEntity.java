package com.avg.poc.quarkus.activerecordpattern;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Using the active record pattern.
@Entity
@Table(name = "EMPLOYEES")
public class EmployeeActiveRecordPanacheEntity extends PanacheEntity {

    public String name;

    public List<EmployeeActiveRecordPanacheEntity> findEmployeeByNameContaining(String str) {
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
