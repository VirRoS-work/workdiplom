package service;


import controller.Connection;
import model.ContactsApplicant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ContactsApplicantService implements GenericService<ContactsApplicant, Long>{

    SessionFactory sessionFactory = new Connection().getSessionFactory();

    @Override
    public void save(ContactsApplicant contactsApplicant) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        if (contactsApplicant.getId() == 0) {
            session.save(contactsApplicant);
        } else {
            session.update(contactsApplicant);
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
    public ContactsApplicant getObjectByPk(Long aLong) {
        ContactsApplicant contactsApplicant = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        contactsApplicant = session.find(ContactsApplicant.class, aLong);

        session.close();

        return contactsApplicant;
    }

    @Override
    public List<ContactsApplicant> getAll() {
        List contacts = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        contacts = session.createQuery("from "+ContactsApplicant.class.getName()).list();

        session.close();

        return contacts;
    }
}
