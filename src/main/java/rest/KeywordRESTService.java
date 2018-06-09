package rest;

import com.google.gson.Gson;
import model.Keyword;
import service.GenericService;
import service.KeywordService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/keywords")
public class KeywordRESTService {

    Gson gson = new Gson();
    GenericService<Keyword, Long> key = new KeywordService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getKeywords() {

        return Response.ok(gson.toJson(key.getAll())).build();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addKeyword(String keyword){

        key.save(gson.fromJson(keyword, Keyword.class));

        return Response.ok().build();
    }

}