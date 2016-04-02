package com.yusuf.spring.controller;

import com.yusuf.spring.pojo.Category;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

@Component
public class CategoryValidator implements Validator {

    public boolean supports(Class aClass)
    {
        return aClass.equals(Category.class);
    }

    public void validate(Object obj, Errors errors)
    {
        Category newCategory = (Category) obj;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "error.invalid.category", "Category Required");
    }
}
