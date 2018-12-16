<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
$("#btn").click(function(){
	$(this).fadeOut(500,function(){
		$(this).remove();
	});
	var text = '<form action="createStoreServlet" method="post" id="form"> <div class="form-group"> <label for="Sname">Store Name</label> <input type="text" class="form-control" id="Sname" placeholder="Store Name" name="sname"> </div> <div class="form-group"> <label for="Description">Description</label> <input type="text" class="form-control" id="Description" placeholder="Description" name="description"> </div> <div class="form-group"> <label for="Location">Location</label> <input type="text" class="form-control" id="Location" placeholder="Location" name="location"> </div> <ul> <li> <div class="form-group"> <label>Banana</label> </div> <ul> <li> <div class="form-group"> <label for="pb">Price</label> <input type="text" class="form-control" id="pb" placeholder="Banana Price" name="p_banana"> </div> </li> <li> <div class="form-group"> <label for="qb">Quantity</label> <input type="text" class="form-control" id="qb" placeholder="Banana Quality" name="q_banana"> </div> </li> </ul> </li> <li> <div class="form-group"> <label>Apple</label> </div> <ul> <li> <div class="form-group"> <label for="pa">Price</label> <input type="text" class="form-control" id="pa" placeholder="Apple Price" name="p_apple"> </div> </li> <li> <div class="form-group"> <label for="qa">Quantity</label> <input type="text" class="form-control" id="qa" placeholder="Apple Quality" name="q_apple"> </div> </li> </ul> </li> <li> <div class="form-group"> <label>Orange</label> </div> <ul> <li> <div class="form-group"> <label for="po">Price</label> <input type="text" class="form-control" id="po" placeholder="Orange Price" name="p_orange"> </div> </li> <li> <div class="form-group"> <label for="qo">Quantity</label> <input type="text" class="form-control" id="qo" placeholder="Orange Quality" name="q_orange"> </div> </li> </ul> </li> <li> <div class="form-group"> <label>Water Melon</label> </div> <ul> <li> <div class="form-group"> <label for="pw">Price</label> <input type="text" class="form-control" id="pw" placeholder="Water Melon Price" name="p_melon"> </div> </li> <li> <div class="form-group"> <label for="qw">Quantity</label> <input type="text" class="form-control" id="qw" placeholder="Water Melon Quality" name="q_melon"> </div> </li> </ul> </li> <li> <div class="form-group"> <label>Pine Apple</label> </div> <ul> <li> <div class="form-group"> <label for="ppa">Price</label> <input type="text" class="form-control" id="ppa" placeholder="Pine Apple Price" name="p_papple"> </div> </li> <li> <div class="form-group"> <label for="qpa">Quantity</label> <input type="text" class="form-control" id="qpa" placeholder="Pine Apple Quality" name="q_papple"> </div> </li> </ul> </li> <li> <div class="form-group"> <label>Mango</label> </div> <ul> <li> <div class="form-group"> <label for="pm">Price</label> <input type="text" class="form-control" id="pm" placeholder="Mango Price" name="p_mango"> </div> </li> <li> <div class="form-group"> <label for="qm">Quantity</label> <input type="text" class="form-control" id="qm" placeholder="Mango Quality" name="q_mango"> </div> </li> </ul> </li> <li> <div class="form-group"> <label>Pomegranate</label> </div> <ul> <li> <div class="form-group"> <label for="ppg">Price</label> <input type="text" class="form-control" id="ppg" placeholder="Pomegranate Price" name="p_granate"> </div> </li> <li> <div class="form-group"> <label for="qpg">Quantity</label> <input type="text" class="form-control" id="qpg" placeholder="Pomegranate Quality" name="q_granate"> </div> </li> </ul> </li> <li> <div class="form-group"> <label>Papaya</label> </div> <ul> <li> <div class="form-group"> <label for="pp">Price</label> <input type="text" class="form-control" id="pp" placeholder="Papaya Price" name="p_papaya"> </div> </li> <li> <div class="form-group"> <label for="qp">Quantity</label> <input type="text" class="form-control" id="qp" placeholder="Papaya Quality" name="q_papaya"> </div> </li> </ul> </li> <li> <div class="form-group"> <label>Guava</label> </div> <ul> <li> <div class="form-group"> <label for="pg">Price</label> <input type="text" class="form-control" id="pg" placeholder="Guava Price" name="p_guava"> </div> </li> <li> <div class="form-group"> <label for="qg">Quantity</label> <input type="text" class="form-control" id="qg" placeholder="Guava Quality" name="q_guava"> </div> </li> </ul> </li> </ul> <br><input type="submit" class="btn btn-primary btn-lg" value="Submit" style="margin-left:150px; width:200px"></form><br><form id="form" action="createStore.jsp"><input type="submit" class="btn btn-primary btn-lg" value="Cancel" style="margin-left:150px; width:200px"></form>';
	$("#enter").append(text);
});
$('#cancel').click(function() {
    window.location.href="/createStore.jsp";
});
});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>create store</title>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">OnlineStore</a>
    </div>
    <ul class="nav navbar-nav navbar-right">
      <li ><a href="createStore.jsp">Home</a></li>
      <li><a href="killSession">logout</a></li>
      <li><a href="#"><%= session.getAttribute("name") %></a></li>
    </ul>
  </div>
</nav>
<div id="container">
<h1 id="h1">Welcome <%= (String)session.getAttribute("name")%></h1><br>
<button id="btn" class="btn btn-primary btn-lg" style="margin-left : 120px;">Create Store</button>
<div id="enter"></div>
</div>
</body>
</html>