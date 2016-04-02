package com.neu.controller;

import com.neu.dao.UserDao;
import com.neu.pojo.User;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.json.JSONObject;

/**
 *
 * @author Dev
 */
public class UserFormController extends SimpleFormController {

    private UserDao userDao;

    public UserFormController() {
        setCommandClass(User.class);
        setCommandName("user");
        setFormView("registrationview");
       
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    
    

   
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
            BindException errors) throws Exception {
        User u = (User) command;
        getUserDao().addUser(u);
        JSONObject obj = new JSONObject();
        obj.put("successmsg", "User has been added successfully"); 
        PrintWriter out = response.getWriter();
        out.println(obj);
        return null;
    }

}
