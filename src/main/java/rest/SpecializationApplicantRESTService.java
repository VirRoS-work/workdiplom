package rest;

import com.google.gson.Gson;
import model.Applicant;
import model.SpecializationApplicant;
import service.GenericService;
import service.SpecializationApplicantService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/specializationapplicant")
public class SpecializationApplicantRESTService {

    Gson gson = new Gson();
    GenericService<SpecializationApplicant, Long> service = new SpecializationApplicantService();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecializationApplicant(@PathParam("id") String id){

        SpecializationApplicant specializationApplicant = service.getObjectByPk(Long.valueOf(id));

        if(specializationApplicant != null) return Response.ok(gson.toJson(getSpecializationApplicant(specializationApplicant))).build();
        return Response.status(204).build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecializationApplicant(){

        List<SpecializationApplicant> specializations = service.getAll();
        for (SpecializationApplicant c : specializations){
            c = getSpecializationApplicant(c);
        }

        return Response.ok(gson.toJson(specializations)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteSpecializationApplicant(@PathParam("id") String id){

        if(service.getObjectByPk(Long.valueOf(id)) == null) return Response.status(204).build();

        service.delete(Long.valueOf(id));

        return Response.status(205).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addSpecializationApplicant(String specialization){

        SpecializationApplicant cont = gson.fromJson(specialization, SpecializationApplicant.class);

        if (cont.getId() != 0 && service.getObjectByPk(cont.getId()) == null) return Response.status(400).build();

        service.save(cont);
        return Response.status(201).build();
    }

    private SpecializationApplicant getSpecializationApplicant(SpecializationApplicant specializationApplicant){

        Applicant applicant = new Applicant();
        applicant.setId(specializationApplicant.getApplicant().getId());
        specializationApplicant.setApplicant(applicant);
        return specializationApplicant;

    }
}
