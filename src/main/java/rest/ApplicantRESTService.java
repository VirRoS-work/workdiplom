package rest;

import com.google.gson.Gson;
import model.Applicant;
import service.ApplicantService;
import service.GenericService;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/applicant")
public class ApplicantRESTService {

    Gson gson = new Gson();
    GenericService<Applicant, Long> emp = new ApplicantService();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getApplicant(@PathParam("id") String id){

        Applicant applicant = emp.getObjectByPk(Long.valueOf(id));

        if(applicant != null) {
            return Response.ok(gson.toJson(applicant)).build();
        }
        return Response.status(204).build();
    }
}
