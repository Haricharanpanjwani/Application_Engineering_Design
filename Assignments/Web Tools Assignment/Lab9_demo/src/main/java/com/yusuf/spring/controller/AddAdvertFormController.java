package com.yusuf.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yusuf.spring.dao.DAO;
import com.yusuf.spring.dao.AdvertDAO;
import com.yusuf.spring.dao.CategoryDAO;
import com.yusuf.spring.dao.UserDAO;

import com.yusuf.spring.pojo.Advert;
import com.yusuf.spring.pojo.Category;
import com.yusuf.spring.pojo.User;

import com.yusuf.spring.exception.AdException;

@Controller
@RequestMapping("/addadvert.htm")
public class AddAdvertFormController {

	@Autowired
	@Qualifier("advertValidator")
	AdvertValidator advertValidator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder)
	{
		binder.setValidator(advertValidator);
	}
	
	@RequestMapping(method=RequestMethod.POST)
    protected String doSubmitAction(@ModelAttribute("advert")Advert advert,BindingResult result) throws Exception{

		advertValidator.validate(advert, result);
		if(result.hasErrors())
		{
			return "addAdvertForm";
		}
    	
    	
        String username = advert.getPostedBy();   //get posting user from addAdvertForm
        String categoryTitle = advert.getCategory_name();   //get category user from addAdvertForm
        String title = advert.getTitle();      //get advert title user from addAdvertForm
        String message = advert.getMessage();    //get user message from addAdvertForm

        try {
            UserDAO users = new UserDAO();
            CategoryDAO categories = new CategoryDAO();
            AdvertDAO adverts = new AdvertDAO();

            //searhing from database
            User user = users.get(username);

            //searching from database
            Category category = categories.get(categoryTitle);

            //insert a new advert
            Advert adv = adverts.create(title, message, user,category.getId(),category.getTitle());

            category.addAdvert(adv);
            categories.save(category);

            
        } catch (AdException e) {
            System.out.println(e.getMessage());
        }
        return "addedAdvert";
    }
    
	@RequestMapping(method=RequestMethod.GET)
    public String initializeForm(@ModelAttribute("advert")Advert advert, BindingResult result) { 
   
        return "addAdvertForm"; 
    } 
}