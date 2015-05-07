/*
 * Handles vitrine.jsp.
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
        
        String categoryText = request.getParameter("category");
        String productText = request.getParameter("product");
        if(productText != null && !productText.isEmpty())
        {
            jspURL = "produto.jsp";
            request.setAttribute("EXTRA", productText);
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
