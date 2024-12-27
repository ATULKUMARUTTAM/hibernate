package com.atuluttam;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class App {
    public static void main(String[] args)
    {
        // Create Configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Song.class);
        // Create Session Factory and auto-close with try-with-resources.
        try (SessionFactory sessionFactory
                     = configuration.buildSessionFactory()) {
            // Initialize Session Object
            Session session = sessionFactory.openSession();
            Song song1 = new Song();
            song1.setId(2);
            song1.setSongName("Broken Angel");
            song1.setArtist("Akon");
            session.beginTransaction();
            // Here we have used
            // persist() method of JPA
            session.persist(song1);
            session.getTransaction().commit();
        }
    }
}

