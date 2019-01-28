package rest;

import com.google.gson.Gson;
import model.Employer;
import model.Office;
import model.SpecializationVacancy;
import model.Vacancy;
import service.EmployerService;
import service.GenericService;
import service.VacancyService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Path("/vacancy")
public class VacancyRESTService {

    Gson gson = new Gson();
    GenericService<Vacancy, Long> service = new VacancyService();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVacancy(@PathParam("id") String id){

        Vacancy vacancy = service.getObjectByPk(Long.valueOf(id));

        if(vacancy != null) {
            return Response.ok(gson.toJson(getVacancy(vacancy))).build();
        }

        return Response.status(204).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteSummary(@PathParam("id") String id){

        if(service.getObjectByPk(Long.valueOf(id)) == null) return Response.status(204).build();

        service.delete(Long.valueOf(id));

        return Response.status(205).build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVacancies(){

        List<Vacancy> vacancies = service.getAll();

        for (Vacancy v: vacancies) {
            v = getVacancy(v);
        }

        return Response.ok(gson.toJson(vacancies)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addVacancy(String vacancy){

        Vacancy vacancy1 = gson.fromJson(vacancy, Vacancy.class);

        if (vacancy1.getOffice() != null && vacancy1.getOffice().getId() == 0){
            vacancy1.setOffice(null);
        }

        service.save(vacancy1);

        return Response.status(201).build();
    }

    @PUT
    @Path("/{id}/status")
    public Response editStatusVacancy(@PathParam("id") String id){

        if(service.getObjectByPk(Long.valueOf(id)) == null) return Response.status(204).build();
        else {
            Vacancy vacancy = service.getObjectByPk(Long.valueOf(id));
            vacancy.setStatus("Активна".equals(vacancy.getStatus()) ? "Неактивна" : "Активна");
            service.save(vacancy);
        }

        return Response.status(205).build();
    }


    private Vacancy getVacancy(Vacancy vacancy){
        Employer employer = new Employer();
        employer.setId(vacancy.getEmployer().getId());
        vacancy.setEmployer(employer);

        if(vacancy.getOffice() != null){
            Office office = new Office();
            office.setId(vacancy.getOffice().getId());
            vacancy.setOffice(office);
        }

        for (SpecializationVacancy specializationVacancy : vacancy.getFields()){
            specializationVacancy.setVacancy(null);
        }

        return vacancy;
    }
}
