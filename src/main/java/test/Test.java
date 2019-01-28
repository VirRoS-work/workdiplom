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

        GenericService<Applicant, Long> apl = new ApplicantService();
        GenericService<PersonalData, Long> pers = new PersonDataService();
        GenericService<Language, Long> lang = new LanguageService();
        GenericService<LanguageSkill, Long> langsk = new LanguageSkillService();
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
        GenericService<ContactsContactPerson, Long> ccs = new ContactsContactPersonService();
        GenericService<ContactPerson, Long> conper = new ContactPersonService();
        GenericService<FieldOfActivity, Long> fiel = new FieldOfActivityService();
        GenericService<SpecializationVacancy, Long> spvac = new SpecializationVacancyService();
        GenericService<SpecializationApplicant, Long> spapp = new SpecializationApplicantService();
        GenericService<Sport, Long> sp = new SportService();
        GenericService<SportSkill, Long> spsk = new SportSkillService();
        GenericService<ContactsApplicant, Long> conapp = new ContactsApplicantService();

        System.out.println("------------------------------------------------------------------------------------------");

        ContactType contactType = new ContactType();
        contactType.setName("vk");
        conttype.save(contactType);

        ContactType contactType1 = conttype.getObjectByPk((long) 1);


        Employer employer = new Employer();
        employer.setLogin("admin");
        employer.setPassword("admin");
        employer.setName("Test 1");
        employer.setType("ООО");
        employer.setNumber_of_person("От 50 до 250");
        employer.setSite("www.test1.ru");
        employer.setAddress("Москва Сити Центр, Пресненская наб., Москва");
        employer.setDescription("Мы создаем ИТ-решения на базе инновационных программных продуктов, применяя передовые технологии и привлекая лучшие экспертные знания. Мы — сплоченная команда, в которой высоко ценятся компетентность, ответственность и готовность к самоотдаче.");
        emp.save(employer);

        Employer employer11 = new Employer();
        employer11.setLogin("admin1");
        employer11.setPassword("admin1");
        employer11.setName("Test 2");
        employer11.setType("ИП");
        employer11.setNumber_of_person("От 50 до 250");
        employer11.setSite("www.test2.ru");
        employer11.setAddress("Москва Сити Центр, Пресненская наб., Москва");
        employer11.setDescription("Мы создаем ИТ-решения на базе инновационных программных продуктов, применяя передовые технологии и привлекая лучшие экспертные знания. Мы — сплоченная команда, в которой высоко ценятся компетентность, ответственность и готовность к самоотдаче.");
        emp.save(employer11);

        Employer employer12 = new Employer();
        employer12.setLogin("admin");
        employer12.setPassword("admin");
        employer12.setName("Test 3");
        employer12.setType("ОАО");
        employer12.setNumber_of_person("От 50 до 250");
        employer12.setSite("www.test3.ru");
        employer12.setAddress("Москва Сити Центр, Пресненская наб., Москва");
        employer12.setDescription("Мы создаем ИТ-решения на базе инновационных программных продуктов, применяя передовые технологии и привлекая лучшие экспертные знания. Мы — сплоченная команда, в которой высоко ценятся компетентность, ответственность и готовность к самоотдаче.");
        emp.save(employer12);

        Employer employer1 = emp.getObjectByPk((long) 1);
        Employer employer2 = emp.getObjectByPk((long) 2);
        Employer employer3 = emp.getObjectByPk((long) 3);


        ContactPerson contactPerson = new ContactPerson();
        contactPerson.setFirst_name("f_name");
        contactPerson.setLast_name("l_name");
        contactPerson.setEmployer(employer1);
        conper.save(contactPerson);

        ContactPerson contactPerson1 = conper.getObjectByPk((long) 1);


        ContactsContactPerson contactsContactPerson = new ContactsContactPerson();
        contactsContactPerson.setContact_person(contactPerson1);
        contactsContactPerson.setContact_type(contactType1);
        contactsContactPerson.setValue("www.wwww.sdgfsdgsdfv");
        ccs.save(contactsContactPerson);

        ContactsContactPerson contactsContactPerson1 = ccs.getObjectByPk((long) 1);


        Office office = new Office();
        office.setCity("Саратов");
        office.setAddress("admin2 address");
        office.setEmployer(employer1);
        off.save(office);

        Office office1 = off.getObjectByPk((long) 1);


        FieldOfActivity fieldOfActivity = new FieldOfActivity();
        fieldOfActivity.setName("BackEnd");
        fiel.save(fieldOfActivity);

        FieldOfActivity fieldOfActivity1 = fiel.getObjectByPk((long) 1);

        Vacancy vacancy = new Vacancy();
        vacancy.setStatus("Активна");
        vacancy.setTitle("sdf");
        vacancy.setDescription("sdf");
        vacancy.setEmployer(employer1);
        vacancy.setOffice(office1);
        vac.save(vacancy);

        Vacancy vacancy2 = new Vacancy();
        vacancy2.setStatus("Активна");
        vacancy2.setTitle("sdf");
        vacancy2.setDescription("sdf");
        vacancy2.setEmployer(employer2);
        vac.save(vacancy2);

        Vacancy vacancy3 = new Vacancy();
        vacancy3.setStatus("Активна");
        vacancy3.setTitle("sdf");
        vacancy3.setDescription("sdf");
        vacancy3.setEmployer(employer3);
        vac.save(vacancy3);

        Vacancy vacancy4 = new Vacancy();
        vacancy4.setStatus("Активна");
        vacancy4.setTitle("sdf");
        vacancy4.setDescription("sdf");
        vacancy4.setEmployer(employer1);
        vac.save(vacancy4);

        Vacancy vacancy1 = vac.getObjectByPk((long) 1);


        SpecializationVacancy specializationVacancy = new SpecializationVacancy();
        specializationVacancy.setField_of_activity(fieldOfActivity1);
        specializationVacancy.setVacancy(vacancy1);
        specializationVacancy.setSpecialization("sdafsdf");
        spvac.save(specializationVacancy);

        SpecializationVacancy specializationVacancy1 = spvac.getObjectByPk((long) 1);




        Applicant applicant = new Applicant();
        applicant.setLogin("admin2");
        applicant.setPassword("admin2");
        applicant.setFirst_name("f");
        applicant.setLast_name("l");
        applicant.setPol((byte) 1);
        apl.save(applicant);

        Applicant applicant1 = apl.getObjectByPk((long) 1);


        Language language = new Language();
        language.setName("rus");
        lang.save(language);

        Language language1 = lang.getObjectByPk((long) 1);


        LanguageSkill languageSkill = new LanguageSkill();
        languageSkill.setLanguage(language1);
        languageSkill.setApplicant(applicant1);
        languageSkill.setOwnership_level("normal");
        langsk.save(languageSkill);

        LanguageSkill languageSkill1 = langsk.getObjectByPk((long) 1);


        Sport sport = new Sport();
        sport.setName("footbol");
        sp.save(sport);

        Sport sport1 = sp.getObjectByPk((long) 1);


        SportSkill sportSkill = new SportSkill();
        sportSkill.setSport(sport1);
        sportSkill.setApplicant(applicant1);
        sportSkill.setLevel("kms");
        spsk.save(sportSkill);

        SportSkill sportSkill1 = spsk.getObjectByPk((long) 1);


        Education education = new Education();
        education.setEducational_institution("СГТУ");
        education.setFaculty("ИнПИТ");
        education.setSpecialization("ИФСТ");
        education.setLevel_education("Бакалавр");
        education.setForm_training("Очная");
        education.setDate_start(new Date(Calendar.getInstance().getTime().getTime()));
        education.setDate_end(new Date(Calendar.getInstance().getTime().getTime()));
        education.setApplicant(applicant1);
        ed.save(education);

        Education education1 = ed.getObjectByPk((long) 1);


        Experience experience = new Experience();
        experience.setConpany_name("qqqq");
        experience.setPosition("position");
        experience.setDate_start(new Date(Calendar.getInstance().getTime().getTime()));
        experience.setDate_end(new Date(Calendar.getInstance().getTime().getTime()));
        experience.setApplicant(applicant1);
        exp.save(experience);

        Experience experience1 = exp.getObjectByPk((long) 1);


        ContactsApplicant contactsApplicant = new ContactsApplicant();
        contactsApplicant.setContact_type(contactType1);
        contactsApplicant.setApplicant(applicant1);
        contactsApplicant.setValue("asdfsdfswef");
        conapp.save(contactsApplicant);

        ContactsApplicant contactsApplicant1 = conapp.getObjectByPk((long) 1);


        SpecializationApplicant specializationApplicant = new SpecializationApplicant();
        specializationApplicant.setField_of_activity(fieldOfActivity1);
        specializationApplicant.setSpecialization("safd");
        specializationApplicant.setApplicant(applicant1);
        spapp.save(specializationApplicant);

        SpecializationApplicant specializationApplicant1 = spapp.getObjectByPk((long) 1);

    }

}
