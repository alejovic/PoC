package com.avg.poc.dropwizard.db;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class Person {

    private int id;
    private String name;
    private String email;

    public Person() {}

    public Person(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @ColumnName("id")
    public int getId() {
        return id;
    }

    @ColumnName("name")
    public String getName() {
        return name;
    }

    @ColumnName("email")
    public String getEmail() {
        return email;
    }
}
