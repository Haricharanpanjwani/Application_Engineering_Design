/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.dao.UserDao;
import com.neu.pojo.User;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;



/**
 *
 * @author yash
 */
public class SearchController implements Controller {
    
    UserDao userDao;
    
    public SearchController(UserDao userDao) {
        
        this.userDao = userDao;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        
         
        String action = hsr.getParameter("action");
        ModelAndView mv = new ModelAndView();
        
        if(action.equalsIgnoreCase("showsearchform")) {
            mv.setViewName("search");
        }
        
        else if(action.equalsIgnoreCase("searchuser")) {
            List<User> userList = new ArrayList<>();
            
            String key = hsr.getParameter("user");
            String searchKey = hsr.getParameter("searchkey");
            
            if(searchKey.equalsIgnoreCase("gender")) {
                if(key.equalsIgnoreCase("Male") || key.equalsIgnoreCase("M")){
                    key = "M";
                }
                
                if(key.equalsIgnoreCase("Female") || key.equalsIgnoreCase("F")){
                    key = "F";
                }
            }
            
            userList = userDao.searchUsers(key,searchKey);
           
           mv.addObject("userList",userList);
           mv.setViewName("searchresult");
        }
        
        
        
        return mv;
    }
    
 
    
}
