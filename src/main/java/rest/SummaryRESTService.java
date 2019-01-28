package rest;

import com.google.gson.Gson;
import model.*;
import service.EducationService;
import service.GenericService;
import service.SummaryService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/summary")
public class SummaryRESTService {

    Gson gson = new Gson();
    GenericService<Summary, Long> service = new SummaryService();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSummary(@PathParam("id") String id){

        Summary summary = service.getObjectByPk(Long.valueOf(id));

        if(summary != null) return Response.ok(gson.toJson(getSummary(summary))).build();
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
    public Response getSummaries(){

        List<Summary> summaries = service.getAll();
        for (Summary obj : summaries) {
            obj = getSummary(obj);
        }

        return Response.ok(gson.toJson(summaries)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addSummary(String summary){

        Summary obj = gson.fromJson(summary, Summary.class);

        if (obj.getId() != 0 && service.getObjectByPk(obj.getId()) == null) return Response.status(400).build();

        service.save(obj);
        return Response.status(201).build();
    }

    private Summary getSummary(Summary summary){

        summary.setApplicant(getApplicant(summary.getApplicant()));

        return summary;
    }

    private Applicant getApplicant(Applicant applicant){

        applicant.setLogin(null);
        applicant.setPassword(null);

//        if(applicant.getPersonal_data() != null) applicant.getPersonal_data().setApplicant(null);
//        if(applicant.getLanguages() != null){
//            for (Language obj: applicant.getLanguages()) {
//                obj.setApplicant(null);
//            }
//        }
//        if(applicant.getSpecialization() != null) applicant.getSpecialization().setApplicant(null);
//        if(applicant.getExperiences() != null){
//            for (Experience obj: applicant.getExperiences()) {
//                obj.setApplicant(null);
//            }
//        }
//        if(applicant.getEducations() != null){
//            for (Education obj: applicant.getEducations()) {
//                obj.setApplicant(null);
//            }
//        }
//        if(applicant.getContacts() != null){
//            for (Contact obj: applicant.getContacts()) {
//                obj.setApplicant(null);
//            }
//        }
//        applicant.setSummaries(null);

        return applicant;
    }
}
