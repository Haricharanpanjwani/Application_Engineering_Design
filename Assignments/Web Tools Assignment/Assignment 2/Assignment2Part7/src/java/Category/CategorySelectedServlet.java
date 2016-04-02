/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Category;

import Bean.Item;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hpanjwani
 */
public class CategorySelectedServlet extends HttpServlet {

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
            
            List<Item> listOfItems = new ArrayList<Item>();
            listOfItems = getItemsAvailable();
            
            List<Item> availableItems = new ArrayList<Item>();
            
            String category =  request.getParameter("category");
            
            if(category.equals("")) {
                response.sendRedirect("error.jsp");
            }
            
            for(Item items : listOfItems)
            {
                if(items.getCategoryName().equalsIgnoreCase(category))
                {
                    availableItems.add(items);
                }
            }
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Select Items</title>");            
            out.println("</head>");
            out.println("<body><form method='post' action='cart.htm'>");
            out.println("<a href='ItemView.jsp' style=\"float:right;\"><img src='images/cart.png' alt='cart'></a>");
            out.println("<h2> Shop for " + category + "</h2>");
            out.println("<p style='float:right'>View Cart</p>");            
            out.println("<br /><br /><hr />");
            
            for(Item items : availableItems)
            {
                String name = items.getItemName();
                Double price = items.getPrice();
                int itemID = items.getItemID();
                                
                out.println("<input type='checkbox' name='itemID' value='"+name+"'/>" + name + "  ["+ price +"]  " +"<a href='cart.htm?name="+name+"&price="+price+"&action=single'> Add this Item</a></h1>");
                out.println("<br /><br />");
            }
            out.println("<input type='hidden' name='action' value='multiple'/>");
            out.println("<input type='submit' value='Add to Cart'/>");
            out.println("</form>");
            
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

    public static List<Item> getItemsAvailable()
    {
        List<Item> itemList=new ArrayList<Item>();
        
        Item item1 = new Item();
        item1.setCategoryName("Books");
        item1.setItemID(1);
        item1.setItemName("Java Servlet Programming");
        item1.setPrice(29.95);
        item1.setItemDescription("Book for learning java servlet");
        
        Item item2 = new Item();
        item2.setCategoryName("Books");
        item2.setItemID(2);
        item2.setItemName("Oracle Database Programming");
        item2.setPrice(48.95);
        item2.setItemDescription("Book for learning Oracle");
        
        Item item3 = new Item();
        item3.setCategoryName("Books");
        item3.setItemID(3);
        item3.setItemName("System Analysis and Design with UML");
        item3.setPrice(14.95);
        item3.setItemDescription("Book for learning UML");
        
        Item item4 = new Item();
        item4.setCategoryName("Books");
        item4.setItemID(4);
        item4.setItemName("Object Oriented Software Engineering");
        item4.setPrice(35.95);
        item4.setItemDescription("Book for learning Object Oriented Programming");
        
        Item item5 = new Item();
        item5.setCategoryName("Books");
        item5.setItemID(5);
        item5.setItemName("Java Web Services");
        item5.setPrice(27.95);
        item5.setItemDescription("Book for learning about Java Web Services");
        
        Item item6 = new Item();
        item6.setCategoryName("Music");
        item6.setItemID(6);
        item6.setItemName("I am Going to tell you a secret a Madonna");
        item6.setPrice(26.95);
        item6.setItemDescription("Song by Madonna");
        
        Item item7 = new Item();
        item7.setCategoryName("Music");
        item7.setItemID(7);
        item7.setItemName("Baby one more time by Britney Spears");
        item7.setPrice(10.95);
        item7.setItemDescription("Song by Britney");
        
        Item item8 = new Item();
        item8.setCategoryName("Music");
        item8.setItemID(8);
        item8.setItemName("Justified by Justin Timberlake");
        item8.setPrice(9.95);
        item8.setItemDescription("Song by Justin");
        
        Item item9 = new Item();
        item9.setCategoryName("Music");
        item9.setItemID(9);
        item9.setItemName("Loose by Nelly Furtado");
        item9.setPrice(13.95);
        item9.setItemDescription("Song by Nelly Furtado");
        
        Item item10 = new Item();
        item10.setCategoryName("Music");
        item10.setItemID(10);
        item10.setItemName("Gold Digger by Kanye West");
        item10.setPrice(10.95);
        item10.setItemDescription("Song by Kanye West");
        
        Item item11 = new Item();
        item11.setCategoryName("Computer");
        item11.setItemID(11);
        item11.setItemName("Apple MacBook Pro with 13.3 Display");
        item11.setPrice(1299.99);
        item11.setItemDescription("Apple Laptop");
        
        Item item12 = new Item();
        item12.setCategoryName("Computer");
        item12.setItemID(12);
        item12.setItemName("Asus Laptop with Centrino 2 Black");
        item12.setPrice(949.99);
        item12.setItemDescription("Asus Laptop");
        
        Item item13 = new Item();
        item13.setCategoryName("Computer");
        item13.setItemID(13);
        item13.setItemName("HP Pavilion Laptop with Centrino 2 Black");
        item13.setPrice(1199.99);
        item13.setItemDescription("HP Laptop");
        
        Item item14 = new Item();
        item14.setCategoryName("Computer");
        item14.setItemID(14);
        item14.setItemName("Toshiba Satellite with Centrino 2 - Copper");
        item14.setPrice(899.99);
        item14.setItemDescription("Toshiba Laptop");
        
        Item item15 = new Item();
        item15.setCategoryName("Computer");
        item15.setItemID(15);
        item15.setItemName("Sony VAIO Laptop with Core 2 Duo");
        item15.setPrice(779.99);
        item15.setItemDescription("Sony VAIO Laptop");
        
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);
        itemList.add(item6);
         itemList.add(item7);
        itemList.add(item8);
        itemList.add(item9);
        itemList.add(item10);
        itemList.add(item11);
        itemList.add(item12);
        itemList.add(item13);
        itemList.add(item14);
        itemList.add(item15);
        
        return itemList;
    }
}


