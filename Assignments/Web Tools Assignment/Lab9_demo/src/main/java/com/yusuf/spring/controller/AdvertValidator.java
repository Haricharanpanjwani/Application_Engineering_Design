package com.yusuf.spring.controller;

import com.yusuf.spring.pojo.Advert;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

@Component
public class AdvertValidator implements Validator {

    public boolean supports(Class aClass)
    {
        return aClass.equals(Advert.class);
    }

    public void validate(Object obj, Errors errors)
    {
        Advert newAdvert = (Advert) obj;

        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "error.invalid.category", "Category Required");
    }
}
