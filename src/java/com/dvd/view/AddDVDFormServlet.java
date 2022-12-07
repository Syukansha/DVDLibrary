/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvd.view;


import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddDVDFormServlet extends HttpServlet {
    
    private String genres = null;
 
    public void init()throws ServletException{
       
         genres = "Sci-fi,drama,comedy";
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
     
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String[] arrOfStr = genres.split(","); 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddDVDFormServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form method='post' action='Add_dvd.do'>");
            out.println("<h1>Add DVD</h1>");
            
            out.println("Title:<input type='text' name='title'");
            String title = request.getParameter("title");
            if(title == null) {
                title = "";
            }
            out.println("value = '" + title + "' /> <br/><br/>");
            String year = request.getParameter("year");
            // Display the title field
            out.println(" Year: <input type='text' name='year' ");
            if(year == null) {
               year = "";
            }
            out.println("value = '" + year + "' /> <br/><br/>");
            
            String genre = request.getParameter("genre");
            // Repopulate the Genre drop-down menu
             out.println(" Genre: <select name='genre'>");
             for ( int i = 0; i < arrOfStr.length; i++ ) {
             out.print(" <option value='" + arrOfStr[i] + "'");
             if(genre != null && genre.equals(arrOfStr[i])) {
             out.print(" SELECTED");
             }
             out.println("> " + arrOfStr[i] + "</option>");
             }
             out.println(" </select>");
             String newGenre = request.getParameter("newGenre");
             out.print(" or new genre: <input type='text' name='newGenre' ");
             if(newGenre == null) {
                newGenre = "";
             }
             out.println("value = '" + newGenre + "'/> <br/><br/>");
            
            /*out.println("Genre:<select name='genre'>\"\n" 
                    + "<option value="+arrOfStr[0]+">"+arrOfStr[0]+"</option>" 
                   + "<option value="+arrOfStr[1]+">"+arrOfStr[1]+"</option>\"\n" 
                    + "<option value="+arrOfStr[2]+">"+arrOfStr[2]+"</option></select>\n" 
                    + " or new genre: <input type='text' name='newgenre'/><br><br>");*/

            out.println("<input type='submit' value='Submit'/>");
            out.println("</form>");
             out.println("<h2>Error Report</h2>");
            out.println("<font color='red'>Please correct the following errors:");
            out.println("<ul>");
            List errorMsgs = (List) request.getAttribute("errorMsgs");
            Iterator items = errorMsgs.iterator();
            while(items.hasNext()){
                String message = (String) items.next();
                out.println(" <li>"+message+"</li>");
            }
            out.println("</ul>");
            out.println("Back up and try again.");
            
            
            
                
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
