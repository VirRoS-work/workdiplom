package service;

import controller.Connection;
import model.Language;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class LanguageService implements GenericService<Language, Long>{

    SessionFactory sessionFactory = new Connection().getSessionFactory();

    public void save(Language language) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        if (language.getId() == 0) {
            session.save(language);
        } else {
            session.update(language);
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

    public Language getObjectByPk(Long aLong) {

        Language language = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        language = session.find(Language.class, aLong);

        session.close();

        return language;
    }

    public List<Language> getAll() {
        List languages = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        languages = session.createQuery("from "+Language.class.getName()).list();

        session.close();

        return languages;
    }
}
