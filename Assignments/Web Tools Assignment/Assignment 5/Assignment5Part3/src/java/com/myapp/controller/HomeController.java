/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.controller;

import com.myapp.DAO.BookDAO;
import configuration.BooksNew;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author hpanjwani
 */
public class HomeController implements Controller {
    private BookDAO bookDAO;
    
    public HomeController(BookDAO bookDAO) {
        this.bookDAO=bookDAO;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws SQLException  {
        HttpSession session= request.getSession();
        String action= request.getParameter("action");
        ModelAndView mv= new ModelAndView();
        
        if(action.equals("count"))
        {
            String count=request.getParameter("noOfBooks");
            int noOfBooks=Integer.parseInt(count);
            session.setAttribute("noOfBooks", noOfBooks);
            mv.setViewName("addBooks");
        }
        else if(action.equals("insert"))
        {
            int noOfBooks=Integer.parseInt(session.getAttribute("noOfBooks").toString());
            ArrayList<BooksNew> list= new ArrayList<>();
            for(int i=1;i<=noOfBooks;i++)
            {
                BooksNew b= new BooksNew();
                b.setIsbn(request.getParameter("isbn"+i));
                b.setTitle(request.getParameter("title"+i));
                b.setAuthors(request.getParameter("authors"+i));
                b.setPrice(Double.parseDouble(request.getParameter("price"+i)));
                list.add(b);
            }
            
            int insert=bookDAO.addBook(list);
            
            if(insert>0)
            {
                session.setAttribute("noOfInsert", insert);
                mv.setViewName("confirmation");
                
            }
            else
            {
                mv.setViewName("index");
            }
            
        }
        
        return mv;
    }
    
}
