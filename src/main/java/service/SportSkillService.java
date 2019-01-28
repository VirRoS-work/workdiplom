package service;

import controller.Connection;
import model.SportSkill;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class SportSkillService implements GenericService<SportSkill, Long>{

    SessionFactory sessionFactory = new Connection().getSessionFactory();

    @Override
    public void save(SportSkill sportSkill) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        if (sportSkill.getId() == 0) {
            session.save(sportSkill);
        } else {
            session.update(sportSkill);
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
    public SportSkill getObjectByPk(Long aLong) {

        SportSkill sportSkill = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        sportSkill = session.find(SportSkill.class, aLong);

        session.close();

        return sportSkill;
    }

    @Override
    public List<SportSkill> getAll() {
        List languages = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        languages = session.createQuery("from "+SportSkill.class.getName()).list();

        session.close();

        return languages;
    }
}
