<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>transaction</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$('#go').click(function(){
		var sdate = $("#date-input").val(); 
		var date = new Date(sdate);
		 var day = date.getDate();
		 var year = date.getFullYear();
		 var month = date.getMonth();
		//var pattern = "/^\d\d\d\d[\-][0-1][0-2][\-]([0-2]\d)|([3][0-1])$/";
		//var date = $("#date-input").val();
		 if(isNaN(day) || isNaN(month) || isNaN(year))
			 alert("enter valid date ");
		 else{
			 $.ajax({
	                type: "get",
	                url: "viewTransactions",
	                data : { "date" : sdate},
	                success: function(msg){      
	                        $('#trans').html(msg);
	                }
	            });
		 	//$('#trans').slideToggle();
		 }
		});
});
</script>
</head>
<% session.setAttribute("fail",""); %>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">OnlineStore</a>
    </div>
    <ul class="nav navbar-nav navbar-right">
      <li ><a href="retailersHome.jsp">Home</a></li>
      <li class="active"><a href="#">Transactions</a></li>
      <li><a href="killSession">logout</a></li>
      <li><a href="#"><%= session.getAttribute("name") %></a></li>
    </ul>
  </div>
</nav>
<div id="loyal">
<form action="getLoyal.jsp">
	<input type="submit" value="FindLoyal" class="btn btn-success btn-lg" >
</form>
</div>
<div id="shoppers">
<form action="allShoppers">
	<input type="submit" value="Shoppers" class="btn btn-warning btn-lg" >
</form>
</div>
<div id="container">
<h1 id="h1">Transactions</h1><br>
<div class="form-group" id="form"> 
	<label for="date-input" style="margin-left:90px;">Enter Date</label> 
	<input type="date" class="form-control" id="date-input" name="date" style="width:300px;"> 
</div>
<button id="go" class="btn btn-primary btn-lg" style="margin-left:130px;"><b>Go</b></button>
</div>
<div id="trans"></div>
</body>
</html>