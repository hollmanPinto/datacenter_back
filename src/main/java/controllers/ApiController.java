package controllers;

import beans.RecargaBean;
import beans.UsuarioBean;
import entities.dtos.SalidaBeanDto;
import entities.models.Recarga;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@RequestScoped
@Path("/api")
public class ApiController {
    @Inject
    UsuarioBean usuarioBean;
    @Inject
    RecargaBean recargaBean;

    /**
     * Endpoint para listar los usuarios en la base de datos
     * @return
     */
    @GET
    @Path("/listarUsuarios")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerUsuarios(){
        return Response.ok(usuarioBean.listarTodos()).build();
    }

    /**
     * Endpoint para listar todas las recargas en la base de datos
     * @return
     */
    @GET
    @Path("/listarRecargas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerRecargas(){
        return Response.ok(recargaBean.listarRecargas()).build();
    }

    /**
     * Endpoint para realizar una recarga
     * @param recarga
     * @return
     */
    @POST
    @Path("/recargar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response recargarValor(Recarga recarga){
        SalidaBeanDto salida = recargaBean.crearRecarga(recarga);
        return Response.status(salida.getStatus()).entity(salida.getMensajeSalidaDto()).build();
    }

    /**
     * Endpoint para obtener el consolidado de recargas por operador
     * @param oper
     * @return
     */
    @GET
    @Path("/consolidado")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consolidadoOperador(@QueryParam("oper") String oper){
        SalidaBeanDto salida = recargaBean.consolidadoRecargasOperador(oper);
        return Response.status(salida.getStatus()).entity(salida.getMensajeSalidaDto()).build();
    }
}