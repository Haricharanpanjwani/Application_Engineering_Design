/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.books.dao;

import com.books.pojo.Books;
import java.sql.SQLException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author hpanjwani
 */
public class BooksDAO {
    
    Configuration cfg;
     SessionFactory sf;
    
     public BooksDAO(){
        cfg = new Configuration();
        sf = cfg.configure().buildSessionFactory();
    }

    

    public void addBook(Books book) throws SQLException {
        Session hibsession = sf.openSession();
        Transaction tx = null;
        try {
            tx = hibsession.beginTransaction();
            hibsession.save(book);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            hibsession.close();
        }

    }
}
