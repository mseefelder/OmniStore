<%-- 
    Document   : vitrine
    Created on : May 4, 2015, 9:54:20 PM
    Author     : mseefelder
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="omniTag" uri="/WEB-INF/tlds/OmniTagLibrary.tld" %>

<omniTag:OmniHandler
    pageHandlerName="com.mseefelder.omnistore.pageHandlers.productPageHandler"
    pageName="Produto:"> 
    
    <body>
        <omniTag:productTagHandler>${EXTRA}</omniTag:productTagHandler>
    </body>
    
</omniTag:OmniHandler>