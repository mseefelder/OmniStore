<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Produto</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/dashboard.css" rel="stylesheet">
    </head>
 
    
    <body>
      <form method="GET" action="Controller">
          <input type="hidden" name="pageHandlerName" value="com.mseefelder.omnistore.pageHandlers.productPageHandler">
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
        <div class="col-md-2 col-xs-3 col-sm-4 sidebar sidebar">
            <button type="submit" class="btn btn-default" name="botao" value="valor" style="width:100%;">Left</button>
            <button type="submit" class="btn btn-default" name="botao" value="valor" style="width:100%;">Left</button>
            <button type="submit" class="btn btn-default" name="botao" value="valor" style="width:100%;">Left</button>
        </div>
          
        <div class="col-md-10 col-md-offset-2 col-xs-9 col-xs-offset-3 col-sm-8 col-sm-offset-4 container-fluid main">
          <h1 class="page-header">Produto: </h1>
          
          <div class="col-md-4 col-xs-4 col-sm-3">
            <img src="pics/apple.jpg" class="img-responsive">
          </div>
          <div class="col-md-6 col-xs-5 col-sm-5">
            <p></p>
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
