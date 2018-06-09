package service;


import controller.Connection;
import model.ContactType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ContactTypeService implements GenericService<ContactType, Long> {

    SessionFactory sessionFactory = new Connection().getSessionFactory();

    public void save(ContactType contactType) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        if (contactType.getId() == 0) {
            session.save(contactType);
        } else {
            session.update(contactType);
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

    public ContactType getObjectByPk(Long aLong) {

        ContactType contactType = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        contactType = session.find(ContactType.class, aLong);

        session.close();

        return contactType;
    }

    public List<ContactType> getAll() {

        List contactTypes = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        contactTypes = session.createQuery("from "+ContactType.class.getName()).list();

        session.close();

        return contactTypes;
    }
}
