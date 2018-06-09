package service;

import controller.Connection;
import model.PersonalData;
import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class PersonDataService implements GenericService<PersonalData, Long>{

    SessionFactory sessionFactory = new Connection().getSessionFactory();

    public void save(PersonalData personalData) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        if (personalData.getId() == 0) {
            session.save(personalData);
        } else {
            session.update(personalData);
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

    public PersonalData getObjectByPk(Long aLong) {

        PersonalData personalData = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        personalData = session.find(PersonalData.class, aLong);

        session.close();

        return personalData;
    }

    public List<PersonalData> getAll() {
        List applicants = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        applicants = session.createQuery("from "+PersonalData.class.getName()).list();

        session.close();

        return applicants;
    }
}
