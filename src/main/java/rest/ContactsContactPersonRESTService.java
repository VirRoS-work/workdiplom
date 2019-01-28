package rest;


import com.google.gson.Gson;
import model.ContactPerson;
import model.ContactsContactPerson;
import service.ContactsContactPersonService;
import service.GenericService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/contactscontactperson")
public class ContactsContactPersonRESTService {

    Gson gson = new Gson();
    GenericService<ContactsContactPerson, Long> service = new ContactsContactPersonService();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getContactsContactPerson(@PathParam("id") String id){

        ContactsContactPerson contactsContactPerson = service.getObjectByPk(Long.valueOf(id));

        if(contactsContactPerson != null) return Response.ok(gson.toJson(getContactsContactPerson(contactsContactPerson))).build();
        return Response.status(204).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteContactsContactPerson(@PathParam("id") String id){

        if(service.getObjectByPk(Long.valueOf(id)) == null) return Response.status(204).build();

        service.delete(Long.valueOf(id));

        return Response.status(205).build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getContactsContactPerson(){

        List<ContactsContactPerson> contacts = service.getAll();
        for (ContactsContactPerson obj : contacts) {
            obj = getContactsContactPerson(obj);
        }

        return Response.ok(gson.toJson(contacts)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addContactsContactPerson(String contact){

        ContactsContactPerson obj = gson.fromJson(contact, ContactsContactPerson.class);

        if (obj.getId() != 0 && service.getObjectByPk(obj.getId()) == null) return Response.status(400).build();

        service.save(obj);
        return Response.status(201).build();
    }

    private ContactsContactPerson getContactsContactPerson(ContactsContactPerson contactsContactPerson){

        ContactPerson contactPerson = new ContactPerson();
        contactPerson.setId(contactsContactPerson.getContact_person().getId());
        contactsContactPerson.setContact_person(contactPerson);
        return contactsContactPerson;
    }

}
