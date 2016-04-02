/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.controller;

import com.myapp.dao.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
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
 * @author Kiran
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
            String dburl = getServletContext().getInitParameter("dburl");
            String dbuser = getServletContext().getInitParameter("dbuser");
            String dbpassword = getServletContext().getInitParameter("dbpassword");
            String dbdriver = getServletContext().getInitParameter("dbdriver");
            
            Connection conn = DAO.getConnectionJDBC(dburl, dbuser, dbpassword, dbdriver);

            String message = request.getParameter("message");
            HttpSession session = request.getSession();

            String userName = (String) session.getAttribute("userName");
            String recipient = request.getParameter("to");

            Random generator = new Random();
            int id = generator.nextInt(10000);

            String messageId = String.valueOf(id);
            //String queryMessage = "INSERT INTO messages (messageID, userName, fromUser,message) values(?,?,?,?)";
            String queryMessage = "INSERT INTO messages (messageID, userName, fromUser,message)"
                    + "values (" + messageId + ",'" + recipient + "','" + userName + "','"
                    + message + "')";

            Statement statement = conn.createStatement();
            int result = statement.executeUpdate(queryMessage);
            conn.close();
            if (result > 0) {
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/messageSent.jsp");
                rd.forward(request, response);
            }

        }
    }

//    private Connection getConnectionJDBC() throws IOException {
//        Connection connection = null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println("Where is your MySQL JDBC Driver?");
//            e.printStackTrace();
//        }
//        try {
//            connection = DriverManager.getConnection("jdbc:mysql://newton.neu.edu:"
//                    + "3306/usersdb", "student", "p@ssw0rd");
//        } catch (SQLException e) {
//            System.out.println("Connection Failed! Check output console");
//            e.printStackTrace();
//        }
//
//        if (connection != null) {
//            System.out.println("connection established");
//        }
//        return connection;
//    }

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
