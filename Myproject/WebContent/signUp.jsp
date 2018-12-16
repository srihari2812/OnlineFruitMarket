<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>Sign Up</title>
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
<% request.setAttribute("failure2","");%>
<div id="container">
<h1 id="h1">SignUp</h1><br>
<form action="signUpServlet" method="post" id="form">
  <div class="form-group">
    <label for="emailid">Email</label>
    <input type="text" class="form-control" id="emailid" placeholder="Email" name="email">
  </div>
  <div class="form-group">
    <label for="Password">Password</label>
    <input type="password" class="form-control" id="Password" placeholder="Password" name="password">
  </div>
  <div class="form-group">
    <label for="Fname">First Name</label>
    <input type="text" class="form-control" id="Fname" placeholder="First Name" name="fname">
  </div>
  <div class="form-group">
    <label for="Lname">Last Name</label>
    <input type="text" class="form-control" id="Lname" placeholder="Last Name" name="lname">
  </div>
  <div class="form-group">
    <label for="Address">Address</label>
    <input type="text" class="form-control" id="Address" placeholder="Address" name="address">
  </div>
  <div class="form-group">
    <label for="Pan">PAN</label>
    <input type="text" class="form-control" id="Pan" placeholder="PAN" name="pan">
  </div>
  <div class="form-group">
    <label for="Wallet">Wallet</label>
    <input type="text" class="form-control" id="Wallet" placeholder="Wallet" name="wallet">
  </div>
  <input type="submit" class="btn btn-primary btn-lg" value="Submit">
 </form>
 <p id="msg"><%= request.getAttribute("failure2")%></p>
</div>
</body>
</html>