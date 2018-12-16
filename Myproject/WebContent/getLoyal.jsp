<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>loyal</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$("#go").click(function(){
		var val = $(thold).val();
		 $.ajax({
             type: "get",
             url: "getLoyal",
             data : { "thold" : val},
             success: function(msg){      
                     $('#trans').html(msg);
             }
         });
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
      <li ><a href="transactions.jsp">Transactions</a></li>
      <li><a href="killSession">logout</a></li>
      <li><a href="#"><%= session.getAttribute("name") %></a></li>
    </ul>
  </div>
</nav>
<div id="container">
<h1 id="h1">Loyal Shoppers</h1>
<div class="form-group" id="form"> 
	<label for="thold" style="margin-left:120px;">Enter Threshold</label> 
	<select class="form-control" id="thold" name="thold" style="width:100px;margin-left:140px;">
	<%for(int i=1;i<=10;i++){ %>
		<option value="<%= i %>"><%= i %></option>
	<%} %>
	</select><br>
	<button id="go" class="btn btn-primary btn-lg" style="margin-left:160px;"><b>Go</b></button>
</div>
</div>
<div id="trans"></div>
</body>
</body>
</html>