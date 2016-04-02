/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.edu.servlet;

import com.neu.edu.DAO.CustomerDAO;
import com.neu.edu.pojo.Product;
import com.neu.edu.DAO.DAO;
import com.neu.edu.DAO.OrderDAO;
import com.neu.edu.DAO.ProductDAO;
import com.neu.edu.pojo.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author kumaran_jay
 */
public class HomeController implements Controller {

    ProductDAO productDAO;
    CustomerDAO customerDAO;
    OrderDAO orderDAO;

    public HomeController(ProductDAO productDAO, CustomerDAO customerDAO, OrderDAO orderDAO) {
        this.productDAO = productDAO;
        this.customerDAO = customerDAO;
        this.orderDAO = orderDAO;

    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {

        HttpSession session = hsr.getSession();
        String action = hsr.getParameter("action");
        ModelAndView mv = new ModelAndView();
        if (action.equals("display")) {
            List<Product> productList = productDAO.getAllProducts();
            mv.addObject(productList);
            mv.setViewName("displayProducts");
        } else if (action.equals("addtocart")) {

            ArrayList<Product> cart;
            //HashSet<Product> cart;
            if (session.getAttribute("cart") != null) {
                cart = (ArrayList<Product>) session.getAttribute("cart");
            } else {
                cart = new ArrayList<>();
            }

            int id = Integer.parseInt(hsr.getParameter("id"));
            Product product = productDAO.getProductById(id);
            if (!cart.contains(product)) {
                cart.add(product);
            }
            float total = 0;
            for (Product p : cart) {
                total = total + p.getPrice();
            }
            session.setAttribute("cart", cart);
            mv.addObject("total", total);
            mv.setViewName("viewCart");

        } else if (action.equals("logout")) {
            session.invalidate();
            mv.setViewName("index");

        } else if (action.equals("viewcart")) {
            mv.setViewName("viewCart");
        } else if (action.equals("checkout")) {

            if (session.getAttribute("customerId") != null) {
                int customerId = (int) session.getAttribute("customerId");
                ArrayList<Product> cart = (ArrayList<Product>) session.getAttribute("cart");
                orderDAO.checkout(customerId, cart);
                session.removeAttribute("cart");
                mv.setViewName("checkout");
            } else {
                mv.setViewName("signup");
            }
        } else if (action.equals("signup")) {

            Customer c = new Customer();
            c.setName(hsr.getParameter("name"));
            c.setCity(hsr.getParameter("city"));
            c.setPhone((hsr.getParameter("number")));
            c.setUsername(hsr.getParameter("username"));
            c.setPassword(hsr.getParameter("password"));

            int customerId = customerDAO.addCustomer(c);
            session.setAttribute("customerId", customerId);
            session.setAttribute("customerName", hsr.getParameter("name"));

            ArrayList<Product> cart = (ArrayList<Product>) session.getAttribute("cart");

            orderDAO.checkout(customerId, cart);
            session.removeAttribute("cart");
            mv.setViewName("checkout");
        } else if(action.equals("login")){
            String uname = hsr.getParameter("username");
            String pwd = hsr.getParameter("password");
            
            Customer c = customerDAO.verifyUser(uname, pwd);
            if(c != null){
                session.setAttribute("customerId", c.getCustomerID());
                session.setAttribute("customerName", c.getName());
                
                mv.setViewName("index");
            }else{
                mv.addObject("error", "true");
                mv.setViewName("login");
            }
        }else if(action.equals("loginpage")){
            mv.setViewName("login");
        }

        return mv;
    }

}
