/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.email.controller;

import com.email.bean.MessageBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
 * @author hpanjwani
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
            /* TODO output your page here. You may use following sample code. */                        
            
            String value = request.getParameter("action");
            
            if(value.equals("logout")) {
                out.println("<h1>Logout</h1>");
                HttpSession session = request.getSession();
                session.invalidate();
                response.sendRedirect("index.jsp");
            }
            
            if(value.equals("reply")) {
                out.println("<h1>Reply</h1>");
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/reply.jsp");
                rd.forward(request, response);
            }
            
            HttpSession session = request.getSession();            
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            //out.println("<h1>Connection</h1>");
            
            Connection conn = establishConnectionJDBC();            
            String queryLogin = "select * from userstable where UserName = ? and UserPassword = ?";            
            
            PreparedStatement loginStmt = conn.prepareStatement(queryLogin);
            loginStmt.setString(1, userName);
            loginStmt.setString(2, password);
            
            ResultSet resultSet = loginStmt.executeQuery();
            
            if(resultSet.next()) {
                //out.println("<h1>ResultSet</h1>");
                
                String queryMessage = "select * from messages where userName = ?";
                PreparedStatement msgStmt = conn.prepareStatement(queryMessage);
                msgStmt.setString(1, userName);
                
                ResultSet resultMessages = msgStmt.executeQuery();
                
                ArrayList<MessageBean> messagebeanList = new ArrayList<>();
                
                while(resultMessages.next()) {
                    
                    MessageBean messageBean = new MessageBean();
                    messageBean.setFromUser(resultMessages.getString("fromUser"));
                    messageBean.setUserName(resultMessages.getString("userName"));
                    messageBean.setMessageID(resultMessages.getString("messageID"));
                    messageBean.setMessage(resultMessages.getString("message"));
                    messageBean.setMessageDate(resultMessages.getString("messageDate"));
                    
                    //out.println(resultMessages.getString("fromUser"));
                    messagebeanList.add(messageBean);
                }
                
                session.setAttribute("userName",userName);
                session.setAttribute("messageList", messagebeanList);
                //out.println(session.getAttribute("userName"));
                //out.println(session.getAttribute("messageList"));

//                if(request.getParameter("rememberMe").equalsIgnoreCase("rememberMe")) {
//                    Cookie userCookie = new Cookie("userName", userName);
//                    Cookie passwordCookie = new Cookie("password", password);
//                    
//                    response.addCookie(userCookie);
//                    response.addCookie(passwordCookie);
//                }
                
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/UserView.jsp");
                rd.forward(request, response);
                
            }
            else {                
                RequestDispatcher rd = request.getRequestDispatcher("/index.jsp?error=true");
                rd.forward(request, response);
            }
            
        }
    }
    
    //  Connect to Database    
    protected Connection establishConnectionJDBC() throws SQLException  {
        
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
