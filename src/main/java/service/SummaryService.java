package service;

import controller.Connection;
import model.Summary;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class SummaryService implements GenericService<Summary, Long> {

    SessionFactory sessionFactory = new Connection().getSessionFactory();

    public void save(Summary summary) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        if (summary.getId() == 0) {
            session.save(summary);
        } else {
            session.update(summary);
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

    public Summary getObjectByPk(Long aLong) {
        Summary summary = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        summary = session.find(Summary.class, aLong);

        session.close();

        return summary;
    }

    public List<Summary> getAll() {
        List summaries = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        summaries = session.createQuery("from "+Summary.class.getName()).list();

        session.close();

        return summaries;
    }
}
