package service;

import controller.Connection;
import model.LanguageSkill;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class LanguageSkillService implements GenericService<LanguageSkill, Long> {

    SessionFactory sessionFactory = new Connection().getSessionFactory();

    @Override
    public void save(LanguageSkill languageSkill) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        if (languageSkill.getId() == 0) {
            session.save(languageSkill);
        } else {
            session.update(languageSkill);
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
    public LanguageSkill getObjectByPk(Long aLong) {
        LanguageSkill language = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        language = session.find(LanguageSkill.class, aLong);

        session.close();

        return language;
    }

    @Override
    public List<LanguageSkill> getAll() {
        List languages = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        languages = session.createQuery("from "+LanguageSkill.class.getName()).list();

        session.close();

        return languages;
    }
}
