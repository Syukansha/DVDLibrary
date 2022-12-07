/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvd.controller;

import com.dvd.model.DVDItem;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;
import java.util.Iterator;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author NewUser
 */
public class AddDvdServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
   
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
         response.setContentType("text/html");
        PrintWriter out = response.getWriter();
       List errorMsgs = new LinkedList();
        try{
            
            String title = request.getParameter("title");
            String year = request.getParameter("year");
            String genre = request.getParameter("newGenre");
            
            if((genre == null)|| (genre.trim().length()==0)){
                genre = request.getParameter("genre");
            }
              
            DVDItem item = new DVDItem(title,year,genre);
            if(title == null || (title.trim().length()==0)){
                errorMsgs.add("Please enter the DVD title.");
            }
            if(year == null || (year.trim().length()==0)){
                errorMsgs.add("Please enter the year of release for the DVD.");
            }
            else if( !year.trim().matches("\\d\\d\\d\\d")){
                errorMsgs.add("Please enter a valid year.");
            }
            if(!errorMsgs.isEmpty()){
                request.setAttribute("errorMsgs", errorMsgs);
                RequestDispatcher view = request.getRequestDispatcher("/AddDVDFormServlet");
                view.forward(request,response);
                return;
            }

            /*out.println("SUCCESS: added DVD title '"+item.getTitle()+"' "+item.getGenre());*/
            request.setAttribute("dvdItem",item);
            RequestDispatcher view = request.getRequestDispatcher("/success.view");
            view.forward(request, response);
            return;
              
        }
        catch(RuntimeException e){
            /*out.println("ERROR: "+e.getMessage());
            out.close();*/
            errorMsgs.add("An unexpected error: "+e.getMessage());
            request.setAttribute("errorMsgs",errorMsgs);
            RequestDispatcher view = request.getRequestDispatcher("/AddDVDFormServlet");
            view.forward(request, response);
             
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
