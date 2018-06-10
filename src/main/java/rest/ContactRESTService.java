package rest;

import com.google.gson.Gson;
import model.Applicant;
import model.Contact;
import model.Employer;
import service.ContactService;
import service.GenericService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/contact")
public class ContactRESTService {

    Gson gson = new Gson();
    GenericService<Contact, Long> service = new ContactService();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getContact(@PathParam("id") String id){

        Contact contact = service.getObjectByPk(Long.valueOf(id));

        if(contact != null) {
            return Response.ok(gson.toJson(formatContact(contact))).build();
        }
        return Response.status(204).build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getContacts(){

        List<Contact> contacts = service.getAll();
        for (Contact c : contacts) {
            c = formatContact(c);
        }


        return Response.ok(gson.toJson(contacts)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteContact(@PathParam("id") String id){

        if(service.getObjectByPk(Long.valueOf(id)) == null) return Response.status(204).build();

        service.delete(Long.valueOf(id));

        return Response.status(205).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addContact(String contact){

        Contact cont = gson.fromJson(contact, Contact.class);

        if (cont.getId() != 0 && service.getObjectByPk(cont.getId()) == null) return Response.status(400).build();
        if (cont.getApplicant() == null && cont.getEmployer() == null) return Response.status(400).build();

        service.save(cont);
        return Response.status(201).build();
    }

    private Contact formatContact(Contact contact){

        Contact cont = contact;

        if (contact.getApplicant() != null) {
            Applicant applicant = new Applicant();
            applicant.setId(contact.getApplicant().getId());
            cont.setApplicant(applicant);
        }
        if (contact.getEmployer() != null) {
            Employer employer = new Employer();
            employer.setId(contact.getEmployer().getId());
            cont.setEmployer(employer);
        }

        cont.getContact_type().setContacts(null);

        return cont;
    }
}
