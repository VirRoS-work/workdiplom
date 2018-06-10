package test;

import com.google.gson.Gson;
import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import service.*;

import java.sql.Date;
import java.util.*;

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
        GenericService<ContactType, Long> conttype = new ContactTypeService();
        GenericService<Summary, Long> summ = new SummaryService();
        GenericService<Employer, Long> emp = new EmployerService();
        GenericService<Office, Long> off = new OfficeService();
        GenericService<Vacancy, Long> vac = new VacancyService();
        GenericService<Keyword, Long> key = new KeywordService();

        System.out.println("------------------------------------------------------------------------------------------");

//        Employer employer = new Employer();
//        employer.setLogin("admin2");
//        employer.setPassword("admin2");
//        employer.setName("admin2");
//        employer.setType("ИП");
//        employer.setNumber_of_person((byte) 1);
//        ContactPerson contactPerson = new ContactPerson();
//        contactPerson.setFirst_name("admin2");
//        contactPerson.setLast_name("admin2");
//        contactPerson.setEmail("admin2@admin.com");
//        employer.setContact_person(contactPerson);
//        emp.save(employer);
//
//        Employer employer1 = emp.getObjectByPk((long) 1);
//
//        Office office = new Office();
//        office.setAddress("admin2 address");
//        office.setEmployer(employer1);
//        off.save(office);
//
//        Vacancy vacancy = new Vacancy();
//        vacancy.setStatus((byte) 1);
//        vacancy.setTitle("admin vacancy");
//        vacancy.setDescription("Test vacancy");
//        vacancy.setEmployer(employer1);
//        vac.save(vacancy);
//
//        Applicant applicant = new Applicant();
//        applicant.setLogin("admin");
//        applicant.setPassword("admin");
//        applicant.setEmail("admin@admin.com");
//        applicant.setPol((byte) 1);
//        applicant.setPhone_number("+79995552211");
//        applicant.setFirst_name("Admin");
//        applicant.setLast_name("Admin");
//        service.save(applicant);
//
//        Applicant applicant1 = service.getObjectByPk((long) 1);
//
//        PersonalData personalData = new PersonalData();
//        personalData.setHobby("IT`s my live!");
//        personalData.setApplicant(applicant1);
//        pers.save(personalData);
//
//        Language language = new Language();
//        Language language1 = new Language();
//        language.setTitle("Англ. яз");
//        language.setOwnership_level("Начальный");
//        language1.setTitle("Немец. яз");
//        language1.setOwnership_level("Начальный");
//        language.setApplicant(applicant1);
//        language1.setApplicant(applicant1);
//        lang.save(language);
//        lang.save(language1);
//
//        Specialization specialization = new Specialization();
//        specialization.setField_of_activity("Фронэнд");
//        specialization.setSpecialization("js");
//        specialization.setApplicant(applicant1);
//        special.save(specialization);
//
//        Experience experience = new Experience();
//        experience.setConpany_name("qqqq");
//        experience.setPosition("position");
//        experience.setDate_start(new Date(Calendar.getInstance().getTime().getTime()));
//        experience.setDate_end(new Date(Calendar.getInstance().getTime().getTime()));
//        experience.setApplicant(applicant1);
//        exp.save(experience);
//
//        Education education = new Education();
//        education.setEducational_institution("СГТУ");
//        education.setFaculty("ИнПИТ");
//        education.setSpecialization("ИФСТ");
//        education.setLevel_education("Бакалавр");
//        education.setForm_training("Очная");
//        education.setApplicant(applicant1);
//
//        ContactType contactType = new ContactType();
//        contactType.setName("vk");
//        ContactType contactType1 = new ContactType();
//        contactType1.setName("telegram");
//        conttype.save(contactType);
//        conttype.save(contactType1);
//
//        ContactType ct1 = conttype.getObjectByPk((long) 1);
//        ContactType ct2 = conttype.getObjectByPk((long) 2);
//
//        Contact contact = new Contact();
//        contact.setContact_type(ct1);
//        contact.setValue("1");
//        contact.setApplicant(applicant1);
//        Contact contact1 = new Contact();
//        contact1.setValue("2");
//        contact1.setContact_type(ct2);
//        contact1.setEmployer(employer1);
//        cont.save(contact);
//        cont.save(contact1);
//
//        Summary summary = new Summary();
//        summary.setAbout_me("sdf");
//        summary.setCity("Саратов");
//        summary.setApplicant(applicant1);
//        summary.setFamily_status((byte) 1);
//        summ.save(summary);

    }
}
