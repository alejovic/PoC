package com.avg.poc.dropwizard.repository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {

    List<PersonDTO> findAll();

    void insert(PersonDTO person);

    Optional<PersonDTO> findById(Long id);
}
