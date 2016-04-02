/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.dao;

import com.neu.pojo.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Dev
 */
public class UserDao {
     Configuration cfg;
     SessionFactory sf;
    public UserDao(){
        cfg = new Configuration();
        sf = cfg.configure().buildSessionFactory();
    }

    

    public void addUser(User user) throws SQLException {
        Session hibsession = sf.openSession();
        Transaction tx = null;
        try {
            tx = hibsession.beginTransaction();
            hibsession.save(user);
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

    public List<User> searchUsers(String key, String flag) {
        Session hibsession = sf.openSession();
        Query query = null;
        List<User> list = new ArrayList<User>();
        try {
            String hql = "FROM User u where u." + flag + "= :value";
            query = hibsession.createQuery(hql);
            query.setParameter("value", key);
            list = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            hibsession.close();
        }
        return list;
    }

    public void deleteUser(int id) {
        Session hibsession = sf.openSession();
        Transaction tx = null;
        try {
            tx = hibsession.beginTransaction();
            User user
                    = (User) hibsession.get(User.class, id);
            hibsession.delete(user);
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
