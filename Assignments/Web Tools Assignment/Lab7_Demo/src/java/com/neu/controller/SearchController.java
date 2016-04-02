/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.dao.UserDao;
import com.neu.pojo.User;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Dev
 */
public class SearchController implements Controller {

    private UserDao userDao;

    public SearchController() {

       
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    
    

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        
         //ApplicationContext context = 
          //   new ClassPathXmlApplicationContext("dispatcher-servlet.xml");
         //userDao =(UserDao) context.getBean("userDao");
        String action = hsr.getParameter("action");
        if (action.equalsIgnoreCase("searchuser")) {
            List<User> userList = new ArrayList();

            String key = hsr.getParameter("key");
            String searchKey = hsr.getParameter("flag");

            if (searchKey.equalsIgnoreCase("gender")) {
                if (key.equalsIgnoreCase("Male") || key.equalsIgnoreCase("M")) {
                    key = "M";
                }

                if (key.equalsIgnoreCase("Female") || key.equalsIgnoreCase("F")) {
                    key = "F";
                }
            }
            userList = getUserDao().searchUsers(key, searchKey);
            JSONObject obj = new JSONObject();
            obj.put("users",userList);
            PrintWriter out = hsr1.getWriter();
            out.println(obj);
        }
        
        if(action.equals("delete")){
            int id = Integer.parseInt(hsr.getParameter("user"));
            userDao.deleteUser(id);
        }

        return null;
    }

}
