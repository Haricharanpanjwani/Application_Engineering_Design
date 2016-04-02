/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.controller;

import com.myapp.bean.MessageBean;
import com.myapp.dao.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kiran
 */
public class LoginController extends HttpServlet {

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
            String value = request.getParameter("action");

            if (value.equals("logout")) {
                HttpSession session = request.getSession();
                session.invalidate();
                response.sendRedirect("index.jsp");
            }

            if (value.equals("login")) {
                HttpSession session = request.getSession();

                //if session exists then redirect to user view
                if (session.getAttribute("userName") != null) {
                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/UserView.jsp");
                    rd.forward(request, response);
                }

                String userName = request.getParameter("userName");
                String password = request.getParameter("password");

                String dburl = getServletContext().getInitParameter("dburl");
                String dbuser = getServletContext().getInitParameter("dbuser");
                String dbpassword = getServletContext().getInitParameter("dbpassword");
                String dbdriver = getServletContext().getInitParameter("dbdriver");
                
                //database logic
                Connection conn = DAO.getConnectionJDBC(dburl, dbuser, dbpassword, dbdriver);

                //logic for checking the user exists in db
                String queryLogin = "select * from userstable where UserName=? and UserPassword=?";
                PreparedStatement loginstmt = conn.prepareStatement(queryLogin);
                loginstmt.setString(1, userName);
                loginstmt.setString(2, password);

                ResultSet resultSet = loginstmt.executeQuery();

                if (resultSet.next()) {
                    String queryMessages = "select * from messages where UserName=?";
                    PreparedStatement msgStmt = conn.prepareStatement(queryMessages);
                    msgStmt.setString(1, userName);
                    ResultSet resultMessages = msgStmt.executeQuery();

                    List<MessageBean> messageBeanList = new ArrayList<>();
                    while (resultMessages.next()) {
                        MessageBean messageBean = new MessageBean();
                        messageBean.setFromUser(resultMessages.getString("fromUser"));
                        messageBean.setUserName(resultMessages.getString("userName"));
                        messageBean.setMessageId(resultMessages.getString("messageId"));
                        messageBean.setMessage(resultMessages.getString("message"));
                        messageBean.setMessageDate(resultMessages.getString("messageDate"));
                        messageBeanList.add(messageBean);
                    }
                    resultMessages.close();
                    msgStmt.close();
                    conn.close();

                    //redirect for successful login
                    session.setAttribute("userName", userName);
                    session.setAttribute("messageList", messageBeanList);

                    //create cookie
                    Cookie userCookie = new Cookie("userName", request.getParameter("userName"));
                    Cookie passwordCookie = new Cookie("password", request.getParameter("password"));

                    response.addCookie(userCookie);
                    response.addCookie(passwordCookie);

                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/UserView.jsp");
                    rd.forward(request, response);

                } else {
                    //for invalid credentials
                    RequestDispatcher rd = request.getRequestDispatcher("/index.jsp?error=true");
                    rd.forward(request, response);
                }

            } else {
                //if action = reply
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/reply.jsp");
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
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
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
