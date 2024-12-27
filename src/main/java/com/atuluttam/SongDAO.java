package com.atuluttam;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class SongDAO {

    public void saveSong(Song song)
    {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession())
        {
            transaction = session.beginTransaction(); // Start transaction
            session.persist(song);                   // Save song
            transaction.commit();                    // Commit transaction
        }
        catch (Exception e)
        {
            if (transaction != null)
            {
                transaction.rollback();             // Rollback if error occurs
            }
            e.printStackTrace();
        }
    }
}
