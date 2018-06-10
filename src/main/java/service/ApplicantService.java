package service;

import controller.Connection;
import model.Applicant;
import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ApplicantService implements GenericService<Applicant, Long>{

    SessionFactory sessionFactory = new Connection().getSessionFactory();

    public void save(Applicant applicant) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        if(applicant.getPassword() != null) applicant.setPassword(DigestUtils.md5(applicant.getPassword()).toString());

        if (applicant.getId() == 0) {
            session.save(applicant);
        } else {
            session.update(applicant);
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

    public Applicant getObjectByPk(Long aLong) {

        Applicant applicant = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        applicant = session.find(Applicant.class, aLong);

        session.close();

        return applicant;
    }

    public List<Applicant> getAll() {
        List applicants = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        applicants = session.createQuery("from "+Applicant.class.getName()).list();

        session.close();

        return applicants;
    }
}
