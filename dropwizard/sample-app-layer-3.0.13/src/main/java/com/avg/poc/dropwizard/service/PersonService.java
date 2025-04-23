package com.avg.poc.dropwizard.service;

import com.avg.poc.dropwizard.repository.PersonDTO;
import com.avg.poc.dropwizard.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

public class PersonService {

    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public PersonDTO createPerson(PersonDTO person) {
        repository.insert(person);
        return person;
    }

    public Optional<PersonDTO> findPersonById(Long id) {
        return repository.findById(id);
    }

    public List<PersonDTO> findAllPeople() {
        return repository.findAll();
    }
}
