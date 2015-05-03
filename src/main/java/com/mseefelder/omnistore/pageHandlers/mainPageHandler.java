/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mseefelder.omnistore.pageHandlers;

import com.mseefelder.omnistore.controller.pageHandlerInterface;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mseefelder
 */
public class mainPageHandler implements pageHandlerInterface 
{

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String jspURL = null;
        
        String searchText = request.getParameter("SEARCH_BOX");
        if(searchText != null || !searchText.isEmpty())
        {
            jspURL = "mainpage.jsp";
            request.setAttribute("EXTRA", searchText);
        }
        else
        {
            jspURL = "mainpage.jsp";
        }
        return jspURL;
    }
    
}
