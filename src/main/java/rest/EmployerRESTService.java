package rest;

import com.google.gson.Gson;
import model.*;
import org.hibernate.annotations.Parameter;
import service.EmployerService;
import service.GenericService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Path("/employer")
public class EmployerRESTService {

    Gson gson = new Gson();
    GenericService<Employer, Long> service = new EmployerService();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployer(@PathParam("id") String id) {

        Employer employer = service.getObjectByPk(Long.valueOf(id));

        if (employer != null) return Response.ok(gson.toJson(getEmployer(employer))).build();

        return Response.status(204).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteEmployer(@PathParam("id") String id) {

        if (service.getObjectByPk(Long.valueOf(id)) == null) return Response.status(204).build();

        service.delete(Long.valueOf(id));

        return Response.status(205).build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployers() {

        List<Employer> employers = service.getAll();
        for (Employer obj : employers) {
            obj = getEmployer(obj);
        }

        return Response.ok(gson.toJson(employers)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addEmployer(String employer) {

        Employer obj = gson.fromJson(employer, Employer.class);

        if (obj.getId() != 0 && service.getObjectByPk(obj.getId()) == null) return Response.status(400).build();

        service.save(obj);

        return Response.status(201).build();
    }

    private Employer getEmployer(Employer employer) {

        employer.setLogin(null);
        employer.setPassword(null);
        employer.setVacancies(null);

        if (employer.getOffices() != null) {
            for (Office obj : employer.getOffices()) {
                obj.setEmployer(null);
            }
        }
        if (employer.getContacts() != null) {
            for (ContactPerson obj : employer.getContacts()) {
                obj.setEmployer(null);
                obj.setContacts(null);
            }
        }

        return employer;
    }

    //    Дополнительные возможности

    @GET
    @Path("/{id}/offices")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployerOffices(@PathParam("id") String id) {

        Employer employer = service.getObjectByPk(Long.valueOf(id));

        if (employer != null) {
            Set<Office> offices = employer.getOffices();
            for (Office o : offices) {
                o.setEmployer(null);
            }
            return Response.ok(gson.toJson(offices)).build();
        }
        return Response.status(204).build();
    }

    @GET
    @Path("/{id}/contacts")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployerContacts(@PathParam("id") String id) {

        Employer employer = service.getObjectByPk(Long.valueOf(id));

        if (employer != null) {
            Set<ContactPerson> contactPeople = employer.getContacts();
            for (ContactPerson contactPerson : contactPeople) {
                contactPerson.setEmployer(null);
                for (ContactsContactPerson contactsContactPerson : contactPerson.getContacts()) {
                    contactsContactPerson.setContact_person(null);
                }
            }
            return Response.ok(gson.toJson(contactPeople)).build();
        }

        return Response.status(204).build();
    }

    @GET
    @Path("/{id}/vacancies")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployerVacancies(@PathParam("id") String id) {

        Employer employer = service.getObjectByPk(Long.valueOf(id));

        if (employer != null) {
            Set<Vacancy> vacancies = employer.getVacancies();
            for (Vacancy v : vacancies) {
                v.setEmployer(null);
                if (v.getOffice() != null) v.getOffice().setEmployer(null);
                for (SpecializationVacancy specializationVacancy : v.getFields())
                    specializationVacancy.setVacancy(null);
            }

            return Response.ok(gson.toJson(vacancies)).build();
        }
        return Response.status(204).build();
    }

    @GET
    @Path("/{id}/active_vacancies")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployerActiveVacancies(@PathParam("id") String id) {

        Employer employer = service.getObjectByPk(Long.valueOf(id));

        if (employer != null) {
            Set<Vacancy> vacancies = new HashSet<Vacancy>();

            for (Vacancy v : employer.getVacancies()) {
                if ("Активна".equals(v.getStatus())) {
                    v.setEmployer(null);
                    if (v.getOffice() != null) v.getOffice().setEmployer(null);
                    for (SpecializationVacancy specializationVacancy : v.getFields())
                        specializationVacancy.setVacancy(null);
                    vacancies.add(v);
                }
            }

            return Response.ok(gson.toJson(vacancies)).build();
        }
        return Response.status(204).build();
    }

    @GET
    @Path("/count_vacancies")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCountVacancies() {

        List<Employer> employers = service.getAll();
        List<CountVacancies> counts = new ArrayList<CountVacancies>();

        for (Employer obj : employers) {

            int count = 0;

            for (Vacancy vacancy : obj.getVacancies()) {
                if ("Активна".equals(vacancy.getStatus())) count++;
            }

            CountVacancies countVacancies = new CountVacancies(obj.getId(), obj.getName(), count);
            counts.add(countVacancies);
        }

        return Response.ok(gson.toJson(counts)).build();
    }
}
