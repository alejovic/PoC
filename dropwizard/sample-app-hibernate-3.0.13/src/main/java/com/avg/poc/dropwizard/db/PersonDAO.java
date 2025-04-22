package com.avg.poc.dropwizard.db;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

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

    public List<Person> findAll() {
        Query<Person> query = currentSession().createQuery("FROM Person", Person.class);
        return query.list();
    }
}