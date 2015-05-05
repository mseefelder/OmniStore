<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Vitrine da loja</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/dashboard.css" rel="stylesheet">
    </head>
 
    
    <body>
      <form method="GET" action="Controller">
          <input type="hidden" name="pageHandlerName" value="com.mseefelder.omnistore.pageHandlers.mainPageHandler">
    <nav class="navbar navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">${EXTRA}</a>
        </div>
      </div>
    </nav>
        
    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
        <!--
        <div class="col-sm-3 col-md-2 btn-group-vertical" role="group" aria-label="...">
            <button type="submit" class="btn btn-default" name="botao" value="valor">Left</button>
            <button type="button" class="btn btn-default">Middle</button>
            <button type="button" class="btn btn-default">Right</button>
        </div>
        -->
        <!--
          <ul class="nav nav-sidebar">
            
            <li class="active"><a href="#">Categories <span class="sr-only">(current)</span></a></li>
            <li><a href="#" >Liquid</a></li>
            <li><a href="#">Solid</a></li>
            <li><input type="button" value="Foobar" /></li>
          </ul>
        -->
            <button type="submit" class="btn btn-default" name="botao" value="valor" style="width:100%;">Left</button>
            <button type="submit" class="btn btn-default" name="botao" value="valor" style="width:100%;">Left</button>
            <button type="submit" class="btn btn-default" name="botao" value="valor" style="width:100%;">Left</button>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Vitrine</h1>
          <div class="row placeholders">
            
              <!--
            <div class="col-xs-6 col-sm-3 placeholder">
              <img data-src="" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Label</h4>
              <span class="text-muted">Something else</span>
            </div>
              -->
            <div class="col-md-4 placeholder">
                <input type="image" src="pics/coin.png" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Coin</h4>
              <span class="text-muted">1GOLD</span>
            </div>
            
          </div>
          
        </div>

    </div>
    </div>
    </form>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="js/ie10-viewport-bug-workaround.js"></script>
  </body>
    

</html>
