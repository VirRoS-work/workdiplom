package rest;

import com.google.gson.Gson;
import model.Employer;
import model.Office;
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
    GenericService<Vacancy, Long> vac = new VacancyService();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVacancy(@PathParam("id") String id){

        Vacancy vacancy = vac.getObjectByPk(Long.valueOf(id));

        if(vacancy != null) {

            Employer employer = vacancy.getEmployer();
            for (Office o : employer.getOffices()) {
                o.setEmployer(null);
            }
            employer.setVacancies(null);
            vacancy.setEmployer(employer);

            return Response.ok(gson.toJson(vacancy)).build();
        }

        return Response.status(204).build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVacancies(){

        List<Vacancy> vacancies = vac.getAll();

        for (Vacancy v: vacancies) {
            Employer employer = v.getEmployer();
            employer.setVacancies(null);
            for (Office o: employer.getOffices()) {
                o.setEmployer(null);
            }
        }

        return Response.ok(gson.toJson(vacancies)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addVacancy(String vacancy){

        vac.save(gson.fromJson(vacancy, Vacancy.class));

        return Response.status(201).build();
    }
}
