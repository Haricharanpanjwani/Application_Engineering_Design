/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.DAO;

/**
 *
 * @author hpanjwani
 */




import configuration.BooksNew;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author hpanjwani
 */
public class BookDAO {
    


    public BookDAO() {
    }
    
    public int addBook(ArrayList<BooksNew> books){
        int insert=0;
        Configuration c = new Configuration();
        c.configure("/hibernate.cfg.xml");
                                             // SessionFactory holds cfg file properties like
                                             // driver props and hibernate props and mapping file
        SessionFactory sf = c.buildSessionFactory();
        // create one session means Connection
        Session s = sf.openSession();
                                            // before starting save(),update(), delete() operation we need to start TX
        // starting tx mean    con.setAutoCommit(false);
        Transaction tx = s.beginTransaction();
        
        try{
            for(int i=0;i<books.size();i++)
            {
                BooksNew b= books.get(i);
                s.save(b);
                insert++;
            }
            s.flush();
            tx.commit();
            System.out.println("Records inserted");
            
        } catch(Exception e)
        {
            tx.rollback();                            // con.rollback();
        }

        return insert;
    }
    
}

