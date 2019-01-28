package service;

import controller.Connection;
import model.Contact;
import model.ContactsContactPerson;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ContactsContactPersonService implements GenericService<ContactsContactPerson, Long> {

    SessionFactory sessionFactory = new Connection().getSessionFactory();

    @Override
    public void save(ContactsContactPerson contactsContactPerson) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        if (contactsContactPerson.getId() == 0) {
            session.save(contactsContactPerson);
        } else {
            session.update(contactsContactPerson);
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
    public ContactsContactPerson getObjectByPk(Long aLong) {
        ContactsContactPerson contactsContactPerson = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        contactsContactPerson = session.find(ContactsContactPerson.class, aLong);

        session.close();

        return contactsContactPerson;
    }

    @Override
    public List<ContactsContactPerson> getAll() {
        List contacts = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        contacts = session.createQuery("from "+ContactsContactPerson.class.getName()).list();

        session.close();

        return contacts;
    }
}
