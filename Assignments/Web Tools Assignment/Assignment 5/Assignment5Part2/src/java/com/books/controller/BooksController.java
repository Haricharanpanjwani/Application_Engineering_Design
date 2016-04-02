/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.books.controller;

import com.books.dao.BooksDAO;
import com.books.pojo.Books;
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
public class BooksController implements Controller {

    BooksDAO booksDAO;
    
    public BooksController(BooksDAO booksDAO) {
        this.booksDAO = booksDAO;
    }
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        
        String action = request.getParameter("action");
        
        if (action.equals("displayForm")) {
            String books = (String) request.getParameter("numberOfBooks");            
            int numberOfBooks = 0;

            try {
                numberOfBooks = Integer.parseInt(books);
                session.setAttribute("numberOfBooks", numberOfBooks);
                mv.addObject("numberOfBooks", numberOfBooks);
                mv.setViewName("BookDetails");       
            }
            catch(Exception e) {
                mv.addObject("action", "empty");
                mv.setViewName("display");
            }                                 
        }               
        else if (action.equals("display")) {
            
            int numberOfBooks = (Integer)session.getAttribute("numberOfBooks");
            
            try {
            
                String[] isbn = new String[numberOfBooks];
                String[] title = new String[numberOfBooks];
                String[] author = new String[numberOfBooks];
                float[] price = new float[numberOfBooks];

                for(int i=0; i < numberOfBooks; i++) {
                    isbn[i] = (String) request.getParameter("isbn"+(i+1));
                    title[i] = (String) request.getParameter("title"+(i+1));
                    author[i] = (String) request.getParameter("author"+(i+1));
                    price[i] = Float.parseFloat((String)request.getParameter("price"+(i+1)));
                }                

                ArrayList<Books> bookList = new ArrayList<Books>();

                for(int i=0; i < numberOfBooks; i++) {

                    Books b = new Books();
                    b.setIsbn(isbn[i]);
                    b.setTitle(title[i]);
                    b.setAuthor(author[i]);
                    b.setPrice(price[i]);
                    bookList.add(b);
                }

                for(Books book : bookList) {
                    booksDAO.addBook(book);
                }
            }
            catch(Exception e) {
                mv.addObject("action", "numberFormat");
            }

                mv.setViewName("display");
        }
        return mv;
    }
    
}
