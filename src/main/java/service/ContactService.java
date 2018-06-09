package service;

import controller.Connection;
import model.Contact;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ContactService implements GenericService<Contact, Long> {

    SessionFactory sessionFactory = new Connection().getSessionFactory();

    public void save(Contact contact) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        if (contact.getId() == 0) {
            session.save(contact);
        } else {
            session.update(contact);
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

    public Contact getObjectByPk(Long aLong) {

        Contact contact = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        contact = session.find(Contact.class, aLong);

        session.close();

        return contact;
    }

    public List<Contact> getAll() {
        List contacts = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        contacts = session.createQuery("from "+Contact.class.getName()).list();

        session.close();

        return contacts;
    }
}
