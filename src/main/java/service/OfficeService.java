package service;

import controller.Connection;
import model.Office;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class OfficeService implements GenericService<Office, Long> {

    SessionFactory sessionFactory = new Connection().getSessionFactory();

    public void save(Office office) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        if (office.getId() == 0) {
            session.save(office);
        } else {
            session.update(office);
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

    public Office getObjectByPk(Long aLong) {
        Office office = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        office = session.find(Office.class, aLong);

        session.close();

        return office;
    }

    public List<Office> getAll() {
        List offices = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        offices = session.createQuery("from "+Office.class.getName()).list();

        session.close();

        return offices;
    }
}
