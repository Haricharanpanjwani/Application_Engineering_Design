package com.yusuf.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import java.util.List;
import java.util.Iterator;

import com.yusuf.spring.dao.CategoryDAO;
import com.yusuf.spring.dao.DAO;
import com.yusuf.spring.exception.AdException;
import com.yusuf.spring.pojo.Advert;
import com.yusuf.spring.pojo.Category;
import java.util.ArrayList;

@Controller
@RequestMapping("/listadverts.htm")
public class ListAdvertController{

	@RequestMapping(method = RequestMethod.GET)
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CategoryDAO categories = null;
        List categoryList = null;
        List advList = new ArrayList();

        try {
            categories = new CategoryDAO();
            categoryList = categories.list();

            Iterator categIterator = categoryList.iterator();

            while (categIterator.hasNext())
            {
                Category category = (Category) categIterator.next();

                Iterator advIterator = category.getAdverts().iterator();

                while (advIterator.hasNext())
                {
                    Advert advert = (Advert) advIterator.next();
                    advList.add(advert);
                }
            }
            DAO.close();
        } catch (AdException e) {
            System.out.println(e.getMessage());
        }

        ModelAndView mv = new ModelAndView("viewAdverts", "adverts", advList);
        return mv;
    }
}