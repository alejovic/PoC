package com.avg.javaee9;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    @Inject
    private ProductEJB productEJB;

    @GET
    public List<Product> getAllProducts() {
        return productEJB.findAll();
    }

    @GET
    @Path("/{id}")
    public Response getProduct(@PathParam("id") Long id) {
        Product product = productEJB.findById(id);
        if (product == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(product).build();
    }

    @POST
    public Response createProduct(Product product) {
        productEJB.create(product);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateProduct(@PathParam("id") Long id, Product updated) {
        Product existing = productEJB.findById(id);
        if (existing == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        updated.setId(id);
        productEJB.update(updated);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteProduct(@PathParam("id") Long id) {
        Product existing = productEJB.findById(id);
        if (existing == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        productEJB.delete(id);
        return Response.ok().build();
    }
}
