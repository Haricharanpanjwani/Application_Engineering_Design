/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.validator;

import com.neu.pojo.User;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author yash
 */
public class RegistrationValidator implements Validator {
    
     private static final String IMAGE_PATTERN = "([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)";

    @Override
    public boolean supports(Class clazz) {
       
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        
        Pattern pattern = Pattern.compile(IMAGE_PATTERN);
        Matcher matcher;
        MultipartFile photo;
       
        ValidationUtils.rejectIfEmpty(errors, "first","Test", "Field cannot be empty");
        ValidationUtils.rejectIfEmpty(errors, "last","Test", "Field cannot be empty");
        ValidationUtils.rejectIfEmpty(errors, "gender","Test", "Field cannot be empty");
        ValidationUtils.rejectIfEmpty(errors, "aboutMe","Test", "Field cannot be empty");
        ValidationUtils.rejectIfEmpty(errors, "email","Test", "Field cannot be empty");
        ValidationUtils.rejectIfEmpty(errors, "photo","Test", "Field cannot be empty");
        
        User user = (User) object;
        photo = user.getPhoto();
        matcher = pattern.matcher(photo.getOriginalFilename());
        
        if(0 == photo.getSize()) {
           errors.rejectValue("photo","Test","File is empty");
        }
              if(!matcher.matches()) {
             errors.rejectValue("photo","Test","Invalid Image Format");
        }
        
        if(5000000 < photo.getSize()) {
             errors.rejectValue("photo","Test","File size is over 5mb !");
        }
        
  
      
        
       
        
    }
    
}
