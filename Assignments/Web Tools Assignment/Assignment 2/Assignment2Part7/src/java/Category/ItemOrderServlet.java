/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Category;

import Bean.Item;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hpanjwani
 */
public class ItemOrderServlet extends HttpServlet {

    
    private List<Item> itemList;
    private Set<Item> myItems;
    
    public ItemOrderServlet() {
        itemList = CategorySelectedServlet.getItemsAvailable();
    }
    
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
//            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ItemOrderServlet</title>");            
            out.println("</head>");
            out.println("<body>");  
            
        HttpSession session =request.getSession();    
        
        if(session.getAttribute("myItemList") != null ) {
                myItems = (Set<Item>) session.getAttribute("myItemList");

        }   else    {
                myItems = new HashSet<Item>();
        }
        
        try  {
            
            String actionValue=request.getParameter("action");
            
            if(actionValue.equalsIgnoreCase("single"))  {
                
                String name = request.getParameter("name");
                double price = Double.parseDouble(request.getParameter("price"));
                
                for(Item item : itemList ){
                    if(item.getItemName().equals(name)) {
                        myItems.add(item);               
                        out.println("<b><label>The following item has been added to your shopping cart successfully</label></b>");
                        out.println("<br /><br />");
                        out.println("<label>" + item.getItemName() + "</label>");
                        out.println("<br /><br />");
                    }
                }
            }
            else if(actionValue.equalsIgnoreCase("multiple"))
            {
                out.println("<b><label>The following item has been added to your shopping cart successfully</label></b>");                        
                out.println("<br /><br />");
                
                String[] selectedCourses = request.getParameterValues("itemID");
                
                for(int i=0;i < selectedCourses.length;i++){
                    for(Item item : itemList ){
                        if(item.getItemName().equals(selectedCourses[i]))   {
                            myItems.add(item);
                            out.println("<label>" + item.getItemName() + "</label>");
                            out.println("<br /><br />");
                        } 
                    }
                }
            }            
            else if(actionValue.equalsIgnoreCase("remove"))
            {
                boolean check = false;
                
                String removeCourse = request.getParameter("name");
                
                Iterator iterator = myItems.iterator();
                
                while (iterator.hasNext())  { 
                    if(check)break;
                    
                  Item item=(Item)iterator.next();
                  
                    if(item.getItemName().equals(removeCourse))   {      
                        myItems.remove(item);
                        check = true; 
                        out.println("<b><label>The following item has been successfully removed from your cart.</label></b>");
                        out.println("<br /><br />");
                        out.println("<label>" + item.getItemName() + "</label>");
                        out.println("<br /><br />");
                    }
                }                
            }
            
            session.setAttribute("myItemList", myItems);
            
            //response.sendRedirect("ItemView.jsp");
        }catch(Exception e){
            System.err.println("exception is"+e);
        }
        
        
            out.println("<a href='ItemView.jsp'>[ View Cart ]</a> " + "  "
                    + "<a href='categoryselectedservlet.htm?category=Books'>[ Go to Books Page ]</a> " + "  "
                    + "<a href='categoryselectedservlet.htm?category=Music'>[ Go to Music Page ]</a> " + "  "
                    + "<a href='categoryselectedservlet.htm?category=Computer'>[ Go to Computer Page ]</a>");
            //out.println("<h1>Servlet ItemOrderServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
