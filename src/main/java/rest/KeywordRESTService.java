package rest;

import com.google.gson.Gson;
import model.Keyword;
import service.GenericService;
import service.KeywordService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/keyword")
public class KeywordRESTService {

    Gson gson = new Gson();
    GenericService<Keyword, Long> service = new KeywordService();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getKeyword(@PathParam("id") String id){

        Keyword keyword = service.getObjectByPk(Long.valueOf(id));

        if(keyword != null) return Response.ok(gson.toJson(keyword)).build();

        return Response.status(204).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteKeyword(@PathParam("id") String id){

        if(service.getObjectByPk(Long.valueOf(id)) == null) return Response.status(204).build();

        service.delete(Long.valueOf(id));

        return Response.status(205).build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getKeywords() {

        return Response.ok(gson.toJson(service.getAll())).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addKeyword(String keyword){

        service.save(gson.fromJson(keyword, Keyword.class));

        return Response.status(201).build();
    }

}