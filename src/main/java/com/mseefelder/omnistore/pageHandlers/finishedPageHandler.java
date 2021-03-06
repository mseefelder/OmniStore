/*
 * Handles concluido.jsp.
 */
package com.mseefelder.omnistore.pageHandlers;

import com.mseefelder.omnistore.controller.pageHandlerInterface;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mseefelder
 */
public class finishedPageHandler implements pageHandlerInterface 
{

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String jspURL = null;
        
        String buyRequest = request.getParameter("bought");
        String categoryText = request.getParameter("category");
        if(buyRequest != null && !buyRequest.isEmpty())
        {
            jspURL = "concluido.jsp";
        }
        else if(categoryText=="none")
        {
            jspURL = "vitrine.jsp";
        }
        else if(categoryText != null && !categoryText.isEmpty())
        {
            jspURL = "vitrine.jsp";
            request.setAttribute("EXTRA", categoryText);
        }
        else
        {
            jspURL = "vitrine.jsp";
        }
        
        return jspURL;
    }
    
}
