package rest;

import com.google.gson.Gson;
import model.ContactPerson;
import model.ContactsContactPerson;
import model.Employer;
import service.ContactPersonService;
import service.GenericService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/contactperson")
public class ContactPersonRESTService {

    Gson gson = new Gson();
    GenericService<ContactPerson, Long> service = new ContactPersonService();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getContactPerson(@PathParam("id") String id){

        ContactPerson contactPerson = service.getObjectByPk(Long.valueOf(id));

        if(contactPerson != null) {
            return Response.ok(gson.toJson(getContactPerson(contactPerson))).build();
        }
        return Response.status(204).build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getContactPersons(){

        List<ContactPerson> contacts = service.getAll();
        for (ContactPerson c : contacts) {
            c = getContactPerson(c);
        }

        return Response.ok(gson.toJson(contacts)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteContactPerson(@PathParam("id") String id){

        if(service.getObjectByPk(Long.valueOf(id)) == null) return Response.status(204).build();

        service.delete(Long.valueOf(id));

        return Response.status(205).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addContactPerson(String contactPerson){

        ContactPerson cont = gson.fromJson(contactPerson, ContactPerson.class);

        if (cont.getId() != 0 && service.getObjectByPk(cont.getId()) == null) return Response.status(400).build();

        service.save(cont);
        return Response.status(201).build();
    }

    private ContactPerson getContactPerson(ContactPerson contactPerson){

        if(contactPerson.getEmployer() != null) {
            Employer employer = new Employer();
            employer.setId(contactPerson.getEmployer().getId());
            contactPerson.setEmployer(employer);
        }
        if(contactPerson.getContacts() != null){
            for (ContactsContactPerson obj: contactPerson.getContacts()){
                obj.setContact_person(null);
            }
        }

        return contactPerson;
    }

}
