package controller;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Connection {

    public static SessionFactory factory;

    public Connection() {
    }

    public static synchronized SessionFactory getSessionFactory() {
        if (factory == null) {
            factory = new Configuration().configure("hibernate.cfg.xml").
                    buildSessionFactory();
        }
        return factory;
    }
}
