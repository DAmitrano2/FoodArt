<%@ page language="java" import="java.util.*,model.utente.UtenteBean,model.categoria.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
// Check user credentials
UtenteBean user = (UtenteBean) request.getSession(false).getAttribute("user");
String pagina = (String) request.getAttribute("page");

boolean auth;

if (user == null)
{	
    auth = false;
}
else {
	auth = true;
}

if( pagina != null ) {
	if( (pagina.equalsIgnoreCase("login") ) && (auth) )
	{
		response.sendRedirect("./index");
	}
	else if( (pagina.equalsIgnoreCase("register") ) && (auth) )
	{
		response.sendRedirect("./index");
	}
	else if( (pagina.equalsIgnoreCase("indirizzoPage") ) && (!auth) ) {
		response.sendRedirect("./index");
	}
	else if( (pagina.equalsIgnoreCase("listaOrdini") ) && (!auth) ) {
		response.sendRedirect("./index");
	}
	else if( (pagina.equalsIgnoreCase("singoloOrdine") ) && (!auth) ) {
		response.sendRedirect("./index");
	}
	else if( (pagina.equalsIgnoreCase("infoUser") ) && (!auth) ) {
		response.sendRedirect("./index");
	}
}
else {
	response.sendRedirect("./index");
}

//Categorie
CategoriaDAOImp model = new CategoriaDAOImp();
Collection<CategoriaBean> categorie = model.doRetrieveAll();
%>
<!DOCTYPE html>
<html lang="it">
<head>
  <!-- Required meta tags -->
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <link rel="stylesheet" href="./assets/css/bootstrap.min.css">
  
  <!-- Default CSS -->
  <link rel="stylesheet" href="./assets/css/navStyle.css">
  <link rel="stylesheet" href="./assets/css/style.css">
  
  <!-- Icon CSS -->
  <link rel="stylesheet" href="./assets/css/all.css">
  
  <link rel="icon" href="./images/icon.png" type="image/icon type">
  <title>FoodArt</title>
</head>
<body>
<div class="sticky-top">
  <nav class="navbar navbar-light" style="background-color: #fcba03;">
 	<a class="navbar-brand" href="#">
   	  <img src="./images/logoLungoL.png" width="auto" height="45" class="d-inline-block align-top" alt="">
	</a>
	<div class="input-group mainNavBar">
	  <input type="text" class="form-control" placeholder="Cerca">
	  <div class="input-group-append">
	    <button class="btn btn-secondary" type="button"><i class="fa fa-search"></i></button>
	  </div>
	</div>
	<ul class="navbar-nav navbar-main-link">
	  <li class="nav-item" id="nav-search">
	    <a class="nav-link" href="#"><i class="fa fa-search"></i></a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="#"><i class="fas fa-user"></i></a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="#"><i class="fas fa-shopping-cart"></i></a>
	  </li>
    </ul>
  </nav>
  <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #ffdb75;">
 	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarMain" aria-controls="navbarMain" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
 	</button>
 	<div class="collapse align-content-center navbar-collapse" id="navbarMain">
      <ul class="navbar-nav mx-auto">
        <li class="nav-item">
          <a class="nav-link" href="#">Carne</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Pesce</a>
     	</li>
     	<li class="nav-item">
       	  <a class="nav-link" href="#">Cereali e Derivati</a>
   	  	</li>
   	  	<li class="nav-item">
       	  <a class="nav-link" href="#">Latte, Derivati e Uova</a>
   	  	</li>
   	  	<li class="nav-item">
       	  <a class="nav-link" href="#">Pasticceria</a>
   	  	</li>
   	  	<li class="nav-item">
       	  <a class="nav-link" href="#">Frutta e Verdura</a>
   	  	</li>
   	  	<li class="nav-item">
       	  <a class="nav-link" href="#">Bevande</a>
   	  	</li>
   	  	<li class="nav-item">
       	  <a class="nav-link" href="#">Conserve</a>
   	  	</li>
   	  	<li class="nav-item">
       	  <a class="nav-link" href="#">Condimenti</a>
   	  	</li>
      </ul>
    </div>
  </nav>
</div>