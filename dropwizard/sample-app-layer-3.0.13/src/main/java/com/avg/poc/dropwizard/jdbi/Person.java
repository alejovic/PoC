package com.avg.poc.dropwizard.jdbi;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class Person {

    @ColumnName("id")
    private long id;
    @ColumnName("name")
    private String name;
    @ColumnName("email")
    private String email;

    public Person() {}

    public Person(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
