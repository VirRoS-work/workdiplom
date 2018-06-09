package service;

import controller.Connection;
import model.Keyword;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class KeywordService implements GenericService<Keyword, Long> {

    SessionFactory sessionFactory = new Connection().getSessionFactory();

    public void save(Keyword keyword) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        if (keyword.getId() == 0) {
            session.save(keyword);
        } else {
            session.update(keyword);
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

    public Keyword getObjectByPk(Long aLong) {
        Keyword keyword = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        keyword = session.find(Keyword.class, aLong);

        session.close();

        return keyword;
    }

    public List<Keyword> getAll() {
        List keywords = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        keywords = session.createQuery("from "+Keyword.class.getName()).list();

        session.close();

        return keywords;
    }
}
