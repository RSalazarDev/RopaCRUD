/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import modelo.Prenda;
import modelo.PrendaCRUD;

/**
 * REST Web Service
 *
 * @author salaz
 */
@Path("ropaApi")
public class RopaApiResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RopaApiResource
     */
    public RopaApiResource() {
    }

     @GET
   @Path("/prendas/{id}")
   @Produces(MediaType.APPLICATION_JSON)
    public Prenda getPrendaJson(@PathParam("id") int id  ) {
        Prenda miPrenda = PrendaCRUD.getPrenda(id);
    return miPrenda;
    }
    
     @GET
   @Path("/prendas/")
   @Produces(MediaType.APPLICATION_JSON)
    public List<Prenda> getPrendas() {
        List<Prenda> prendas = PrendaCRUD.getPrendas();
    return prendas;
    }
    
    @PUT
    @Path("/prenda/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Prenda updatePrendas(Prenda prend) {
        PrendaCRUD.actualizaPrenda(prend);
        return prend;
    }
    
    @POST
    @Path("/prenda/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Prenda insertaPrenda(Prenda prend) {
        PrendaCRUD.insertaPrenda(prend);
        return prend;
    }
    
    @POST
    @Path("/prenda/{id}")
    public void borraPrenda(@PathParam("id") int id  ) {
        PrendaCRUD.borrarPrenda(id);
        
    }

    /**
     * PUT method for updating or creating an instance of RopaApiResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
