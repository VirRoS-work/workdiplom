package rest;

import com.google.gson.Gson;
import model.Applicant;
import model.PersonalData;
import service.GenericService;
import service.PersonDataService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/personaldata")
public class PersonalDataRESTService {

    Gson gson = new Gson();
    GenericService<PersonalData, Long> service = new PersonDataService();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonalData(@PathParam("id") String id){

        PersonalData personalData = service.getObjectByPk(Long.valueOf(id));

        if(personalData != null) return Response.ok(gson.toJson(getPersonalData(personalData))).build();
        return Response.status(204).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletePersonalData(@PathParam("id") String id){

        if(service.getObjectByPk(Long.valueOf(id)) == null) return Response.status(204).build();

        service.delete(Long.valueOf(id));

        return Response.status(205).build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonalDatas(){

        List<PersonalData> personalDatas = service.getAll();
        for (PersonalData p : personalDatas) {
            p = getPersonalData(p);
        }

        return Response.ok(gson.toJson(personalDatas)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPersonalData(String personalData){

        PersonalData pd = gson.fromJson(personalData, PersonalData.class);

        if (pd.getId() != 0 && service.getObjectByPk(pd.getId()) == null) return Response.status(400).build();

        service.save(pd);
        return Response.status(201).build();
    }

    private PersonalData getPersonalData(PersonalData personalData){

        Applicant applicant = new Applicant();
        applicant.setId(personalData.getApplicant().getId());
        personalData.setApplicant(applicant);
        return personalData;
    }
}
