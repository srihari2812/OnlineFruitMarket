<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>login</title>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">OnlineStore</a>
    </div>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="index.jsp">Home</a></li>
    </ul>
    </div>
</nav>
<div id="container">
<% String type = (String)session.getAttribute("type"); 
if(type.equals("retailers")){
%>
<h1 id="h1">Retailers Login</h1>
<%} 
else{%>
<h1 id="h1">Shoppers Login</h1>
<%} %>
<form action="loginServlet" method="get" id="form">
  <div class="form-group">
    <label for="emailid">Email</label>
    <input type="text" class="form-control" id="emailid" placeholder="Email" name="email">
  </div>
  <div class="form-group">
    <label for="Password1">Password</label>
    <input type="password" class="form-control" id="Password1" placeholder="Password" name="password">
  </div>
  <input type="submit" class="btn btn-primary btn-lg" value="Submit">
 </form>
<p id="msg"><%= request.getAttribute("failure")%></p>
<form action="signUp.jsp" id="form">
<input type="submit" class="btn btn-primary" value="New User?Register">
</form>
</div>
</body>
</html>
