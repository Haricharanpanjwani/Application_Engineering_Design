/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.books.servlet;

import com.books.DAO.BookDAO;
import com.books.POJO.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author hpanjwani
 */
public class BookController extends AbstractController {
    
    BookDAO bookDAO;
    
    public BookController(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }
    
    @Override
    public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
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
                int[] price = new int[numberOfBooks];

                for(int i=0; i < numberOfBooks; i++) {
                    isbn[i] = (String) request.getParameter("isbn"+(i+1));
                    title[i] = (String) request.getParameter("title"+(i+1));
                    author[i] = (String) request.getParameter("author"+(i+1));
                    price[i] = Integer.parseInt((String)request.getParameter("price"+(i+1)));
                }                

                ArrayList<Book> bookList = new ArrayList<Book>();

                for(int i=0; i < numberOfBooks; i++) {

                    Book b = new Book();
                    b.setIsbn(isbn[i]);
                    b.setTitle(title[i]);
                    b.setAuthor(author[i]);
                    b.setPrice(price[i]);
                    bookList.add(b);
                }

                for(Book book : bookList) {
                    bookDAO.addBook(book);
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
