package com.movie.view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import com.movie.model.MovieItem;

/**
 *
 * @author user
 */
public class ListLibraryServlet extends HttpServlet {
    
    
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
        
        List movies=new ArrayList();
            movies.add(new MovieItem("Spiderman","2022","Action"));
            movies.add(new MovieItem("Barbie","2023","Comedy"));
            movies.add(new MovieItem("Conjuring","2023","Horror"));
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>ListLibraryServlet</title>");            
            out.println("</head>");
            out.println("<body style=\"background-color:pink\">");
            out.println("<h3>You currently have <b>"+movies.size()+"</b> in your collection</h3>");
            out.println("<table>");
            
            out.println("<tr>");
            out.println("   <th>Movie Name</th>");
            out.println("   <th>Year</th>");
            out.println("   <th>Genre</th>");
            out.println("</tr>");
            
            Iterator it = movies.iterator();
            while(it.hasNext()){
                MovieItem item = (MovieItem) it.next();
                out.println("<tr>");
                out.println("   <td>"+item.getTitle()+"</td>");
                out.println("   <td>"+item.getYear()+"</td>");
                out.println("   <td>"+item.getYear()+"</td>");
                out.println("</tr>");
            }
            out.println("</table>");
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
