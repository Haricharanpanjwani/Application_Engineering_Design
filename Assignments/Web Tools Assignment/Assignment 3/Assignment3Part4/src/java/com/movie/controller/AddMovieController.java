/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movie.controller;

import com.movie.dao.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hpanjwani
 */
public class AddMovieController extends HttpServlet {

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
            
            String movieTitle = (String) request.getAttribute("movieTitle");
            String actor = (String) request.getAttribute("actor");
            String actress = (String) request.getAttribute("actress");
            String genre = (String) request.getAttribute("genre");
            String year = (String) request.getAttribute("year");            
                    
            String dburl = getServletContext().getInitParameter("dburl");
            String dbuser = getServletContext().getInitParameter("dbuser");
            String dbpassword = getServletContext().getInitParameter("dbpassword");
            String dbdriver = getServletContext().getInitParameter("dbdriver");
                         
            //database logic
            Connection conn = DAO.getConnectionJDBC(dburl, dbuser, dbpassword, dbdriver);
            
            String queryAddMovie = "INSERT INTO movies "
                    + "values ('" + movieTitle + "','" + actor + "','" + actress + "','"
                    + genre + "'," + year + ")";
            
            PreparedStatement preparedStatement = conn.prepareStatement(queryAddMovie);
            //preparedStatement.executeUpdate();       

            int result = preparedStatement.executeUpdate(queryAddMovie);
            
            try {                
               
                    preparedStatement.close();               
                    conn.close();
            }
            catch (SQLException e)  {
                e.printStackTrace();
            }
            
            if (result > 0) {
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/result.jsp?action=add");
                rd.forward(request, response);
            }                     
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
            Logger.getLogger(AddMovieController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AddMovieController.class.getName()).log(Level.SEVERE, null, ex);
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
