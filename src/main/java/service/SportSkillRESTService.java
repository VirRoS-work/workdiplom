package service;

import com.google.gson.Gson;
import model.Applicant;
import model.SportSkill;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/sportskill")
public class SportSkillRESTService {

    Gson gson = new Gson();
    GenericService<SportSkill, Long> service = new SportSkillService();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSportSkill(@PathParam("id") String id){

        SportSkill sportSkill = service.getObjectByPk(Long.valueOf(id));

        if(sportSkill != null) return Response.ok(gson.toJson(getSportSkill(sportSkill))).build();
        return Response.status(204).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteSportSkill(@PathParam("id") String id){

        if(service.getObjectByPk(Long.valueOf(id)) == null) return Response.status(204).build();

        service.delete(Long.valueOf(id));

        return Response.status(205).build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSportSkills(){

        List<SportSkill> skills = service.getAll();
        for(SportSkill sportSkill : skills){
            sportSkill = getSportSkill(sportSkill);
        }

        return Response.ok(gson.toJson(skills)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addSportSkill(String sportSkill){

        SportSkill skill = gson.fromJson(sportSkill, SportSkill.class);

        if (skill.getId() != 0 && service.getObjectByPk(skill.getId()) == null) return Response.status(400).build();

        service.save(skill);
        return Response.status(201).build();
    }

    private SportSkill getSportSkill(SportSkill sportSkill){
        Applicant applicant = new Applicant();
        applicant.setId(sportSkill.getApplicant().getId());
        sportSkill.setApplicant(applicant);
        return sportSkill;
    }
}
