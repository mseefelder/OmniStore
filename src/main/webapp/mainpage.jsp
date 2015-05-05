<%-- 
    Document   : mainpage
    Created on : May 3, 2015, 9:58:48 AM
    Author     : mseefelder
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="omniTag" uri="/WEB-INF/tlds/OmniTagLibrary.tld" %>

<omniTag:OmniHandler 
    bootStrapStyle="omni-template"
    pageHandlerName="com.mseefelder.omnistore.pageHandlers.mainPageHandler"
    >
    
    <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">OmniStore</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Produtos</a></li>
            <li><a href="#about">Meu Carrinho</a></li>
            <!--<li><a href="#contact">Contact</a></li>-->
          </ul>
          <form class="navbar-form navbar-right" method="GET" action="Controller">
            <input type="text" name="SEARCH_BOX" class="form-control" value="${SEARCH}" placeholder="Pesquisa...">
          </form>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <div class="container">

      <div class="omni-template">
        <h1>OmniStore:</h1>
        <p class="lead">Os melhores preços.<br> Os melhores produtos.<br>${EXTRA}</p>
      </div>

    </div><!-- /.container -->
  </body>
</omniTag:OmniHandler>
