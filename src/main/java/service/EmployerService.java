package service;

import controller.Connection;
import model.Employer;
import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class EmployerService implements GenericService<Employer, Long> {

    SessionFactory sessionFactory = new Connection().getSessionFactory();

    public void save(Employer employer) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        if (employer.getId() == 0) {
            session.save(employer);
        } else {
            session.update(employer);
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

    public Employer getObjectByPk(Long aLong) {

        Employer employer = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        employer = session.find(Employer.class, aLong);

        session.close();

        return employer;
    }

    public List<Employer> getAll() {
        List employers = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        employers = session.createQuery("from "+Employer.class.getName()).list();

        session.close();

        return employers;
    }
}
