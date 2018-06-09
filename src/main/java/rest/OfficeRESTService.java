package rest;

import com.google.gson.Gson;
import model.Office;
import service.GenericService;
import service.OfficeService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/office")
public class OfficeRESTService {

    Gson gson = new Gson();
    GenericService<Office, Long> off = new OfficeService();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOffice(@PathParam("id") String id){

        Office office = off.getObjectByPk(Long.valueOf(id));

        if(office != null){

            office.setEmployer(null);
            return Response.ok(gson.toJson(office)).build();
        }

        return Response.status(204).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addEmployer(String employer){

        off.save(gson.fromJson(employer, Office.class));

        return Response.status(201).build();
    }
}
