package com.avg.poc.quarkus.activerecordpattern;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Using the active record pattern.
@Entity
@Table(name = "EMPLOYEES")
public class EmployeeActiveRecordEntity extends PanacheEntity {

    public String name;

    public List<EmployeeActiveRecordEntity> findEmployeeByNameContaining(String str) {
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
