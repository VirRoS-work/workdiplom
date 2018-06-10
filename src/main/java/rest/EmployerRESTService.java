package rest;

import com.google.gson.Gson;
import model.Contact;
import model.Education;
import model.Employer;
import model.Office;
import service.EmployerService;
import service.GenericService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Path("/employer")
public class EmployerRESTService {

    Gson gson = new Gson();
    GenericService<Employer, Long> service = new EmployerService();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployer(@PathParam("id") String id){

        Employer employer = service.getObjectByPk(Long.valueOf(id));

        if(employer != null) return Response.ok(gson.toJson(getEmployer(employer))).build();

        return Response.status(204).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteEmployer(@PathParam("id") String id){

        if(service.getObjectByPk(Long.valueOf(id)) == null) return Response.status(204).build();

        service.delete(Long.valueOf(id));

        return Response.status(205).build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployers(){

        List<Employer> employers = service.getAll();
        for (Employer obj : employers) {
            obj = getEmployer(obj);
        }

        return Response.ok(gson.toJson(employers)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addEmployer(String employer){

        Employer obj = gson.fromJson(employer, Employer.class);

        if (obj.getId() != 0 && service.getObjectByPk(obj.getId()) == null) return Response.status(400).build();

        service.save(obj);

        return Response.status(201).build();
    }

    @GET
    @Path("/{id}/offices")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployerOffices(@PathParam("id") String id){

        Employer employer = service.getObjectByPk(Long.valueOf(id));

        if(employer != null) {
            Set<Office> offices = employer.getOffices();
            for (Office o: offices) {
                o.setEmployer(null);
            }
            return Response.ok(gson.toJson(offices)).build();
        }
        return Response.status(204).build();
    }

    private Employer getEmployer(Employer employer){

        employer.setLogin(null);
        employer.setPassword(null);
        employer.setVacancies(null);

        if(employer.getOffices() != null){
            for(Office obj : employer.getOffices()){
                obj.setEmployer(null);
            }
        }
        if(employer.getContacts() != null){
            for(Contact obj : employer.getContacts()){
                obj.setEmployer(null);
                obj.setApplicant(null);
                obj.getContact_type().setContacts(null);
            }
        }

        return employer;
    }
}
