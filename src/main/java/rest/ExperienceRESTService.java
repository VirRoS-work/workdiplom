package rest;

import com.google.gson.Gson;
import model.Applicant;
import model.Employer;
import model.Experience;
import model.Specialization;
import service.ExperienceService;
import service.GenericService;
import service.SpecializationService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/experience")
public class ExperienceRESTService {

    Gson gson = new Gson();
    GenericService<Experience, Long> service = new ExperienceService();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getExperience(@PathParam("id") String id){

        Experience experience = service.getObjectByPk(Long.valueOf(id));

        if(experience != null) return Response.ok(gson.toJson(getExperience(experience))).build();
        return Response.status(204).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteExperience(@PathParam("id") String id){

        if(service.getObjectByPk(Long.valueOf(id)) == null) return Response.status(204).build();

        service.delete(Long.valueOf(id));

        return Response.status(205).build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getExperiences(){

        List<Experience> experiences = service.getAll();
        for (Experience obj : experiences) {
            obj = getExperience(obj);
        }

        return Response.ok(gson.toJson(experiences)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addExperience(String experience){

        Experience obj = gson.fromJson(experience, Experience.class);

        if (obj.getId() != 0 && service.getObjectByPk(obj.getId()) == null) return Response.status(400).build();

        service.save(obj);
        return Response.status(201).build();
    }

    private Experience getExperience(Experience experience){

        Applicant applicant = new Applicant();
        applicant.setId(experience.getApplicant().getId());
        experience.setApplicant(applicant);
        return experience;
    }
}
