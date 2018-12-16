<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>Online Store</title>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">OnlineStore</a>
    </div>
    <ul class="nav navbar-nav navbar-right">
      <li class="active"><a href="#">Home</a></li>
    </ul>
  </div>
</nav>
	<div id="container">
	<h1 id="h1">Online Store</h1><br>
	<div class="form-group">
	<form action="selectType" method="get" id="form">
	<input type="radio" name="type" value="retailers">&nbspRetailers<br>
	<input type="radio" name="type" value="shoppers">&nbspShoppers<br><br>&nbsp&nbsp
  	<input type="submit" class="btn btn-primary btn-lg" value="Go">
	</form>
	</div>
	</div>
</body>
</html>