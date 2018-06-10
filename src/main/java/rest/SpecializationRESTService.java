package rest;

import com.google.gson.Gson;
import model.Applicant;
import model.PersonalData;
import model.Specialization;
import service.GenericService;
import service.PersonDataService;
import service.SpecializationService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/specialization")
public class SpecializationRESTService {

    Gson gson = new Gson();
    GenericService<Specialization, Long> service = new SpecializationService();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecialization(@PathParam("id") String id){

        Specialization specialization = service.getObjectByPk(Long.valueOf(id));

        if(specialization != null) return Response.ok(gson.toJson(getSpecialization(specialization))).build();
        return Response.status(204).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteSpecialization(@PathParam("id") String id){

        if(service.getObjectByPk(Long.valueOf(id)) == null) return Response.status(204).build();

        service.delete(Long.valueOf(id));

        return Response.status(205).build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecializations(){

        List<Specialization> specializations = service.getAll();
        for (Specialization s : specializations) {
            s = getSpecialization(s);
        }

        return Response.ok(gson.toJson(specializations)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addSpecialization(String specialization){

        Specialization sp = gson.fromJson(specialization, Specialization.class);

        if (sp.getId() != 0 && service.getObjectByPk(sp.getId()) == null) return Response.status(400).build();

        service.save(sp);
        return Response.status(201).build();
    }

    private Specialization getSpecialization(Specialization specialization) {

        Applicant applicant = new Applicant();
        applicant.setId(specialization.getApplicant().getId());
        specialization.setApplicant(applicant);
        return specialization;
    }
}
