/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sales.Controller;

import com.sales.DAO.SalesAddDAO;
import com.sales.DAO.SalesReadDAO;
import com.sales.bean.SaleBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class SalesController extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            SalesReadDAO dao = new SalesReadDAO();
            SalesAddDAO addDao = new SalesAddDAO();
            
            HttpSession session = request.getSession();            
            String action = request.getParameter("action");
            
            if(action.equals("displayForm")) {
                String fileName = request.getParameter("name");                                

                ArrayList<SaleBean> saleList = (ArrayList<SaleBean>) dao.getAllSaleDetails(fileName);
                
                request.setAttribute("fileName", fileName);
                request.setAttribute("saleList", saleList);
                
                session.setAttribute("saleList", saleList);
            
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp?action=read&name="+fileName);
                rd.forward(request, response);
            }
            else if(action.equals("addDB")) {
                
                ArrayList<SaleBean> saleDetail = (ArrayList<SaleBean>)session.getAttribute("saleList");
            
                int numberOfRows = 0;
                
                try {
                    numberOfRows = addDao.addSale(saleDetail);
                }
                catch(SQLException ex) {
                    ex.printStackTrace();
                }
                
                request.setAttribute("numberOfRows",numberOfRows);
                
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp?action=success");
                rd.forward(request, response);
            }
            
//            String dburl = getServletContext().getInitParameter("dburl");
//            String dbuser = getServletContext().getInitParameter("dbuser");
//            String dbpassword = getServletContext().getInitParameter("dbpassword");
//            String dbdriver = getServletContext().getInitParameter("dbdriver");
//                         
//            //database logic
//            Connection conn = DAO.getConnectionJDBC(dburl, dbuser, dbpassword, dbdriver);
//            
//            String querySearch = "select * from movies where " + type + " like ?";            
//            
//            PreparedStatement searchStmt = conn.prepareStatement(querySearch);
//            //searchStmt.setString(1, type);
//            searchStmt.setString(1, '%'+search+'%');
//            
//            ResultSet resultSet = searchStmt.executeQuery();
//            
//            ArrayList<MovieBean> moviebeanList = new ArrayList<>();
//            
//            while(resultSet.next()) {
//                
//                MovieBean movieBean = new MovieBean();
//                movieBean.setMovieTitle(resultSet.getString("title"));
//                movieBean.setLeadActor(resultSet.getString("actor"));
//                movieBean.setLeadActress(resultSet.getString("actress"));
//                movieBean.setGenre(resultSet.getString("genre"));
//                movieBean.setYear(Integer.parseInt(resultSet.getString("year")));
//                
//                //Adding to the arrayList
//                moviebeanList.add(movieBean);
//            }
//            
//            try {
//               
//                    resultSet.close();               
//                    searchStmt.close();               
//                    conn.close();
//            }
//            catch (SQLException e)  {
//                e.printStackTrace();
//            }
            
//            session.setAttribute("movieList", moviebeanList);
//            
//            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/result.jsp?action=browse&search="+search);
//            rd.forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
