package rest;

import com.google.gson.Gson;
import model.Employer;
import model.Language;
import model.Office;
import service.GenericService;
import service.OfficeService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/office")
public class OfficeRESTService {

    Gson gson = new Gson();
    GenericService<Office, Long> service = new OfficeService();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOffice(@PathParam("id") String id){

        Office office = service.getObjectByPk(Long.valueOf(id));

        if(office != null) return Response.ok(gson.toJson(getOffice(office))).build();


        return Response.status(204).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteOffice(@PathParam("id") String id){

        if(service.getObjectByPk(Long.valueOf(id)) == null) return Response.status(204).build();

        service.delete(Long.valueOf(id));

        return Response.status(205).build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOffices(){

        List<Office> offices = service.getAll();
        for (Office obj : offices) {
            obj = getOffice(obj);
        }

        return Response.ok(gson.toJson(offices)).build();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addEmployer(String employer){

        service.save(gson.fromJson(employer, Office.class));

        return Response.status(201).build();
    }

    private Office getOffice(Office office){
        Employer employer = new Employer();
        employer.setId(office.getEmployer().getId());
        office.setEmployer(employer);
        return office;
    }
}
