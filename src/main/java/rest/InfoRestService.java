package rest;

import com.google.gson.Gson;
import model.Constants;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/info")
public class InfoRestService {

    Gson gson = new Gson();
    Constants constants = new Constants();

    @GET
    @Path("/employer_types")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInfoTypeEmployers(){

        return Response.ok(gson.toJson(constants.typesConpany)).build();
    }

    @GET
    @Path("/count_employees")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInfoCountEmployers(){

        return Response.ok(gson.toJson(constants.countEmployeesConpany)).build();
    }

    @GET
    @Path("/employment_types")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInfoTypeEmployment() {
        return  Response.ok(gson.toJson(constants.typesEmployment)).build();
    }



}
