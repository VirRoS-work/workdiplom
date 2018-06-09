package rest;

import com.google.gson.Gson;
import model.Employer;
import model.Office;
import service.EmployerService;
import service.GenericService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/employer")
public class EmployerRESTService {

    Gson gson = new Gson();
    GenericService<Employer, Long> emp = new EmployerService();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployer(@PathParam("id") String id){

        Employer employer = emp.getObjectByPk(Long.valueOf(id));

        if(employer != null) {
            employer.setOffices(null);
            employer.setVacancies(null);
            return Response.ok(gson.toJson(employer)).build();
        }
        return Response.status(204).build();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addEmployer(String employer){

        emp.save(gson.fromJson(employer, Employer.class));

        return Response.status(201).build();
    }

    @GET
    @Path("/{id}/offices")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployerOffices(@PathParam("id") String id){

        Employer employer = emp.getObjectByPk(Long.valueOf(id));

        if(employer != null) {
            List<Office> offices = new ArrayList<Office>();
            for (Office o: employer.getOffices()) {
                o.setEmployer(null);
                offices.add(o);
                System.out.println(o);
            }
            return Response.ok(gson.toJson(offices)).build();
        }
        return Response.status(204).build();
    }
}
