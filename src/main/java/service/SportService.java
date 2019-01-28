package service;

import controller.Connection;
import model.Sport;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class SportService implements GenericService<Sport, Long>{

    SessionFactory sessionFactory = new Connection().getSessionFactory();

    @Override
    public void save(Sport sport) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        if (sport.getId() == 0) {
            session.save(sport);
        } else {
            session.update(sport);
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
    public Sport getObjectByPk(Long aLong) {
        Sport sport = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        sport = session.find(Sport.class, aLong);

        session.close();

        return sport;
    }

    @Override
    public List<Sport> getAll() {
        List sports = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        sports = session.createQuery("from "+Sport.class.getName()).list();

        session.close();

        return sports;
    }
}
