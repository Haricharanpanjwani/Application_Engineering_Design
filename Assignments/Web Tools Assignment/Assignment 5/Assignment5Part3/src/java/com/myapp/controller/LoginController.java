/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import sun.misc.BASE64Decoder;

/**
 *
 * @author hpanjwani
 */
public class LoginController extends AbstractController {
    
    public LoginController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        ModelAndView mv = null;
        String authorization = request.getHeader("Authorization");
        if (authorization == null) {
            askForPassword(response);
        } else {
// Authorization headers looks like "Basic blahblah", // where blahblah is the base64 encoded username and // password. We want the part after "Basic ".
            String userInfo = authorization.substring(6).trim();
            BASE64Decoder decoder = new BASE64Decoder();
            String nameAndPassword
                    = new String(decoder.decodeBuffer(userInfo));
            // Decoded part looks like "username:password".
            int index = nameAndPassword.indexOf(":");
            String user = nameAndPassword.substring(0, index);
            String password = nameAndPassword.substring(index + 1); // High security: username must be reverse of password. if (areEqualReversed(user, password)) {

            if (areEqualReversed(user, password)) {
                mv = new ModelAndView("index");
            } else {
                askForPassword(response);
            }

        }

        return mv;
    }
    
     private void askForPassword(HttpServletResponse hsr1) {
        hsr1.setStatus(hsr1.SC_UNAUTHORIZED); // I.e., 401 
        hsr1.setHeader("WWW-Authenticate", "BASIC realm=\"Books\"");
    }

    // Returns true if s1 is the reverse of s2. // Empty strings don't count.
    private boolean areEqualReversed(String s1, String s2) {
        s2 = (new StringBuffer(s2)).reverse().toString();
        return ((s1.length() > 0) && s1.equals(s2));
    }
    
}
