package controllers;

import beans.PruebaBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@RequestScoped
@Path("/api")
public class ApiController {
    @Inject
    PruebaBean pruebaBean;

    @GET
    @Path("/saludar2")
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello(){
        return Response.ok(pruebaBean.prueba1()).build();
    }
}