/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.controller;

import com.neu.dao.UserDao;
import com.neu.pojo.User;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author yash
 */
public class UserFormController extends SimpleFormController {
    
    UserDao userDao;
    
    
    public UserFormController(UserDao userDao) {
     
        this.userDao = userDao;
    }
    
    @Override
    protected void doSubmitAction(Object command) throws Exception {
     
       User user = (User) command;
       File file;
       String check = File.separator; //Checking if system is linux based or windows based by checking seprator used.
       String path = null;
       if(check.equalsIgnoreCase("\\")) {
        path = getServletContext().getRealPath("").replace("build\\",""); //Netbeans projects gives real path as Lab6/build/web/ so we need to replace build in the path.
    }
    
        if(check.equalsIgnoreCase("/")) {
       path = getServletContext().getRealPath("").replace("build/","");
       path += "/"; //Adding trailing slash for Mac systems.

    }
       
       
       if(user.getPhoto() != null) {
           
           String fileNameWithExt = System.currentTimeMillis() + user.getPhoto().getOriginalFilename();
           file = new File(path+fileNameWithExt);
           String context = getServletContext().getContextPath();

       
           
           user.getPhoto().transferTo(file);
           user.setPhotoName(context +"/" + fileNameWithExt);
           userDao.addUser(user);

       }
        
    } 
    

    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    /*
    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, 
            BindException errors) throws Exception {
        ModelAndView mv = new ModelAndView(getSuccessView());

    }
      return mv;
}
*/
}
