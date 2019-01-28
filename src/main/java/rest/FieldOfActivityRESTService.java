package rest;

import com.google.gson.Gson;
import model.FieldOfActivity;
import service.FieldOfActivityService;
import service.GenericService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/fieldofactivity")
public class FieldOfActivityRESTService {

    Gson gson = new Gson();
    GenericService<FieldOfActivity, Long> service = new FieldOfActivityService();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFieldOfActivity(@PathParam("id") String id){

        FieldOfActivity fieldOfActivity = service.getObjectByPk(Long.valueOf(id));

        if(fieldOfActivity != null) return Response.ok(gson.toJson(fieldOfActivity)).build();
        return Response.status(204).build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFieldOfActivity(){

        List<FieldOfActivity> fieldOfActivities = service.getAll();

        return Response.ok(gson.toJson(fieldOfActivities)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteFieldOfActivity(@PathParam("id") String id){

        if(service.getObjectByPk(Long.valueOf(id)) == null) return Response.status(204).build();

        service.delete(Long.valueOf(id));

        return Response.status(205).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addFieldOfActivity(String field){

        FieldOfActivity cont = gson.fromJson(field, FieldOfActivity.class);

        if (cont.getId() != 0 && service.getObjectByPk(cont.getId()) == null) return Response.status(400).build();

        service.save(cont);
        return Response.status(201).build();
    }
}
