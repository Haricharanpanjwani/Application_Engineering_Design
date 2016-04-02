package com.yusuf.spring.dao;

import org.hibernate.HibernateException;

import com.yusuf.spring.exception.AdException;
import com.yusuf.spring.pojo.Advert;
import com.yusuf.spring.pojo.User;

public class AdvertDAO extends DAO {

    public Advert create(String title, String message, User user, long category_id,String categoryName)
            throws AdException {
        try {
            begin();
            Advert advert = new Advert(title, message, user,category_id,categoryName);
            getSession().save(advert);
            commit();
            return advert;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create advert", e);
            throw new AdException("Exception while creating advert: " + e.getMessage());
        }
    }

    public void delete(Advert advert)
            throws AdException {
        try {
            begin();
            getSession().delete(advert);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete advert", e);
        }
    }
}