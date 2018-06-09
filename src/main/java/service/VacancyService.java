package service;

import controller.Connection;
import model.Vacancy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class VacancyService implements GenericService<Vacancy, Long>{

    SessionFactory sessionFactory = new Connection().getSessionFactory();

    public void save(Vacancy vacancy) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        if (vacancy.getId() == 0) {
            session.save(vacancy);
        } else {
            session.update(vacancy);
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

    public Vacancy getObjectByPk(Long aLong) {
        Vacancy vacancy = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        vacancy = session.find(Vacancy.class, aLong);

        session.close();

        return vacancy;
    }

    public List<Vacancy> getAll() {
        List vacancies = null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        vacancies = session.createQuery("from "+Vacancy.class.getName()).list();

        session.close();

        return vacancies;
    }
}
