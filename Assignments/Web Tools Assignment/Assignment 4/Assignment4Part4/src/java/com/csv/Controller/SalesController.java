/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csv.Controller;

import com.csv.DAO.SalesReadDAO;
import com.csv.DAO.SalesAddDAO;
import com.csv.POJO.SaleDetail;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author hpanjwani
 */
public class SalesController extends AbstractController {
    
    SalesReadDAO salesReadDao;
    SalesAddDAO salesAddDao;
    
    public SalesController(SalesReadDAO salesReadDao, SalesAddDAO salesAddDao) {
        this.salesReadDao = salesReadDao;
        this.salesAddDao = salesAddDao;
    }
    
    @Override
    public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        String action = request.getParameter("action");
        
        if(action.equals("displayForm")) {
            String filename = request.getParameter("name");

            List<SaleDetail> saleList = new ArrayList<SaleDetail>();

            saleList = salesReadDao.getAllSaleDetails(filename);
            
            session.setAttribute("saleList",saleList);
            mv.addObject("saleList",saleList);            
            mv.setViewName("index");
        }
        else if(action.equals("dbConnection")) {
            
            ArrayList<SaleDetail> saleList = (ArrayList<SaleDetail>)session.getAttribute("saleList");
            
            int numberOfRows = 0;
            
            numberOfRows = salesAddDao.addSale(saleList);
            
            session.setAttribute("numberOfRows",numberOfRows);
            mv.addObject("numberOfRows",numberOfRows);
            mv.setViewName("index");
        }     
        
        return mv;
    }    
}
