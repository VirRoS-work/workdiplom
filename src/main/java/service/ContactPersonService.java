package service;

import controller.Connection;
import model.ContactPerson;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.GeneratedValue;
import java.util.List;

public class ContactPersonService implements GenericService<ContactPerson, Long> {

    SessionFactory sessionFactory = new Connection().getSessionFactory();

    public void save(ContactPerson contactPerson) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        if (contactPerson.getId() == 0) {
            session.save(contactPerson);
        } else {
            session.update(contactPerson);
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

    public ContactPerson getObjectByPk(Long aLong) {
        ContactPerson contactPerson = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        contactPerson = session.find(ContactPerson.class, aLong);

        session.close();

        return contactPerson;
    }

    public List<ContactPerson> getAll() {
        List contactPersons = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        contactPersons = session.createQuery("from "+ContactPerson.class.getName()).list();

        session.close();

        return contactPersons;
    }
}
