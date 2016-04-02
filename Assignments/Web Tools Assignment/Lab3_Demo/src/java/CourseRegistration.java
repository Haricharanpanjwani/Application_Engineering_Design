/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Bean.Course;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
 * @author dishu
 */
public class CourseRegistration extends HttpServlet {

    private List<Course> courseList;
    private Set<Course> myCourses;
     
    public CourseRegistration(){
       courseList = CourseSearchServlet.getCoursesAvailable();
       //myCourses = new HashSet<Course>();
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
       // response.setContentType("text/html;charset=UTF-8");
        HttpSession session =request.getSession();
        if(null!= session.getAttribute("myCourseList"))
        {
                    myCourses = (Set<Course>) session.getAttribute("myCourseList");

        }
        else
        {
            myCourses = new HashSet<Course>();
        }
        try  {
            
            
            String actionValue=request.getParameter("action");
            if(actionValue.equalsIgnoreCase("single"))
            {
                String crn=request.getParameter("crn");
                String courseName=request.getParameter("name");
                for(Course course:courseList ){
                    if(course.getCrn().equals(crn) || course.getName().equals(courseName))
                    {
//                        if(!myCourses.contains(course))
//                        {
//                            myCourses.add(course);
//                        }
                        myCourses.add(course);
                    }else{
                        
                    }
                }
            }
            else if(actionValue.equalsIgnoreCase("multiple"))
            {
                String[] selectedCourses = request.getParameterValues("courseId");
                for(int i=0;i<selectedCourses.length;i++){
                   for(Course course:courseList ){
                    if(course.getCrn().equals(selectedCourses[i])){
//                        if(!myCourses.contains(course))
//                        {
//                            myCourses.add(course);
//                        }
                        myCourses.add(course);
                    } 
                }
            }
            
                
            
            }
            
            
            
            else if(actionValue.equalsIgnoreCase("remove"))
            {
                boolean check = false;
                String removeCourse = request.getParameter("crn");
                Iterator iterator = myCourses.iterator();
                
                while (iterator.hasNext())
                { 
                    if(check)break;
                    Course course=(Course)iterator.next();
                  if(course.getCrn().equals(removeCourse))
                  {
//                      
                    myCourses.remove(course);
                    check = true;
                    
                  }
                }
                
            }
            
            session.setAttribute("myCourseList", myCourses);
            
            response.sendRedirect("CourseView.jsp");
        }catch(Exception e){
            System.err.println("exception is"+e);
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
