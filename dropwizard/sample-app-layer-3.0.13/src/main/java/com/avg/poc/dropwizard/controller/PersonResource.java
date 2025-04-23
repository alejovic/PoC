package com.avg.poc.dropwizard.controller;

import com.avg.poc.dropwizard.dao.Person;
import com.avg.poc.dropwizard.repository.PersonDTO;
import com.avg.poc.dropwizard.service.PersonService;
import com.codahale.metrics.annotation.Timed;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
public class PersonResource {

    private final PersonService personService;

    public PersonResource(PersonService personService) {
        this.personService = personService;
    }

    @POST
    @UnitOfWork // This annotation is used to manage transactions
    @Timed // This annotation is used to track the time taken by the method
    public PersonDTO createPerson(PersonDTO person) {
        return personService.createPerson(person);
    }

    @GET
    @Path("/{id}")
    @UnitOfWork // This annotation is used to manage transactions
    @Timed // This annotation is used to track the time taken by the method
    public Response getPerson(@PathParam("id") Long id) {
        Optional<PersonDTO> person = personService.findPersonById(id);
        if (person.isPresent()) {
            return Response.ok(person.get()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @UnitOfWork  // 👈 IMPORTANT! tells Dropwizard to open/close a Hibernate session
    @Timed // This annotation is used to track the time taken by the method
    public List<PersonDTO> getAllPersons() {
        return personService.findAllPeople();
    }
}