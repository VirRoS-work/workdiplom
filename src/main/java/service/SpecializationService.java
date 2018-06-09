package service;

import controller.Connection;
import model.Specialization;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class SpecializationService implements GenericService<Specialization, Long> {

    SessionFactory sessionFactory = new Connection().getSessionFactory();

    public void save(Specialization specialization) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        if (specialization.getId() == 0) {
            session.save(specialization);
        } else {
            session.update(specialization);
        }

        session.getTransaction().commit();
        session.close();
    }

    public void delete(Long aLong) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.remove(getObjectByPk(aLong));

        session.getTransaction().commit();
        session.close();
    }

    public Specialization getObjectByPk(Long aLong) {

        Specialization specialization = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        specialization = session.find(Specialization.class, aLong);

        session.close();

        return specialization;
    }

    public List<Specialization> getAll() {
        List specializations = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        specializations = session.createQuery("from "+Specialization.class.getName()).list();

        session.close();

        return specializations;
    }
}
