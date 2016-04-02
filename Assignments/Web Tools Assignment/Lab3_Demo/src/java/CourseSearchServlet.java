/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Bean.Course;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dishu
 */
public class CourseSearchServlet extends HttpServlet {

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
       // HashMap<Object,Object>map=new HashMap<Object, Object>();
       // map.put();
       List<Course> listofcourses=new ArrayList<Course>();
       listofcourses=getCoursesAvailable();
       List<Course> outputCourses=new ArrayList<Course>();
        
       String instructorName= request.getParameter("instName");
       String courseTitle =  request.getParameter("courseName");
       
        instructorName = instructorName.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
        courseTitle = courseTitle.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+").trim();
        
        if(instructorName.equals("") && courseTitle.equals(""))
        {
            response.sendRedirect("error.jsp");
        }
        
        for(Course course:listofcourses)
        {
            if(course.getInstructor().equalsIgnoreCase(instructorName)|| course.getName().equalsIgnoreCase(courseTitle))
            {
                outputCourses.add(course);
            }
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Available Courses are:</title>");            
            out.println("</head>");
            out.println("<body><form method='post' action='addCourse.htm'>");
            out.println("<h2> Results found </h2>");
            for(Course course:outputCourses)
            {
                String crn=course.getCrn();
                String courseName=course.getName();
                
                
                out.println("<input type='checkbox' name='courseId' value='"+crn+"'/>" + crn + courseName +"<a href='addCourse.htm?crn="+crn+"&name="+courseName+"&action=single'> Add this course</a></h1>");
            }
            out.println("<input type='hidden' name='action' value='multiple'/>");
            out.println("<input type='submit' value='Add Selected Courses'/>");
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

    public static List<Course> getCoursesAvailable()
    {
        List<Course> courseList=new ArrayList<Course>();
        Course c1=new Course();
        c1.setCourseDescription("java programming");
        c1.setCrn("36099");
        c1.setInstructor("Khaled M. Bugrara");
        c1.setName("AED");
        
        Course c2=new Course();
        c2.setCourseDescription("Course fro learning web technologies used in frint end");
        c2.setCrn("37913");
        c2.setInstructor("YusufOzbek");
        c2.setName("Web Dsign and user exp");
        
        Course c3=new Course();
        c3.setCourseDescription("course for learning algorithms");
        c3.setCrn("34267");
        c3.setInstructor("Khaled M. Bugrara");
        c3.setName("Program Structure and Algorithms");
        
        Course c4=new Course();
        c4.setCourseDescription("course for learning java EE");
        c4.setCrn("31606");
        c4.setInstructor("YusufOzbek");
        c4.setName("Web Tools");
        
        courseList.add(c1);
        courseList.add(c2);
        courseList.add(c3);
        courseList.add(c4);
        
        return courseList;
    }
}
