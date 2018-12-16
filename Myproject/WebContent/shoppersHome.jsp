<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>shoppersHome</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        $('#btn1').click(function (){	
            $.ajax({
                type: "get",
                url: "getRetailers",
                success: function(msg){      
                        $('#cont4').html(msg);
                }
            });
            $('#cont4').slideToggle();
        });
        $('#btn2').click(function (){	
            $.ajax({
                type: "get",
                url: "getWallet",
                success: function(msg){      
                        $('#wallet').html(msg);
                }
            });
            $('#cont2').slideToggle();
        });
    });
</script>
</head>
<% session.setAttribute("f1","");session.setAttribute("q1","");
session.setAttribute("f2","");session.setAttribute("q2","");
session.setAttribute("f3","");session.setAttribute("q3","");
session.setAttribute("finalprice","");
session.setAttribute("remail","");session.setAttribute("rname","");
%>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">OnlineStore</a>
    </div>
    <ul class="nav navbar-nav navbar-right">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="killSession">logout</a></li>
      <li><a href="#"><%= session.getAttribute("name") %></a></li>
    </ul>
  </div>
</nav>
<div id="container">
<h1 id="h2">Shoppers Home</h1><br>
<button id="btn1" class="btn btn-primary btn-lg" style="margin-left:60px"><b>View Retailers</b></button>
<button id="btn2" class="btn btn-success btn-lg"><b>Wallet</b></button>
</div>
<div id="wrap">
<div id="cont4"></div>
<div id="cont2"><p id="wallet"></p></div>
</div>
</body>
</html>