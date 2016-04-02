/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.controller;

import com.myapp.DAO.SalesDAO;
import configuration.Newsalesorder;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author hpanjwani
 */
public class HomeController implements Controller {
    
    SalesDAO salesDAO;
    
    public HomeController(SalesDAO salesDAO) {
        this.salesDAO=salesDAO;
               
    }


    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session= request.getSession();
        String action= request.getParameter("action");
        
        ModelAndView mv= new ModelAndView();
        if(action.equals("display"))
        {
            int page= (Integer.parseInt(request.getParameter("page")));
            String fileName= request.getParameter("filename");
            
            ArrayList<Newsalesorder> salesList= salesDAO.getSalesListFromCSV(fileName,page);
            int records= salesDAO.getTotalCount(fileName);
            int noOfPages = (int) Math.ceil(records * 1.0 / 100);
            if(salesList.size()>0)
            {
                session.setAttribute("filename", fileName);
                session.setAttribute("salesList", salesList);
                session.setAttribute("currentPage", page);
                session.setAttribute("noOfPages", noOfPages);
                 mv.setViewName("csvRecords");
            }
            else
            {
               mv.setViewName("index");
            }
            
        }
        else  if(action.equals("displaymore"))
        {
            int page= Integer.parseInt(session.getAttribute("currentPage").toString())+1;
            session.setAttribute("currentPage", page);
            String fileName= session.getAttribute("filename").toString();
            ArrayList<Newsalesorder> salesList= salesDAO.getSalesListFromCSV(fileName,page);
            JSONObject obj = new JSONObject();
            obj.put("page", page);
            obj.put("salesList",salesList);
            PrintWriter out = response.getWriter();
            out.println(obj);
            return null;
        }
        return mv;
    }
    
}
