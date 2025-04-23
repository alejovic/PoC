package com.avg.poc.dropwizard.dao;

import com.avg.poc.dropwizard.repository.PersonDTO;
import com.avg.poc.dropwizard.repository.PersonRepository;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PersonHibernate extends AbstractDAO<Person> implements PersonRepository {

    public PersonHibernate(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<PersonDTO> findAll() {
        Query<Person> query = currentSession().createQuery("FROM Person", Person.class);
        List<Person> people = query.list();
        return people.stream()
                .map(person -> new PersonDTO(person.getId(), person.getName(), person.getEmail()))
                .collect(Collectors.toList());
    }

    @Override
    public void insert(PersonDTO person) {
        Person newPerson = new Person();
        newPerson.setName(person.getName());
        newPerson.setEmail(person.getEmail());
        persist(newPerson);
        person.setId(newPerson.getId());
    }

    @Override
    public Optional<PersonDTO> findById(Long id) {
        Person person = get(id);
        return Optional.ofNullable(person)
                .map(p -> new PersonDTO(p.getId(), p.getName(), p.getEmail()));
    }

}