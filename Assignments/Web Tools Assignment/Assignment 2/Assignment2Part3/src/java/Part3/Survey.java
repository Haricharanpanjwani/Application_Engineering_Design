/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Part3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hpanjwani
 */
public class Survey extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Survey Form</title>");                 
            out.println("<meta charset='UTF-8'>");            
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            
            out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js\"></script>");
            out.println("<script type='text/javascript'>");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/javascript/createTextField.js");
            dispatcher.include(request, response);
            out.println("</script>"); 
            //Including BootStrap           
            out.println("<link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>");
            out.println("<script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js\"></script>");            
            out.println("</head>");
            out.println("<body>");            
            
            //out.println("<div id = 'childrenDivision'");
            out.println("<form id ='myForm' role=\"form\" action=\"ques.htm\" method=\"POST\" >");
            out.println("<div id = 'childrenDivision' class=\"container\">\n" +
"                <div class=\"panel panel-default\">\n" +
"                    <div class=\"panel-heading\">			       \n" +
"                        <b>Survey Form</b>\n" +
"                    </div>			      \n" +
"                </div>\n" +
"\n" +
"                <div id = 'question' class=\"form-group col-sm-6\">\n" +
"                    <label>How many children do you have?</label><input type=\"text\" id = 'number' name=\"number\" Placeholder=\"Number of Children\" class=\"form-control\" />				\n" +
"                </div>");
           
            out.println("<div class=\"form-group col-sm-12\">");
                out.println("<button type=\"button\" class=\"btn btn-primary btn-md\" id='submitButton' onClick='add()'>Submit Query</button>");
            out.println("</div>");
            
            out.println("</div>");
            
            out.println("</form>");
            //out.println("</div>");
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
        //processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Survey Form</title>");                 
            out.println("<meta charset='UTF-8'>");            
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");                        
            //Including BootStrap           
            out.println("<link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>");
            out.println("<script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js\"></script>");            
            out.println("</head>");
            out.println("<body>");  
            
            out.println("<div id = 'childrenDivision' class=\"container\">\n" +
"                <div class=\"panel panel-default\">\n" +
"                    <div class=\"panel-heading\">			       \n" +
"                        <b>Survey Form</b>\n" +
"                    </div>			      \n" +
"                </div>\n" +
"\n" +
"                <div class=\"form-group col-sm-6\">\n" +
"                    <label>Your childrens names are: </label>\n" +
"                </div>");
            
            out.println("<div class=\"form-group col-sm-12\"></div>");            
            
            Enumeration<String> names = request.getParameterNames();
            
            int i = 1;
            while(names.hasMoreElements()) {
                String name = (String) names.nextElement();
                String value = request.getParameter(name);                                                                
                
                if(name.contains("childName")) {
                    out.println("<div class=\"form-group col-sm-6\">");
                        out.println("<label>" + i + ".   " + value + "</label>");                
                    out.println("</div>");
                    i++;
                }
                out.println("<div class=\"form-group col-sm-12\"></div>");            
                
            }            
            
            out.println("</body>");
            out.println("</html>");   
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
