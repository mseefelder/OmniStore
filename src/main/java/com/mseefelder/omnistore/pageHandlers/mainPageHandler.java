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
        
        
        String categoryText = request.getParameter("category");
        String productText = request.getParameter("product");
        if(categoryText != null && !categoryText.isEmpty())
        {
            jspURL = "vitrine.jsp";
            request.setAttribute("EXTRA", categoryText);
        }
        else if(productText != null && !productText.isEmpty())
        {
            jspURL = "produto.jsp";
            request.setAttribute("EXTRA", productText);
        }
        else
        {
            jspURL = "vitrine.jsp";
        }
        
        return jspURL;
    }
    
}
