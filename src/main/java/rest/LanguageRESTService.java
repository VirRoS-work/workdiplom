package rest;

import com.google.gson.Gson;
import model.Applicant;
import model.Language;
import service.GenericService;
import service.LanguageService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/language")
public class LanguageRESTService {

    Gson gson = new Gson();
    GenericService<Language, Long> service = new LanguageService();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLanguage(@PathParam("id") String id){

        Language language = service.getObjectByPk(Long.valueOf(id));

        if(language != null) return Response.ok(gson.toJson(getLanguage(language))).build();
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

        List<Language> languages = service.getAll();
        for (Language l : languages) {
            l = getLanguage(l);
        }

        return Response.ok(gson.toJson(languages)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addLanguage(String language){

        Language lang = gson.fromJson(language, Language.class);

        if (lang.getId() != 0 && service.getObjectByPk(lang.getId()) == null) return Response.status(400).build();

        service.save(lang);
        return Response.status(201).build();
    }

    private Language getLanguage(Language language){

        Applicant applicant = new Applicant();
        applicant.setId(language.getApplicant().getId());
        language.setApplicant(applicant);
        return language;
    }

}
