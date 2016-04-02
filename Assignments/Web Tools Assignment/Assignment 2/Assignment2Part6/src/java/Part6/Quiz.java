/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Part6;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hpanjwani
 */
@WebServlet(name = "Quiz", urlPatterns = {"/quiz.htm"})
public class Quiz extends HttpServlet {

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
            out.println("<title>Servlet Quiz</title>");               
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Quiz at " + request.getContextPath() + "</h1>");
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
    
    public String firstName = null;
    public String lastName = null;
    public String quesOne = null;
    public String quesTwo = null;
    public String quesThree = null;
    public String quesFour = null;
    public String quesFive = null;
    public String quesSix = null;
    public String quesSeven = null;
    public String quesEight = null;
    public String quesNine = null;
    public String quesTen = null;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);       
        participantDetails(response);
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
        
            String page = request.getParameter("page");
            firstName = request.getParameter("firstName");
            lastName = request.getParameter("lastName");
            quesOne = request.getParameter("ques1");
            quesTwo = request.getParameter("ques2");
            quesThree = request.getParameter("ques3");
            quesFour = request.getParameter("ques4");
            quesFive = request.getParameter("ques5");
            quesSix = request.getParameter("ques6");
            quesSeven = request.getParameter("ques7");
            quesEight = request.getParameter("ques8");
            quesNine = request.getParameter("ques9");
            quesTen = request.getParameter("ques10");
            
//            PrintWriter out = response.getWriter();
//        out.println("Hello " + page);
                        
            if (page == null) {
                participantDetails(response);
                return;
            }
            if (page.equals("1")) {
                if (firstName.equals("") || lastName.equals("") || firstName == null || lastName == null) {
                    participantDetails(response);
                } else {
                    firstQuestion(response);
                }   
            } 
            else if (page.equals("2")) {
                if (firstName.equals("") || lastName.equals("") || firstName == null || lastName == null) {
                    participantDetails(response);
                } else if(quesOne == null)  {                                              
                    firstQuestion(response);
                } else {
                    secondQuestion(response);
                }
            }
            else if (page.equals("3")) {
                if (firstName.equals("") || lastName.equals("") || firstName == null || lastName == null) {
                    participantDetails(response);
                } else if(quesTwo == null)  {                                              
                    secondQuestion(response);
                } else {
                    thirdQuestion(response);
                }
            }
            else if (page.equals("4")) {
                if (firstName.equals("") || lastName.equals("") || firstName == null || lastName == null) {
                    participantDetails(response);
                } else if(quesThree == null)  {                                              
                    thirdQuestion(response);
                } else {
                    fourthQuestion(response);
                }
            }
            else if (page.equals("5")) {
                if (firstName.equals("") || lastName.equals("") || firstName == null || lastName == null) {
                    participantDetails(response);
                } else if(quesFour == null)  {                                              
                    fourthQuestion(response);
                } else {
                    fifthQuestion(response);
                }
            }
            else if (page.equals("6")) {
                if (firstName.equals("") || lastName.equals("") || firstName == null || lastName == null) {
                    participantDetails(response);
                } else if(quesFive == null)  {                                              
                    fifthQuestion(response);
                } else {
                    sixthQuestion(response);
                }
            }
            else if (page.equals("7")) {
                if (firstName.equals("") || lastName.equals("") || firstName == null || lastName == null) {
                    participantDetails(response);
                } else if(quesSix == null)  {                                              
                    sixthQuestion(response);
                } else {
                    seventhQuestion(response);
                }
            }
            else if (page.equals("8")) {
                if (firstName.equals("") || lastName.equals("") || firstName == null || lastName == null) {
                    participantDetails(response);
                } else if(quesSeven == null)  {                                              
                    seventhQuestion(response);
                } else {
                    eigthQuestion(response);
                }
            }
            else if (page.equals("9")) {
                if (firstName.equals("") || lastName.equals("") || firstName == null || lastName == null) {
                    participantDetails(response);
                } else if(quesEight == null)  {                                              
                    eigthQuestion(response);
                } else {
                    ninthQuestion(response);
                }
            }
            else if (page.equals("10")) {
                if (firstName.equals("") || lastName.equals("") || firstName == null || lastName == null) {
                    participantDetails(response);
                } else if(quesNine == null)  {                                              
                    ninthQuestion(response);
                } else {
                    tenthQuestion(response);
                }
            }
            else if (page.equals("11")) {
                if (firstName.equals("") || lastName.equals("") || firstName == null || lastName == null) {
                    participantDetails(response);
                } else if(quesTen == null)  {                                              
                    tenthQuestion(response);
                } else {
                    quizResult(response);
                }
            }
    }    
    
    
    public void participantDetails(HttpServletResponse response) throws ServletException, IOException {
       
        response.setContentType("text/html");
        PrintWriter out = response.getWriter(); 
        out.println("<html>"); 
        out.println("<head><title>JSP Quiz</title></head>");   
        out.println("<meta name=\"viewpoint\" content=\"width=device-width,initial-scale=1\">");
        out.println("<link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>");
        out.println("<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>");
        out.println("<body style= 'background-color:#e3f2fd'>");                        
        
        out.println("<form role='form' action='quiz.htm' method='POST'>");
        
            out.println("<div class='container'>");
            
                out.println("<h2>Please enter your first and last name to start the Quiz!</h2>");
                out.println("<hr />");
            
                out.println("<div class='form-group col-sm-12>");                                                                                                            

                        out.println("<div class='form-group col-sm-6'>");
                            out.println("<input type='hidden' name='page' value='1' class='form-control' />");				
                        out.println("</div>");

                        out.println("<div class='form-group col-sm-6'>");
                            out.println("<label>First Name:</label><input type='text' name='firstName' Placeholder='First Name' class='form-control' />");				                    
                        out.println("</div>");

                        out.println("<div class='form-group col-sm-6'>");
                            out.println("<label>Last Name:</label><input type='text' name='lastName' Placeholder='Last Name' class='form-control' />");				
                        out.println("</div>");                                       

                        out.println("<div class='form-group col-sm-3'>");
                            out.println("<input type='reset' name='reset' value='Reset' class='form-control' />");				
                        out.println("</div>");

                        out.println("<div class='form-group col-sm-3'>");
                            out.println("<input type='submit' name='Submit' value='Submit' class='form-control' />");				
                        out.println("</div>");

                    
                out.println("</div>");
            out.println("</div>");
            
        out.println("</form>");
        
        out.println("</body>");        
        out.println("</html>");
    }
    
    public void firstQuestion(HttpServletResponse response) throws ServletException, IOException {
       
        response.setContentType("text/html");
        PrintWriter out = response.getWriter(); 
        out.println("<html>"); 
        out.println("<head><title>JSP Quiz</title></head>");   
        out.println("<meta name=\"viewpoint\" content=\"width=device-width,initial-scale=1\">");
        out.println("<link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>");
        out.println("<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>");
        out.println("<body style= 'background-color:#e3f2fd'>");        
        
        out.println("<form role='form' action='quiz.htm' method='POST'>");
        
            out.println("<div class='container'>");
            
                out.println("<h2>Quiz Page 1</h2>");
                out.println("<hr />");
        
                out.println("<div class='form-group col-sm-6>");
                    
                    out.println("<div class='form-group col-sm-6'>");
                        out.println("<label>Question 1. Which http method is idempotent?</label>");				
                    out.println("</div>");    
                    
                    out.println("<div class='form-group col-sm-6'>");                    
                        out.println("<p><label class='radio-inline'><input type='radio' name='ques1' value='get'>GET</label></p>");
                        out.println("<p><label class='radio-inline'><input type='radio' name='ques1' value='post'>POST</label></p>");
                        out.println("<p><label class='radio-inline'><input type='radio' name='ques1' value='trace'>TRACE</label></p>");
                        out.println("<p><label class='radio-inline'><input type='radio' name='ques1' value='option'>OPTION</label></p>");
                    out.println("</div>");
                    
                    out.println("<br />");
                    out.println("<br />");
                    out.println("<br />");
                    out.println("<br />");
                    
                    out.println("<div class='form-group col-sm-12'></div>");                                            
                    
                    out.println("<div class='form-group col-sm-1'>");
                        out.println("<input type='submit' name='Submit' value='Next' class='form-control' />");				
                    out.println("</div>");
                    
                    out.println("<div class='form-group col-sm-6'>");
                        out.println("<input type='hidden' name='page' value='2' class='form-control' />");
                        out.println("<input type='hidden' name='firstName' value='"+ firstName + "'class='form-control' />");				
                        out.println("<input type='hidden' name='lastName' value='"+ lastName + "'class='form-control' />");				
                    out.println("</div>");
                                
                out.println("</div>");
                
            out.println("</div>");
        out.println("</form>");    
        out.println("</body>");        
        out.println("</html>");
    }
    
    public void secondQuestion(HttpServletResponse response) throws ServletException, IOException {
       
        response.setContentType("text/html");
        PrintWriter out = response.getWriter(); 
        out.println("<html>"); 
        out.println("<head><title>JSP Quiz</title></head>");   
        out.println("<meta name=\"viewpoint\" content=\"width=device-width,initial-scale=1\">");
        out.println("<link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>");
        out.println("<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>");
        out.println("<body style= 'background-color:#e3f2fd'>");        
        
        out.println("<form role='form' action='quiz.htm' method='POST'>");
        
            out.println("<div class='container'>");
            
                out.println("<h2>Quiz Page 2</h2>");
                out.println("<hr />");
        
                out.println("<div class='form-group col-sm-6>");
                    
                    out.println("<div class='form-group col-sm-6'>");
                        out.println("<label>Question 2. Which statement is not true about ServletConfig?</label>");				
                    out.println("</div>");    
                    
                    out.println("<div class='form-group col-sm-6'>");                    
                        out.println("<p><label class='radio-inline'><input type='radio' name='ques2' value='There is one servlet config per one application'>There is one servlet config per one application</label></p>");
                        out.println("<p><label class='radio-inline'><input type='radio' name='ques2' value='We can access Servletcontext through it'>We can access Servletcontext through it</label></p>");
                        out.println("<p><label class='radio-inline'><input type='radio' name='ques2' value='Provide deploy-time information to server'>Provide deploy-time information to server</label></p>");
                        out.println("<p><label class='radio-inline'><input type='radio' name='ques2' value='option'>There is one servlet config per one servlet</label></p>");
                    out.println("</div>");
                    
                    out.println("<br />");
                    out.println("<br />");
                    out.println("<br />");
                    out.println("<br />");
                    
                    out.println("<div class='form-group col-sm-12'></div>");                                            
                    
                    out.println("<div class='form-group col-sm-1'>");
                        out.println("<input type='submit' name='Submit' value='Next' class='form-control' />");				
                    out.println("</div>");
                    
                    out.println("<div class='form-group col-sm-6'>");
                        out.println("<input type='hidden' name='page' value='3' class='form-control' />");
                        out.println("<input type='hidden' name='firstName' value='"+ firstName + "'class='form-control' />");				
                        out.println("<input type='hidden' name='lastName' value='"+ lastName + "'class='form-control' />");
                        out.println("<input type='hidden' name='ques1' value='"+ quesOne + "'class='form-control' />");
                    out.println("</div>");
                                
                out.println("</div>");
                
            out.println("</div>");
        out.println("</form>");    
        out.println("</body>");        
        out.println("</html>");
    }
    
    public void thirdQuestion(HttpServletResponse response) throws ServletException, IOException {
       
        response.setContentType("text/html");
        PrintWriter out = response.getWriter(); 
        out.println("<html>"); 
        out.println("<head><title>JSP Quiz</title></head>");   
        out.println("<meta name=\"viewpoint\" content=\"width=device-width,initial-scale=1\">");
        out.println("<link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>");
        out.println("<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>");
        out.println("<body style= 'background-color:#e3f2fd'>");        
        
        out.println("<form role='form' action='quiz.htm' method='POST'>");
        
            out.println("<div class='container'>");
            
                out.println("<h2>Quiz Page 3</h2>");
                out.println("<hr />");
        
                out.println("<div class='form-group col-sm-6>");
                    
                    out.println("<div class='form-group col-sm-6'>");
                        out.println("<label>Question 3. Which of these life-cycle method you can over-ride in your class?</label>");				
                    out.println("</div>");    
                    
                    out.println("<div class='form-group col-sm-6'>");                    
                        out.println("<p><label class='radio-inline'><input type='radio' name='ques3' value='init()'>init()</label></p>");
                        out.println("<p><label class='radio-inline'><input type='radio' name='ques3' value='service()'>service()</label></p>");
                        out.println("<p><label class='radio-inline'><input type='radio' name='ques3' value='doGet()'>doGet()</label></p>");
                        out.println("<p><label class='radio-inline'><input type='radio' name='ques3' value='All of these'>All of these</label></p>");
                    out.println("</div>");
                    
                    out.println("<br />");
                    out.println("<br />");
                    out.println("<br />");
                    out.println("<br />");
                    
                    out.println("<div class='form-group col-sm-12'></div>");                                            
                    
                    out.println("<div class='form-group col-sm-1'>");
                        out.println("<input type='submit' name='Submit' value='Next' class='form-control' />");				
                    out.println("</div>");
                    
                    out.println("<div class='form-group col-sm-6'>");
                        out.println("<input type='hidden' name='page' value='4' class='form-control' />");
                        out.println("<input type='hidden' name='firstName' value='"+ firstName + "'class='form-control' />");				
                        out.println("<input type='hidden' name='lastName' value='"+ lastName + "'class='form-control' />");
                        out.println("<input type='hidden' name='ques1' value='"+ quesOne + "'class='form-control' />");
                        out.println("<input type='hidden' name='ques2' value='"+ quesTwo + "'class='form-control' />");
                    out.println("</div>");
                                
                out.println("</div>");
                
            out.println("</div>");
        out.println("</form>");    
        out.println("</body>");        
        out.println("</html>");
    }
    
    public void fourthQuestion(HttpServletResponse response) throws ServletException, IOException {
       
        response.setContentType("text/html");
        PrintWriter out = response.getWriter(); 
        out.println("<html>"); 
        out.println("<head><title>JSP Quiz</title></head>");   
        out.println("<meta name=\"viewpoint\" content=\"width=device-width,initial-scale=1\">");
        out.println("<link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>");
        out.println("<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>");
        out.println("<body style= 'background-color:#e3f2fd'>");        
        
        out.println("<form role='form' action='quiz.htm' method='POST'>");
        
            out.println("<div class='container'>");
            
                out.println("<h2>Quiz Page 4</h2>");
                out.println("<hr />");
        
                out.println("<div class='form-group col-sm-6>");
                    
                    out.println("<div class='form-group col-sm-6'>");
                        out.println("<label>Question 4. Which method is called when client request come?</label>");				
                    out.println("</div>");    
                    
                    out.println("<div class='form-group col-sm-6'>");                    
                        out.println("<p><label class='radio-inline'><input type='radio' name='ques4' value='get()'>get()</label></p>");
                        out.println("<p><label class='radio-inline'><input type='radio' name='ques4' value='post()'>post()</label></p>");
                        out.println("<p><label class='radio-inline'><input type='radio' name='ques4' value='init()'>init()</label></p>");
                        out.println("<p><label class='radio-inline'><input type='radio' name='ques4' value='service()'>service()</label></p>");
                    out.println("</div>");
                    
                    out.println("<br />");
                    out.println("<br />");
                    out.println("<br />");
                    out.println("<br />");
                    
                    out.println("<div class='form-group col-sm-12'></div>");                                            
                    
                    out.println("<div class='form-group col-sm-1'>");
                        out.println("<input type='submit' name='Submit' value='Next' class='form-control' />");				
                    out.println("</div>");
                    
                    out.println("<div class='form-group col-sm-6'>");
                        out.println("<input type='hidden' name='page' value='5' class='form-control' />");
                        out.println("<input type='hidden' name='firstName' value='"+ firstName + "'class='form-control' />");				
                        out.println("<input type='hidden' name='lastName' value='"+ lastName + "'class='form-control' />");
                        out.println("<input type='hidden' name='ques1' value='"+ quesOne + "'class='form-control' />");
                        out.println("<input type='hidden' name='ques2' value='"+ quesTwo + "'class='form-control' />");
                        out.println("<input type='hidden' name='ques3' value='"+ quesThree + "'class='form-control' />");
                    out.println("</div>");
                                
                out.println("</div>");
                
            out.println("</div>");
        out.println("</form>");    
        out.println("</body>");        
        out.println("</html>");
    }
    
    public void fifthQuestion(HttpServletResponse response) throws ServletException, IOException {
       
        response.setContentType("text/html");
        PrintWriter out = response.getWriter(); 
        out.println("<html>"); 
        out.println("<head><title>JSP Quiz</title></head>");   
        out.println("<meta name=\"viewpoint\" content=\"width=device-width,initial-scale=1\">");
        out.println("<link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>");
        out.println("<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>");
        out.println("<body style= 'background-color:#e3f2fd'>");        
        
        out.println("<form role='form' action='quiz.htm' method='POST'>");
        
            out.println("<div class='container'>");
            
                out.println("<h2>Quiz Page 5</h2>");
                out.println("<hr />");
        
                out.println("<div class='form-group col-sm-6>");
                    
                    out.println("<div class='form-group col-sm-6'>");
                        out.println("<label>Question 5. Which life cycle method is called once in servlet life?</label>");				
                    out.println("</div>");    
                    
                    out.println("<div class='form-group col-sm-6'>");                    
                        out.println("<p><label class='radio-inline'><input type='radio' name='ques5' value='Class loading'>Class loading</label></p>");
                        out.println("<p><label class='radio-inline'><input type='radio' name='ques5' value='init()'>init()</label></p>");
                        out.println("<p><label class='radio-inline'><input type='radio' name='ques5' value='service()'>service()</label></p>");
                        out.println("<p><label class='radio-inline'><input type='radio' name='ques5' value='destroy()'>destroy()</label></p>");
                    out.println("</div>");
                    
                    out.println("<br />");
                    out.println("<br />");
                    out.println("<br />");
                    out.println("<br />");
                    
                    out.println("<div class='form-group col-sm-12'></div>");                                            
                    
                    out.println("<div class='form-group col-sm-1'>");
                        out.println("<input type='submit' name='Submit' value='Next' class='form-control' />");				
                    out.println("</div>");
                    
                    out.println("<div class='form-group col-sm-6'>");
                        out.println("<input type='hidden' name='page' value='6' class='form-control' />");
                        out.println("<input type='hidden' name='firstName' value='"+ firstName + "'class='form-control' />");				
                        out.println("<input type='hidden' name='lastName' value='"+ lastName + "'class='form-control' />");
                        out.println("<input type='hidden' name='ques1' value='"+ quesOne + "'class='form-control' />");
                        out.println("<input type='hidden' name='ques2' value='"+ quesTwo + "'class='form-control' />");
                        out.println("<input type='hidden' name='ques3' value='"+ quesThree + "'class='form-control' />");
                        out.println("<input type='hidden' name='ques4' value='"+ quesFour + "'class='form-control' />");
                    out.println("</div>");
                                
                out.println("</div>");
                
            out.println("</div>");
        out.println("</form>");    
        out.println("</body>");        
        out.println("</html>");
    }
    
    public void sixthQuestion(HttpServletResponse response) throws ServletException, IOException {
       
        response.setContentType("text/html");
        PrintWriter out = response.getWriter(); 
        out.println("<html>"); 
        out.println("<head><title>JSP Quiz</title></head>");   
        out.println("<meta name=\"viewpoint\" content=\"width=device-width,initial-scale=1\">");
        out.println("<link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>");
        out.println("<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>");
        out.println("<body style= 'background-color:#e3f2fd'>");        
        
        out.println("<form role='form' action='quiz.htm' method='POST'>");
        
            out.println("<div class='container'>");
            
                out.println("<h2>Quiz Page 6</h2>");
                out.println("<hr />");
        
                out.println("<div class='form-group col-sm-6>");
                    
                    out.println("<div class='form-group col-sm-6'>");
                        out.println("<label>Question 6. Which method does not exist in HttpServlet?</label>");				
                    out.println("</div>");    
                    
                    out.println("<div class='form-group col-sm-6'>");                    
                        out.println("<p><label class='radio-inline'><input type='radio' name='ques6' value='service'>service</label></p>");
                        out.println("<p><label class='radio-inline'><input type='radio' name='ques6' value='init'>init</label></p>");
                        out.println("<p><label class='radio-inline'><input type='radio' name='ques6' value='doGet'>doGet()</label></p>");
                        out.println("<p><label class='radio-inline'><input type='radio' name='ques6' value='doPost'>doPost()</label></p>");
                    out.println("</div>");
                    
                    out.println("<br />");
                    out.println("<br />");
                    out.println("<br />");
                    out.println("<br />");
                    
                    out.println("<div class='form-group col-sm-12'></div>");                                            
                    
                    out.println("<div class='form-group col-sm-1'>");
                        out.println("<input type='submit' name='Submit' value='Next' class='form-control' />");				
                    out.println("</div>");
                    
                    out.println("<div class='form-group col-sm-6'>");
                        out.println("<input type='hidden' name='page' value='7' class='form-control' />");
                        out.println("<input type='hidden' name='firstName' value='"+ firstName + "'class='form-control' />");				
                        out.println("<input type='hidden' name='lastName' value='"+ lastName + "'class='form-control' />");
                        out.println("<input type='hidden' name='ques1' value='"+ quesOne + "'class='form-control' />");
                        out.println("<input type='hidden' name='ques2' value='"+ quesTwo + "'class='form-control' />");
                        out.println("<input type='hidden' name='ques3' value='"+ quesThree + "'class='form-control' />");
                        out.println("<input type='hidden' name='ques4' value='"+ quesFour + "'class='form-control' />");
                        out.println("<input type='hidden' name='ques5' value='"+ quesFive + "'class='form-control' />");
                    out.println("</div>");
                                
                out.println("</div>");
                
            out.println("</div>");
        out.println("</form>");    
        out.println("</body>");        
        out.println("</html>");
    }
    
    public void seventhQuestion(HttpServletResponse response) throws ServletException, IOException {
       
        response.setContentType("text/html");
        PrintWriter out = response.getWriter(); 
        out.println("<html>"); 
        out.println("<head><title>JSP Quiz</title></head>");   
        out.println("<meta name=\"viewpoint\" content=\"width=device-width,initial-scale=1\">");
        out.println("<link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>");
        out.println("<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>");
        out.println("<body style= 'background-color:#e3f2fd'>");        
        
        out.println("<form role='form' action='quiz.htm' method='POST'>");
        
            out.println("<div class='container'>");
            
                out.println("<h2>Quiz Page 7</h2>");
                out.println("<hr />");
        
                out.println("<div class='form-group col-sm-6>");
                    
                    out.println("<div class='form-group col-sm-6'>");
                        out.println("<label>Question 7. Which interface contain servlet life-cycle methods?</label>");				
                    out.println("</div>");    
                    
                    out.println("<div class='form-group col-sm-6'>");                    
                        out.println("<p><label class='radio-inline'><input type='radio' name='ques7' value='HttpServlet'>HttpServlet</label></p>");
                        out.println("<p><label class='radio-inline'><input type='radio' name='ques7' value='GenericServlet'>GenericServlet</label></p>");
                        out.println("<p><label class='radio-inline'><input type='radio' name='ques7' value='service'>service</label></p>");
                        out.println("<p><label class='radio-inline'><input type='radio' name='ques7' value='servlet'>servlet</label></p>");
                    out.println("</div>");
                    
                    out.println("<br />");
                    out.println("<br />");
                    out.println("<br />");
                    out.println("<br />");
                    
                    out.println("<div class='form-group col-sm-12'></div>");                                            
                    
                    out.println("<div class='form-group col-sm-1'>");
                        out.println("<input type='submit' name='Submit' value='Next' class='form-control' />");				
                    out.println("</div>");
                    
                    out.println("<div class='form-group col-sm-6'>");
                        out.println("<input type='hidden' name='page' value='8' class='form-control' />");
                        out.println("<input type='hidden' name='firstName' value='"+ firstName + "'class='form-control' />");				
                        out.println("<input type='hidden' name='lastName' value='"+ lastName + "'class='form-control' />");
                        out.println("<input type='hidden' name='ques1' value='"+ quesOne + "'class='form-control' />");
                        out.println("<input type='hidden' name='ques2' value='"+ quesTwo + "'class='form-control' />");
                        out.println("<input type='hidden' name='ques3' value='"+ quesThree + "'class='form-control' />");
                        out.println("<input type='hidden' name='ques4' value='"+ quesFour + "'class='form-control' />");
                        out.println("<input type='hidden' name='ques5' value='"+ quesFive + "'class='form-control' />");
                        out.println("<input type='hidden' name='ques6' value='"+ quesSix + "'class='form-control' />");
                    out.println("</div>");
                                
                out.println("</div>");
                
            out.println("</div>");
        out.println("</form>");    
        out.println("</body>");        
        out.println("</html>");
    }
    
    public void eigthQuestion(HttpServletResponse response) throws ServletException, IOException {
       
        response.setContentType("text/html");
        PrintWriter out = response.getWriter(); 
        out.println("<html>"); 
        out.println("<head><title>JSP Quiz</title></head>");   
        out.println("<meta name=\"viewpoint\" content=\"width=device-width,initial-scale=1\">");
        out.println("<link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>");
        out.println("<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>");
        out.println("<body style= 'background-color:#e3f2fd'>");        
        
        out.println("<form role='form' action='quiz.htm' method='POST'>");
        
            out.println("<div class='container'>");
            
                out.println("<h2>Quiz Page 8</h2>");
                out.println("<hr />");
        
                out.println("<div class='form-group col-sm-6>");
                    
                    out.println("<div class='form-group col-sm-6'>");
                        out.println("<label>Question 8. Which life-cycle method make ready the servlet for garbage collection??</label>");				
                    out.println("</div>");    
                    
                    out.println("<div class='form-group col-sm-6'>");                    
                        out.println("<p><label class='radio-inline'><input type='radio' name='ques8' value='init'>init</label></p>");
                        out.println("<p><label class='radio-inline'><input type='radio' name='ques8' value='service'>service</label></p>");
                        out.println("<p><label class='radio-inline'><input type='radio' name='ques8' value='destroy'>destroy</label></p>");
                        out.println("<p><label class='radio-inline'><input type='radio' name='ques8' value='system.gc'>system.gc</label></p>");
                    out.println("</div>");
                    
                    out.println("<br />");
                    out.println("<br />");
                    out.println("<br />");
                    out.println("<br />");
                    
                    out.println("<div class='form-group col-sm-12'></div>");                                            
                    
                    out.println("<div class='form-group col-sm-1'>");
                        out.println("<input type='submit' name='Submit' value='Next' class='form-control' />");				
                    out.println("</div>");
                    
                    out.println("<div class='form-group col-sm-6'>");
                        out.println("<input type='hidden' name='page' value='9' class='form-control' />");
                        out.println("<input type='hidden' name='firstName' value='"+ firstName + "'class='form-control' />");				
                        out.println("<input type='hidden' name='lastName' value='"+ lastName + "'class='form-control' />");
                        out.println("<input type='hidden' name='ques1' value='"+ quesOne + "'class='form-control' />");
                        out.println("<input type='hidden' name='ques2' value='"+ quesTwo + "'class='form-control' />");
                        out.println("<input type='hidden' name='ques3' value='"+ quesThree + "'class='form-control' />");
                        out.println("<input type='hidden' name='ques4' value='"+ quesFour + "'class='form-control' />");
                        out.println("<input type='hidden' name='ques5' value='"+ quesFive + "'class='form-control' />");
                        out.println("<input type='hidden' name='ques6' value='"+ quesSix + "'class='form-control' />");
                        out.println("<input type='hidden' name='ques7' value='"+ quesSeven + "'class='form-control' />");
                    out.println("</div>");
                                
                out.println("</div>");
                
            out.println("</div>");
        out.println("</form>");    
        out.println("</body>");        
        out.println("</html>");
    }
    
    public void ninthQuestion(HttpServletResponse response) throws ServletException, IOException {
       
        response.setContentType("text/html");
        PrintWriter out = response.getWriter(); 
        out.println("<html>"); 
        out.println("<head><title>JSP Quiz</title></head>");   
        out.println("<meta name=\"viewpoint\" content=\"width=device-width,initial-scale=1\">");
        out.println("<link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>");
        out.println("<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>");
        out.println("<body style= 'background-color:#e3f2fd'>");        
        
        out.println("<form role='form' action='quiz.htm' method='POST'>");
        
            out.println("<div class='container'>");
            
                out.println("<h2>Quiz Page 9</h2>");
                out.println("<hr />");
        
                out.println("<div class='form-group col-sm-6>");
                    
                    out.println("<div class='form-group col-sm-6'>");
                        out.println("<label>Question 9. Which life-cycle method make ready the servlet for garbage collection??</label>");				
                    out.println("</div>");    
                    
                    out.println("<div class='form-group col-sm-6'>");                    
                        out.println("<p><label class='radio-inline'><input type='radio' name='ques9' value='init'>init</label></p>");
                        out.println("<p><label class='radio-inline'><input type='radio' name='ques9' value='service'>service</label></p>");
                        out.println("<p><label class='radio-inline'><input type='radio' name='ques9' value='destroy'>destroy</label></p>");
                        out.println("<p><label class='radio-inline'><input type='radio' name='ques9' value='system.gc'>system.gc</label></p>");
                    out.println("</div>");
                    
                    out.println("<br />");
                    out.println("<br />");
                    out.println("<br />");
                    out.println("<br />");
                    
                    out.println("<div class='form-group col-sm-12'></div>");                                            
                    
                    out.println("<div class='form-group col-sm-1'>");
                        out.println("<input type='submit' name='Submit' value='Next' class='form-control' />");				
                    out.println("</div>");
                    
                    out.println("<div class='form-group col-sm-6'>");
                        out.println("<input type='hidden' name='page' value='10' class='form-control' />");
                        out.println("<input type='hidden' name='firstName' value='"+ firstName + "'class='form-control' />");				
                        out.println("<input type='hidden' name='lastName' value='"+ lastName + "'class='form-control' />");
                        out.println("<input type='hidden' name='ques1' value='"+ quesOne + "'class='form-control' />");
                        out.println("<input type='hidden' name='ques2' value='"+ quesTwo + "'class='form-control' />");
                        out.println("<input type='hidden' name='ques3' value='"+ quesThree + "'class='form-control' />");
                        out.println("<input type='hidden' name='ques4' value='"+ quesFour + "'class='form-control' />");
                        out.println("<input type='hidden' name='ques5' value='"+ quesFive + "'class='form-control' />");
                        out.println("<input type='hidden' name='ques6' value='"+ quesSix + "'class='form-control' />");
                        out.println("<input type='hidden' name='ques7' value='"+ quesSeven + "'class='form-control' />");
                        out.println("<input type='hidden' name='ques8' value='"+ quesEight + "'class='form-control' />");
                    out.println("</div>");
                                
                out.println("</div>");
                
            out.println("</div>");
        out.println("</form>");    
        out.println("</body>");        
        out.println("</html>");
    }
    
    public void tenthQuestion(HttpServletResponse response) throws ServletException, IOException {
       
        response.setContentType("text/html");
        PrintWriter out = response.getWriter(); 
        out.println("<html>"); 
        out.println("<head><title>JSP Quiz</title></head>"); 
        out.println("<meta name=\"viewpoint\" content=\"width=device-width,initial-scale=1\">");
        out.println("<link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>");
        out.println("<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>");
        out.println("<body style= 'background-color:#e3f2fd'>");                           
        
        out.println("<form role='form' action='quiz.htm' method='POST'>");
        
            out.println("<div class='container'>");
            
                out.println("<h2>Quiz Page 10</h2>");
                out.println("<hr />");
        
                out.println("<div class='form-group col-sm-6>");                                                                 
                    
                    out.println("<div class='form-group col-sm-6'>");
                        out.println("<label>Question 10. Which tag of DD maps internal name of servlet to public URL pattern?</label>");				
                    out.println("</div>");    
                    
                    out.println("<div class='form-group col-sm-6'>");                    
                        out.println("<p><label class='radio-inline'><input type='radio' name='ques10' value='servlet'>servlet</label></p>");
                        out.println("<p><label class='radio-inline'><input type='radio' name='ques10' value='servlet-mapping'>servlet-mapping</label></p>");
                        out.println("<p><label class='radio-inline'><input type='radio' name='ques10' value='web-app'>web-app</label></p>");
                        out.println("<p><label class='radio-inline'><input type='radio' name='ques10' value='servlet-mappings'>servlet-mappings</label></p>");
                    out.println("</div>");
                    
                    out.println("<div class='form-group col-sm-12'></div>");                     

                    out.println("<div class='form-group col-sm-2'>");
                        out.println("<input type='submit' name='Submit' value='Submit' class='form-control' />");				
                    out.println("</div>");
                    
                    out.println("<div class='form-group col-sm-6'>");
                        out.println("<input type='hidden' name='page' value='11' class='form-control' />");				
                        out.println("<input type='hidden' name='firstName' value='"+ firstName + "'class='form-control' />");				
                        out.println("<input type='hidden' name='lastName' value='"+ lastName + "'class='form-control' />");				
                        out.println("<input type='hidden' name='ques1' value='"+ quesOne + "'class='form-control' />");				
                        out.println("<input type='hidden' name='ques2' value='"+ quesTwo + "'class='form-control' />");
                        out.println("<input type='hidden' name='ques3' value='"+ quesThree + "'class='form-control' />");
                        out.println("<input type='hidden' name='ques4' value='"+ quesFour + "'class='form-control' />");
                        out.println("<input type='hidden' name='ques5' value='"+ quesFive + "'class='form-control' />");
                        out.println("<input type='hidden' name='ques6' value='"+ quesSix + "'class='form-control' />");
                        out.println("<input type='hidden' name='ques7' value='"+ quesSeven + "'class='form-control' />");
                        out.println("<input type='hidden' name='ques8' value='"+ quesEight + "'class='form-control' />");
                        out.println("<input type='hidden' name='ques9' value='"+ quesNine + "'class='form-control' />");
                    out.println("</div>");        

                out.println("</div>");
                
            out.println("</div>");
            
        out.println("</form>");    
        out.println("</body>");        
        out.println("</html>");
    }
    
    public void quizResult(HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<meta name=\"viewpoint\" content=\"width=device-width,initial-scale=1\">");
        out.println("<link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>");
        out.println("<script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>");
        out.println("<body style= 'background-color:#e3f2fd'>");          
        out.println("<TITLE>Quiz Result</TITLE>");
        out.println("</head>");
        out.println("<body>");        
        
            out.println("<div class='container'>");
            
                out.println("<h2>Quiz Result</h2>");
                out.println("<hr />");
        
            out.println("<div class='form-group col-sm-6>");                                              
        
                  
            out.println("<br />");
            out.println("<br />");
            out.println("<div class='form-group col-sm-6'>");
                out.println("<h4>Participant Details</h4>");
            out.println("</div>");                

            out.println("<div class='form-group col-sm-3'>");
                out.println("<label>First Name: </label><p>"+  firstName + "</p>");				                    
            out.println("</div>");

            out.println("<div class='form-group col-sm-3'>");
                out.println("<label>Last Name: </label><p>"+  lastName + "</p>");				
            out.println("</div>");
            
            out.println("<div class='form-group col-sm-12'>");
                out.println("<label>Submitted Ans 1: </label><p>"+  quesOne + "</p>");
            out.println("</div>");
            
            out.println("<div class='form-group col-sm-12'>");
                out.println("<label>Submitted Ans 2: </label><p>"+  quesTwo + "</p>");
            out.println("</div>");
            
            out.println("<div class='form-group col-sm-12'>");
                out.println("<label>Submitted Ans 3: </label><p>"+  quesThree + "</p>");
            out.println("</div>");
            
            out.println("<div class='form-group col-sm-12'>");
                out.println("<label>Submitted Ans 4: </label><p>"+  quesFour + "</p>");
            out.println("</div>");
            
            out.println("<div class='form-group col-sm-12'>");
                out.println("<label>Submitted Ans 5: </label><p>"+  quesFive + "</p>");
            out.println("</div>");
            
            out.println("<div class='form-group col-sm-12'>");
                out.println("<label>Submitted Ans 6: </label><p>"+  quesSix + "</p>");
            out.println("</div>");
            
            out.println("<div class='form-group col-sm-12'>");
                out.println("<label>Submitted Ans 7: </label><p>"+  quesSeven + "</p>");
            out.println("</div>");
            
            out.println("<div class='form-group col-sm-12'>");
                out.println("<label>Submitted Ans 8: </label><p>"+  quesEight + "</p>");
            out.println("</div>");
            
            out.println("<div class='form-group col-sm-12'>");
                out.println("<label>Submitted Ans 9: </label><p>"+  quesNine + "</p>");
            out.println("</div>");
            
            out.println("<div class='form-group col-sm-12'>");
                out.println("<label>Submitted Ans 10: </label><p>"+  quesTen + "</p>");
            out.println("</div>");
            
            out.println("</div>");
            out.println("</div>");
                
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

