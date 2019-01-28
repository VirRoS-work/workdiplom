package service;

import controller.Connection;
import model.FieldOfActivity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class FieldOfActivityService implements GenericService<FieldOfActivity, Long> {

    SessionFactory sessionFactory = new Connection().getSessionFactory();

    @Override
    public void save(FieldOfActivity fieldOfActivity) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        if (fieldOfActivity.getId() == 0) {
            session.save(fieldOfActivity);
        } else {
            session.update(fieldOfActivity);
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
    public FieldOfActivity getObjectByPk(Long aLong) {
        FieldOfActivity fieldOfActivity = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        fieldOfActivity = session.find(FieldOfActivity.class, aLong);

        session.close();

        return fieldOfActivity;
    }

    @Override
    public List<FieldOfActivity> getAll() {

        List fields = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        fields = session.createQuery("from "+FieldOfActivity.class.getName()).list();

        session.close();

        return fields;
    }
}
