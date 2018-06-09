package service;

import controller.Connection;
import model.Education;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class EducationService implements GenericService<Education, Long> {

    SessionFactory sessionFactory = new Connection().getSessionFactory();

    public void save(Education education) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        if (education.getId() == 0) {
            session.save(education);
        } else {
            session.update(education);
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

    public Education getObjectByPk(Long aLong) {

        Education education = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        education = session.find(Education.class, aLong);

        session.close();

        return education;
    }

    public List<Education> getAll() {

        List educations = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        educations = session.createQuery("from "+Education.class.getName()).list();

        session.close();

        return educations;
    }
}
