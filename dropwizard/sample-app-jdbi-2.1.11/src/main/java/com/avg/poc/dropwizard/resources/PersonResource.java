package com.avg.poc.dropwizard.resources;

import com.avg.poc.dropwizard.db.Person;
import com.avg.poc.dropwizard.db.PersonDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {
    private final PersonDAO dao;

    public PersonResource(PersonDAO dao) {
        this.dao = dao;
    }

    @POST
    public void insertPerson(Person person) {
        dao.insert(person);
    }

    @GET
    @Path("/{id}")
    public Person getPerson(@PathParam("id") int id) {
        return dao.findById(id).orElseThrow(() -> new NotFoundException("Person not found"));
    }

    @GET
    public List<Person> getAllPersons() {
        return dao.findAll();
    }
}
