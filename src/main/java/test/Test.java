package test;

import com.google.gson.Gson;
import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import service.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

    public static void main(String[] args) {

        Gson gson = new Gson();

        GenericService<Applicant, Long> service = new ApplicantService();
        GenericService<PersonalData, Long> pers = new PersonDataService();
        GenericService<Language, Long> lang = new LanguageService();
        GenericService<Specialization, Long> special = new SpecializationService();
        GenericService<Experience, Long> exp = new ExperienceService();
        GenericService<Education, Long> ed = new EducationService();
        GenericService<Contact, Long> cont = new ContactService();
        GenericService<Summary, Long> summ = new SummaryService();
        GenericService<Employer, Long> emp = new EmployerService();
        GenericService<Office, Long> off = new OfficeService();
        GenericService<Vacancy, Long> vac = new VacancyService();
        GenericService<Keyword, Long> key = new KeywordService();

        System.out.println("------------------------------------------------------------------------------------------");

//        Applicant applicant = new Applicant();
//        applicant.setLogin("admin");
//        applicant.setPassword("admin");
//        applicant.setFirst_name("Иван");
//        applicant.setLast_name("Иванов");
//        applicant.setEmail("asd@mail.ru");
//        applicant.setPhone_number("+79998885522");
//        applicant.setPol((byte) 1);
//
//        service.save(applicant);

////
////        Applicant applicant1 = service.getObjectByPk((long) 1);
////        if(applicant1 != null) System.out.println(applicant1.toString());
////
////        PersonalData personalData = new PersonalData();
////        personalData.setSpotr("Футбол");
////        personalData.setHobby("Наркоман");
////        pers.save(personalData);
////
////        Specialization specialization = new Specialization();
////        specialization.setSpecialization("Node JS");
////        specialization.setField_of_activity("Фронтэнд");
////        specialization.setApplicant(applicant1);
////        special.save(specialization);
////
////        Language language = new Language("Англ.яз", "Начальный", applicant1);
////        Language language2 = new Language("Франц.яз", "Начальный", applicant1);
////        lang.save(language);
////        lang.save(language2);
////
////        Experience experience = new Experience();
////        experience.setConpany_name("NeoFlex");
////        experience.setPosition("Ген-Деректор");
////        experience.setApplicant(applicant1);
////        exp.save(experience);
////
////        Education education = new Education();
////        education.setEducational_institution("SSTU");
////        education.setFaculty("MFPIT");
////        education.setApplicant(applicant1);
////        ed.save(education);
////
////        ContactType contactType = new ContactType("Telegram");
////
////        Contact contact = new Contact();
////        Contact contact1 = new Contact();
////        contact.setContact_type(contactType);
////        contact.setValue("sadfsdf");
////        contact.setApplicant(applicant1);
////        contact1.setContact_type(contactType);
////        contact1.setValue("br5vtfbrb");
////        contact1.setApplicant(applicant1);
////        cont.save(contact);
////        cont.save(contact1);
////
////
////        List<Applicant> applicantList = service.getAll();
////        for (Applicant a: applicantList) {
////            System.out.println("------------------------------------------------------------------------------------------");
////            System.out.println(a.toString());
////        }
////
////
////


//        ContactPerson contactPerson = new ContactPerson();
//        contactPerson.setFirst_name("Иван");
//        contactPerson.setLast_name("Иванов");
//        contactPerson.setEmail("qwerty@mail.ru");
//
//        Employer employer = new Employer();
//        employer.setName("NeoFlex");
//        employer.setType("ЗАО");
//        employer.setNumber_of_person((byte) 4);
//        employer.setSite("http://google.ru");
//        employer.setContact_person(contactPerson);
//        emp.save(employer);

//        Employer employer1 = emp.getObjectByPk((long) 1);
//        employer1.setVacancies(null);
//        List<Office> offices = new ArrayList<Office>();
//        for (Office o: employer1.getOffices()) {
//            o.setEmployer(null);
//            offices.add(o);
//            System.out.println(o);
//        }
//        System.out.println(gson.toJson(offices));
////
////
////
////
//        Office office = new Office();
//        office.setAddress("fdsssssssssssss");
//        office.setDescription("sdafsa");
//        office.setEmployer(employer1);
//        Office office1 = new Office();
//        office1.setAddress("sdfsdgfs");
//        office1.setDescription("asdfffffffffff");
//        office1.setEmployer(employer1);
//        off.save(office);
//        off.save(office1);
////
////
//        Keyword keyword = new Keyword("1111");
//        Keyword keyword1 = new Keyword("2222");
//        key.save(keyword);
//        key.save(keyword1);
//        key.save(keyword);
//        key.save(keyword1);
//        key.save(keyword);
//        key.save(keyword1);
//        key.save(keyword);
//        key.save(keyword1);
//        key.save(keyword);
//        key.save(keyword1);
//        key.save(keyword);
//        key.save(keyword1);
//
//        System.out.println(gson.toJson(key.getAll()));
////
//        Set<Keyword> keywords = new HashSet<Keyword>();
//        keywords.add(key.getObjectByPk((long) 4));
//        keywords.add(key.getObjectByPk((long) 3));
//
//
//        Vacancy vacancy = new Vacancy();
//        vacancy.setStatus((byte) 1);
//        vacancy.setTitle("Вакансия 2");
//        vacancy.setEmployer(employer1);
//        vacancy.setKeywords(keywords);
//        vac.save(vacancy);
////
////
////        Summary summary = new Summary();
////        summary.setAbout_me("asfddddddddddddddddddddddddddddddddddddddddddd");
////        summary.setFamily_status((byte) 2);
////        summary.setApplicant(applicant1);
////        summary.setKeywords(keywords);
////        summ.save(summary);
////
////
////        for (Employer e: emp.getAll()) {
////            System.out.println(e.toString());
////        }
////
////        System.out.println("----------------------------------------------------------");
////
////        System.out.println(vac.getObjectByPk((long) 1).toString());
////
////
////        System.out.println("----------------------------------------------------------");
////
////        System.out.println(summ.getObjectByPk((long) 1).toString());
//
//

//        System.out.println(gson.toJson(vacancies));



//        Gson gson = new Gson();
//
//        System.out.println(gson.toJson(key.getAll()));
//
//
    }
}
