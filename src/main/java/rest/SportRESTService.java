package rest;

import com.google.gson.Gson;
import model.Sport;
import service.GenericService;
import service.SportService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/sport")
public class SportRESTService {

    Gson gson = new Gson();
    GenericService<Sport, Long> service = new SportService();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSport(@PathParam("id") String id){

        Sport sport = service.getObjectByPk(Long.valueOf(id));

        if(sport != null) return Response.ok(gson.toJson(sport)).build();
        return Response.status(204).build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSports(){

        List<Sport> sports = service.getAll();

        return Response.ok(gson.toJson(sports)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteSport(@PathParam("id") String id){

        if(service.getObjectByPk(Long.valueOf(id)) == null) return Response.status(204).build();

        service.delete(Long.valueOf(id));

        return Response.status(205).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addSport(String sport){

        Sport s = gson.fromJson(sport, Sport.class);

        if (s.getId() != 0 && service.getObjectByPk(s.getId()) == null) return Response.status(400).build();

        service.save(s);
        return Response.status(201).build();
    }
}
