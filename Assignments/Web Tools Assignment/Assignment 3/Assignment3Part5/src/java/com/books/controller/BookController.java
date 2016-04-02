/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.books.controller;

import com.books.dao.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hpanjwani
 */
public class BookController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            HttpSession session = request.getSession();
            //String books = (String) session.getAttribute("numberOfBooks");
            
            int numberOfBooks = (Integer)session.getAttribute("numberOfBooks");
            
            String[] isbn = new String[numberOfBooks];
            String[] title = new String[numberOfBooks];
            String[] author = new String[numberOfBooks];
            int[] price = new int[numberOfBooks];
            
            for(int i=0; i < numberOfBooks; i++) {
                isbn[i] = (String) request.getAttribute("isbn"+(i+1));
                title[i] = (String) request.getAttribute("title"+(i+1));
                author[i] = (String) request.getAttribute("author"+(i+1));
                price[i] = Integer.parseInt((String)request.getAttribute("price"+(i+1)));
            }
            
            String dburl = getServletContext().getInitParameter("dburl");
            String dbuser = getServletContext().getInitParameter("dbuser");
            String dbpassword = getServletContext().getInitParameter("dbpassword");
            String dbdriver = getServletContext().getInitParameter("dbdriver");
                         
            //database logic
            Connection conn = DAO.getConnectionJDBC(dburl, dbuser, dbpassword, dbdriver);            
            
            for(int i=0; i < numberOfBooks; i++) {
                
                String queryAddBook = "INSERT INTO books "
                        + "values ('" + isbn[i] + "','" + title[i] + "','" + author[i] + "'," + price[i] + ")";
                                
                PreparedStatement preparedStatement = conn.prepareStatement(queryAddBook);
                preparedStatement.executeUpdate();                
                
                preparedStatement.close();
            }
            
            conn.close();
                
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/display.jsp");
            rd.forward(request, response);
            
        }
        catch(NumberFormatException e) {
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/display.jsp?action=error");
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
