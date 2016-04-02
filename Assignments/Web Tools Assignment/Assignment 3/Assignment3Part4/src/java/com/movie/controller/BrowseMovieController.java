/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movie.controller;

import com.movie.bean.MovieBean;
import com.movie.dao.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class BrowseMovieController extends HttpServlet {

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
            
            String search = (String) request.getAttribute("search");
            String type = (String) request.getAttribute("type");            
            
            String dburl = getServletContext().getInitParameter("dburl");
            String dbuser = getServletContext().getInitParameter("dbuser");
            String dbpassword = getServletContext().getInitParameter("dbpassword");
            String dbdriver = getServletContext().getInitParameter("dbdriver");
                         
            //database logic
            Connection conn = DAO.getConnectionJDBC(dburl, dbuser, dbpassword, dbdriver);
            
            String querySearch = "select * from movies where " + type + " like ?";            
            
            PreparedStatement searchStmt = conn.prepareStatement(querySearch);
            //searchStmt.setString(1, type);
            searchStmt.setString(1, '%'+search+'%');
            
            ResultSet resultSet = searchStmt.executeQuery();
            
            ArrayList<MovieBean> moviebeanList = new ArrayList<>();
            
            while(resultSet.next()) {
                
                MovieBean movieBean = new MovieBean();
                movieBean.setMovieTitle(resultSet.getString("title"));
                movieBean.setLeadActor(resultSet.getString("actor"));
                movieBean.setLeadActress(resultSet.getString("actress"));
                movieBean.setGenre(resultSet.getString("genre"));
                movieBean.setYear(Integer.parseInt(resultSet.getString("year")));
                
                //Adding to the arrayList
                moviebeanList.add(movieBean);
            }
            
            try {
               
                    resultSet.close();               
                    searchStmt.close();               
                    conn.close();
            }
            catch (SQLException e)  {
                e.printStackTrace();
            }
            
            session.setAttribute("movieList", moviebeanList);
            
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/result.jsp?action=browse&search="+search);
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
            Logger.getLogger(BrowseMovieController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(BrowseMovieController.class.getName()).log(Level.SEVERE, null, ex);
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
