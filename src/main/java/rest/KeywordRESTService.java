package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/keywords")
public class KeywordRESTService {

    @GET
    public Response getMsg() {

        String output = "test servise";

        return Response.status(200).entity(output).build();

    }

}
