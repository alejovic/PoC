package com.avg.poc.dropwizard.jdbi;


import com.avg.poc.dropwizard.repository.PersonDTO;
import com.avg.poc.dropwizard.repository.PersonRepository;
import org.jdbi.v3.core.Jdbi;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PersonJdbi implements PersonRepository {

    private final Jdbi jdbi;

    public PersonJdbi(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public List<PersonDTO> findAll() {
        List<Person> people = jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM person")
                        .mapToBean(Person.class)
                        .list()
        );
        return people.stream()
                .map(person -> new PersonDTO(person.getId(), person.getName(), person.getEmail()))
                .collect(Collectors.toList());
    }

    public void insert(PersonDTO person) {
        Person newPerson = new Person();
        newPerson.setName(person.getName());
        newPerson.setEmail(person.getEmail());

        jdbi.withHandle(handle ->
                handle.createUpdate("INSERT INTO person (name, email) VALUES (?, ?)")
                        .bind(0, newPerson.getName())
                        .bind(1, newPerson.getEmail())
                        .execute()
        );
    }

    public Optional<PersonDTO> findById(Long id) {
        Optional<Person> person = jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM person WHERE id = ?")
                        .bind(0, id)
                        .mapToBean(Person.class)
                        .findOne()
        );
        return Optional.ofNullable(person)
                .map(p -> new PersonDTO(p.get().getId(), p.get().getName(), p.get().getEmail()));
    }

}
