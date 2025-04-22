package com.avg.poc.dropwizard.db;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;
import java.util.Optional;

@RegisterBeanMapper(Person.class)
public interface PersonDAO {

    @SqlUpdate("CREATE TABLE IF NOT EXISTS persons (id INT PRIMARY KEY, name VARCHAR(100), email VARCHAR(100))")
    void createTable();

    @SqlUpdate("INSERT INTO persons (id, name, email) VALUES (:id, :name, :email)")
    void insert(@BindBean Person person);

    @SqlQuery("SELECT * FROM persons WHERE id = :id")
    @RegisterBeanMapper(Person.class)
    Optional<Person> findById(@Bind("id") int id);

    @SqlQuery("SELECT * FROM persons")
    @RegisterBeanMapper(Person.class)
    List<Person> findAll();
}
