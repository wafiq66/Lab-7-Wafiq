/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movie.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author user
 */
public class AddMovieFormServlet extends HttpServlet {

    private String[] genres = null;
    @Override
    public void init() 
            throws ServletException{
        String genreList = getServletConfig().getInitParameter("genre-list");
        if (genreList != null) {
            // Split the string by commas and assign it to the genres field
            
            genres = genreList.split(",");
        }
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
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        List errorMsgs = (List) request.getAttribute("errorMsgs");
        //get the previous input so the user no need to retype
        String title = request.getParameter("title");
        String year = request.getParameter("year");
        String genre = request.getParameter("genre");
        String newGenre = request.getParameter("newGenre");
        
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("<title>Movie Library Application: Add Movie Form</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Add Movie</h1>");
        //Form for the html
        out.println("<form action=\"add_movie.do\" method=\"post\">");
        out.println("<a href=\"add_movie.html\"></a>");
        
        //title
        out.println("Title: <input type=\"text\" name=\"title\"");
        if(title == null){
            title = "";
        }
        out.println(" value=\""+title+"\"> <br> <br>");
        
        //year
        out.println("Year: <input type=\"text\" name=\"year\"");
        if(year == null){
            year = "";
        }
        out.println(" value=\""+year+"\"> <br> <br>");
        
        //genre drop down
        out.println("Genre: <select name=\"genre\"> ");
        // Add genre options dynamically from the genres array
        if (genres != null) {
            for (String u : genres) {
                out.println("<option value=\"" + u + "\" ");
                if(u.equals(genre)){
                    out.println("SELECTED ");
                }
                out.println(">" + u + "</option>");
            }
        } else {
            // Default genres if the genres array is null
            out.println("<option value=\"Sci-Fi\">Sci-Fi</option>");
            out.println("<option value=\"Action\">Action</option>");
            out.println("<option value=\"Comedy\">Comedy</option>");
        }

        out.println("</select>");
        
        //new genre
        out.println("or new genre: <input type=\"text\" name=\"newGenre\" ");
        if(newGenre == null){
            newGenre = "";
        }
        out.println(" value=\""+newGenre+"\"> <br> <br>");
        
        out.println("<input type=\"submit\">");
        
        out.println("</form>");
        //Error Section List
        out.println("<h2> Error Report</h2>");
        out.println("<font color='red'>Please correct the following errors: ");
        out.println("<ul>");
        Iterator items = errorMsgs.iterator();
        while(items.hasNext()){
                String message = (String) items.next();
                out.println("<li>"+message+"</li>");
        }
        out.println("</ul>");
        out.println("Back up and try again");
        out.println("</font>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
    
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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    

