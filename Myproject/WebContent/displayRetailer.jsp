<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>dispRetailer</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
<script type="text/javascript" src="js/jscript.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">OnlineStore</a>
    </div>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="shoppersHome.jsp">Home</a></li>
      <li><a href="killSession">logout</a></li>
      <li><a href="#"><%= session.getAttribute("name") %></a></li>
    </ul>
  </div>
</nav>
<div id="container">
<h1 id="h1"><%=session.getAttribute("rname") %></h1>
<form action="makeTransaction" method="get" id="form">
<div style="width:500px;margin:50px auto;float:left;color:white;font-weight:bold;"><%= request.getAttribute("ans") %></div>
</div>
<div style="width:300px;margin:0px auto 50px;float:right;color:white;font-weight:bold;padding-right:150px;">
<div class="form-group">
    <label for="price">Price ($)</label>
    <input type="text" class="form-control" id="price" name="price" readonly="readonly" value="0">
</div>
<div class="form-group">
    <label for="combo">Combo</label>
    <input type="text" class="form-control" id="combo" name="combo" readonly="readonly" value="0">
</div>
<input type="submit" class="btn btn-primary btn-lg" value="Submit" id="submit" disabled="disabled">
</form>
</div>
</body>
</html>