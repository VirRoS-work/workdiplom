package rest;

import com.google.gson.Gson;
import model.Applicant;
import model.Education;
import model.Experience;
import service.EducationService;
import service.GenericService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/education")
public class EducationRESTService {

    Gson gson = new Gson();
    GenericService<Education, Long> service = new EducationService();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEducation(@PathParam("id") String id){

        Education education = service.getObjectByPk(Long.valueOf(id));

        if(education != null) return Response.ok(gson.toJson(getEducation(education))).build();
        return Response.status(204).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteEducation(@PathParam("id") String id){

        if(service.getObjectByPk(Long.valueOf(id)) == null) return Response.status(204).build();

        service.delete(Long.valueOf(id));

        return Response.status(205).build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEducations(){

        List<Education> educations = service.getAll();
        for (Education obj : educations) {
            obj = getEducation(obj);
        }

        return Response.ok(gson.toJson(educations)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addEducation(String education){

        Education obj = gson.fromJson(education, Education.class);

        if (obj.getId() != 0 && service.getObjectByPk(obj.getId()) == null) return Response.status(400).build();

        service.save(obj);
        return Response.status(201).build();
    }

    private Education getEducation(Education education){

        Applicant applicant = new Applicant();
        applicant.setId(education.getApplicant().getId());
        education.setApplicant(applicant);
        return education;
    }
}
