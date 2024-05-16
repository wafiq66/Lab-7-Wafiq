/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movie.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.movie.model.MovieItem;
import java.util.List;
import java.util.LinkedList;

/**
 *
 * @author user
 */
public class AddMovieServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List errorMsgs = new LinkedList();
        
        response.setContentType("text/html;charset=UTF-8");
        try {
            String title = request.getParameter("title");
            String year = request.getParameter("year");
            String genre = request.getParameter("newGenre");
            if((genre)==null || (genre.trim().length() == 0)){
                genre = request.getParameter("genre");
            }
            
            //Form Verification
            if(title == null || title.trim().length() == 0){
                errorMsgs.add("Please enter the Movie title.");
            }
            if(year == null || year.trim().length() == 0){
                errorMsgs.add("Please enter the year of release for the Movie.");
            } else if(!year.trim().matches("\\d\\d\\d\\d")){
                errorMsgs.add("Please enter a valid year.");
            }
            if(!errorMsgs.isEmpty()){
                //to open next page and forward the value
                request.setAttribute("errorMsgs", errorMsgs);
                RequestDispatcher view = request.getRequestDispatcher("/add_movie.jsp");
                view.forward(request,response);
                return;
            }
            //Business Logic
            MovieItem item = new MovieItem(title,year,genre);
            //Generate simple response
            request.setAttribute("movieItem",item);
            //Dispatch to success view
            RequestDispatcher view = request.getRequestDispatcher("/success.jsp");
            view.forward(request, response);
    }catch(RuntimeException e){
        errorMsgs.add("An unexpedted error: "+e.getMessage());
        request.setAttribute("errorMsgs", errorMsgs);
        RequestDispatcher view = request.getRequestDispatcher("/add_movie.jsp");
        view.forward(request, response);
    }}

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
