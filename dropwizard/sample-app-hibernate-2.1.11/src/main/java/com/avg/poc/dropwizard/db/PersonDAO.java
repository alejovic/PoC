package com.avg.poc.dropwizard.db;

import java.util.Optional;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

public class PersonDAO extends AbstractDAO<Person> {

    public PersonDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Person create(Person person) {
        return persist(person);
    }

    public Optional<Person> findById(Long id) {
        return Optional.ofNullable(get(id));
    }
}