package rest;

import com.google.gson.Gson;
import model.ContactType;
import service.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/contacttype")
public class ContactTypeRESTService {

    Gson gson = new Gson();
    GenericService<ContactType, Long> service = new ContactTypeService();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getContactType(@PathParam("id") String id){

        ContactType contactType = service.getObjectByPk(Long.valueOf(id));

        if(contactType != null) return Response.ok(gson.toJson(contactType)).build();
        return Response.status(204).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteContactType(@PathParam("id") String id){

        if(service.getObjectByPk(Long.valueOf(id)) == null) return Response.status(204).build();

        service.delete(Long.valueOf(id));

        return Response.status(205).build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getContactTypes(){

        List<ContactType> contactTypes = service.getAll();

        return Response.ok(gson.toJson(contactTypes)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addContactType(String contactType){

        ContactType cont = gson.fromJson(contactType, ContactType.class);

        if (cont.getId() != 0 && service.getObjectByPk(cont.getId()) == null) return Response.status(400).build();

        service.save(cont);
        return Response.status(201).build();
    }

}
