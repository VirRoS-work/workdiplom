package rest;

import com.google.gson.Gson;
import model.SpecializationVacancy;
import model.Vacancy;
import service.GenericService;
import service.SpecializationVacancyService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/specializationvacancy")
public class SpecializationVacancyRESTService {

    Gson gson = new Gson();
    GenericService<SpecializationVacancy, Long> service = new SpecializationVacancyService();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecializationVacancy(@PathParam("id") String id){

        SpecializationVacancy specializationVacancy = service.getObjectByPk(Long.valueOf(id));

        if(specializationVacancy != null) return Response.ok(gson.toJson(getSpecializationVacancy(specializationVacancy))).build();
        return Response.status(204).build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpecializationVacancy(){

        List<SpecializationVacancy> specializations = service.getAll();
        for (SpecializationVacancy c : specializations){
            c = getSpecializationVacancy(c);
        }

        return Response.ok(gson.toJson(specializations)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteSpecializationVacancy(@PathParam("id") String id){

        if(service.getObjectByPk(Long.valueOf(id)) == null) return Response.status(204).build();

        service.delete(Long.valueOf(id));

        return Response.status(205).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addSpecializationVacancy(String specialization){

        SpecializationVacancy cont = gson.fromJson(specialization, SpecializationVacancy.class);

        if (cont.getId() != 0 && service.getObjectByPk(cont.getId()) == null) return Response.status(400).build();

        service.save(cont);
        return Response.status(201).build();
    }

    private SpecializationVacancy getSpecializationVacancy(SpecializationVacancy specializationVacancy){

        Vacancy vacancy = new Vacancy();
        vacancy.setId(specializationVacancy.getVacancy().getId());
        specializationVacancy.setVacancy(vacancy);
        return specializationVacancy;

    }
}
