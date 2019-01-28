package service;

import controller.Connection;
import model.SpecializationApplicant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;

public class SpecializationApplicantService implements GenericService<SpecializationApplicant, Long>{

    SessionFactory sessionFactory = new Connection().getSessionFactory();

    @Override
    public void save(SpecializationApplicant specializationApplicant) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        if (specializationApplicant.getId() == 0) {
            session.save(specializationApplicant);
        } else {
            session.update(specializationApplicant);
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
    public SpecializationApplicant getObjectByPk(Long aLong) {
        SpecializationApplicant specializationApplicant = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        specializationApplicant = session.find(SpecializationApplicant.class, aLong);

        session.close();

        return specializationApplicant;
    }

    @Override
    public List<SpecializationApplicant> getAll() {

        List specifications = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        specifications = session.createQuery("from "+SpecializationApplicant.class.getName()).list();

        session.close();

        return specifications;
    }
}
