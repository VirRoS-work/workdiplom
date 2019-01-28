package rest;

import com.google.gson.Gson;
import model.Applicant;
import model.ContactsApplicant;
import service.ContactsApplicantService;
import service.GenericService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/contactsapplicant")
public class ContactsApplicantRESTService {

    Gson gson = new Gson();
    GenericService<ContactsApplicant, Long> service = new ContactsApplicantService();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getContactsApplicant(@PathParam("id") String id){

        ContactsApplicant contactsApplicant = service.getObjectByPk(Long.valueOf(id));

        if(contactsApplicant != null) return Response.ok(gson.toJson(getContacts(contactsApplicant))).build();
        return Response.status(204).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteContactsApplicant(@PathParam("id") String id){

        if(service.getObjectByPk(Long.valueOf(id)) == null) return Response.status(204).build();

        service.delete(Long.valueOf(id));

        return Response.status(205).build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getContactsApplicant(){

        List<ContactsApplicant> contacts = service.getAll();
        for (ContactsApplicant obj : contacts) {
            obj = getContacts(obj);
        }

        return Response.ok(gson.toJson(contacts)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addContactsApplicant(String contact){

        ContactsApplicant obj = gson.fromJson(contact, ContactsApplicant.class);

        if (obj.getId() != 0 && service.getObjectByPk(obj.getId()) == null) return Response.status(400).build();

        service.save(obj);
        return Response.status(201).build();
    }

    private ContactsApplicant getContacts(ContactsApplicant contactsApplicant){

        Applicant applicant = new Applicant();
        applicant.setId(contactsApplicant.getApplicant().getId());
        contactsApplicant.setApplicant(applicant);
        return contactsApplicant;
    }
}
