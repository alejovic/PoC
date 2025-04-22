package com.avg.poc.dropwizard.resources;

import com.avg.poc.dropwizard.db.Person;
import com.avg.poc.dropwizard.db.PersonDAO;
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

    private final PersonDAO personDAO;

    public PersonResource(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @POST
    @UnitOfWork // This annotation is used to manage transactions
    @Timed // This annotation is used to track the time taken by the method
    public Person createPerson(Person person) {
        return personDAO.create(person);
    }

    @GET
    @Path("/{id}")
    @UnitOfWork // This annotation is used to manage transactions
    @Timed // This annotation is used to track the time taken by the method
    public Response getPerson(@PathParam("id") Long id) {
        Optional<Person> person = personDAO.findById(id);
        if (person.isPresent()) {
            return Response.ok(person.get()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @UnitOfWork  // 👈 IMPORTANT! tells Dropwizard to open/close a Hibernate session
    @Timed // This annotation is used to track the time taken by the method
    public List<Person> getAllPersons() {
        return personDAO.findAll();
    }
}