package service;

import controller.Connection;
import model.SpecializationVacancy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class SpecializationVacancyService implements GenericService<SpecializationVacancy, Long> {

    SessionFactory sessionFactory = new Connection().getSessionFactory();

    @Override
    public void save(SpecializationVacancy specializationVacancy) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        if (specializationVacancy.getId() == 0) {
            session.save(specializationVacancy);
        } else {
            session.update(specializationVacancy);
        }

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Long aLong) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.remove(getObjectByPk(aLong));

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public SpecializationVacancy getObjectByPk(Long aLong) {
        SpecializationVacancy specializationVacancy = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        specializationVacancy = session.find(SpecializationVacancy.class, aLong);

        session.close();

        return specializationVacancy;
    }

    @Override
    public List<SpecializationVacancy> getAll() {

        List specifications = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        specifications = session.createQuery("from "+SpecializationVacancy.class.getName()).list();

        session.close();

        return specifications;
    }


}
