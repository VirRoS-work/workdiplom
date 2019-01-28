package rest;

import com.google.gson.Gson;
import model.Applicant;
import model.LanguageSkill;
import service.GenericService;
import service.LanguageSkillService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/languageskill")
public class LanguageSkillRESTService {

    Gson gson = new Gson();
    GenericService<LanguageSkill, Long> service = new LanguageSkillService();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLanguage(@PathParam("id") String id){

        LanguageSkill language = service.getObjectByPk(Long.valueOf(id));

        if(language != null) return Response.ok(gson.toJson(getLanguageSkill(language))).build();
        return Response.status(204).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteLanguage(@PathParam("id") String id){

        if(service.getObjectByPk(Long.valueOf(id)) == null) return Response.status(204).build();

        service.delete(Long.valueOf(id));

        return Response.status(205).build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLanguages(){

        List<LanguageSkill> languages = service.getAll();
        for(LanguageSkill languageSkill : languages){
            languageSkill = getLanguageSkill(languageSkill);
        }

        return Response.ok(gson.toJson(languages)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addLanguage(String language){

        LanguageSkill lang = gson.fromJson(language, LanguageSkill.class);

        if (lang.getId() != 0 && service.getObjectByPk(lang.getId()) == null) return Response.status(400).build();

        service.save(lang);
        return Response.status(201).build();
    }

    private LanguageSkill getLanguageSkill(LanguageSkill languageSkill){
        Applicant applicant = new Applicant();
        applicant.setId(languageSkill.getApplicant().getId());
        languageSkill.setApplicant(applicant);
        return languageSkill;
    }
}
