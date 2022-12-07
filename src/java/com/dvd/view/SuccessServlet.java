/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvd.view;

import com.dvd.model.DVDItem;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SuccessServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        DVDItem dvdItem = (DVDItem) request.getAttribute("dvdItem");
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>DVD Library Application Add DVD Success</title>");
            out.println("<body>");
            out.println("<h1>Add DVD Success</h1>");
            out.println("You have add the following DVD: <br><br> ");
            out.println("Title: "+dvdItem.getTitle()+"<br/>");
            out.println("Year released: "+dvdItem.getYear()+"<br/>");
            out.println("Genre of title: "+dvdItem.getGenre()+"<br/>");
            
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
