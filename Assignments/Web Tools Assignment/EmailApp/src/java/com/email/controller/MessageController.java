/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.email.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
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
public class MessageController extends HttpServlet {

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
            
            String message = request.getParameter("message");
            //out.println("<h2>" + message + "</h2>");
            
            HttpSession session = request.getSession();
            String userName = (String)session.getAttribute("userName");
            //out.println("<h2>" + userName + "</h2>");
            
            String fromUser = (String)request.getParameter("to");
            //out.println("<h2>" + fromUser + "</h2>");
            
            Connection conn = establishConnectionJDBC();
            Statement statement = conn.createStatement();
            
            Random generator = new Random();
            int id = generator.nextInt(10000);
            String messageId = String.valueOf(id);
            //out.println("<h2>" + messageId + "</h2>");
            
            String queryInsert = "insert into messages(messageID, userName, fromUser, message) values ("+messageId + ",'" + userName + "','" + fromUser + "','" + message + "')";
            //out.println("<h2>" + queryInsert + "</h2>");
            
            int result = statement.executeUpdate(queryInsert);
            
            if(result > 0) {
            
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/messageSent.jsp");
                rd.forward(request,response);                        
            }
        }
    }
    
    //  Connect to Database    
    protected Connection establishConnectionJDBC()  {
        
        Connection connection = null;
        
        try {
            
            //  Registering the driver name            
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        try {
            
            //  Creating a connection
            
            //  Example of factory pattern so that controller should not create new connection
            //  and if this does not exist, user might inject something
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/WebTools", "root", "");
        }
        catch(SQLException e) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return connection;
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
            Logger.getLogger(MessageController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MessageController.class.getName()).log(Level.SEVERE, null, ex);
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
