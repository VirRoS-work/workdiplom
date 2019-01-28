package rest;

import com.google.gson.Gson;
import model.*;
import service.ApplicantService;
import service.GenericService;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Path("/applicant")
public class ApplicantRESTService {

    Gson gson = new Gson();
    GenericService<Applicant, Long> service = new ApplicantService();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getApplicant(@PathParam("id") String id){

        Applicant applicant = service.getObjectByPk(Long.valueOf(id));

        if(applicant != null) return Response.ok(gson.toJson(getApplicant(applicant))).build();
        return Response.status(204).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteApplicant(@PathParam("id") String id){

        if(service.getObjectByPk(Long.valueOf(id)) == null) return Response.status(204).build();

        service.delete(Long.valueOf(id));

        return Response.status(205).build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getApplicants(){

        List<Applicant> educations = service.getAll();
        for(Applicant applicant : educations){
           getApplicant(applicant);
        }
        return Response.ok(gson.toJson(educations)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addApplicant(String applicant){

        Applicant obj = gson.fromJson(applicant, Applicant.class);

        if (obj.getId() != 0 && service.getObjectByPk(obj.getId()) == null) return Response.status(400).build();

        service.save(obj);
        return Response.status(201).build();
    }

    private Applicant getApplicant(Applicant applicant){

        applicant.setLogin(null);
        applicant.setPassword(null);

        if(applicant.getContacts() != null){
            for (ContactsApplicant obj: applicant.getContacts()) {
                obj.setApplicant(null);
            }
        }
        if(applicant.getSpecializationApplicants() != null){
            for (SpecializationApplicant obj: applicant.getSpecializationApplicants()) {
                obj.setApplicant(null);
            }
        }
        if(applicant.getExperiences() != null){
            for (Experience obj: applicant.getExperiences()) {
                obj.setApplicant(null);
            }
        }
        if(applicant.getEducations() != null){
            for (Education obj: applicant.getEducations()) {
                obj.setApplicant(null);
            }
        }
        if(applicant.getLanguageSkills() != null){
            for (LanguageSkill obj: applicant.getLanguageSkills()) {
                obj.setApplicant(null);
            }
        }
        if(applicant.getEducations() != null){
            for (SportSkill obj: applicant.getSportSkills()) {
                obj.setApplicant(null);
            }
        }

        return applicant;
    }
}
