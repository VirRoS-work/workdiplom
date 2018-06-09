package service;

import controller.Connection;
import model.Experience;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ExperienceService implements GenericService<Experience, Long> {

    SessionFactory sessionFactory = new Connection().getSessionFactory();

    public void save(Experience experience) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        if (experience.getId() == 0) {
            session.save(experience);
        } else {
            session.update(experience);
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

    public Experience getObjectByPk(Long aLong) {

        Experience experience = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        experience = session.find(Experience.class, aLong);

        session.close();

        return experience;

    }

    public List<Experience> getAll() {
        List experiences = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        experiences = session.createQuery("from "+Experience.class.getName()).list();

        session.close();

        return experiences;
    }
}
