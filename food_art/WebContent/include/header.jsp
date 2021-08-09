<%@ page language="java" import="java.util.*,model.utente.*,model.rivenditore.*,model.categoria.*,model.prodotto.*,model.immagine.*,java.sql.Date" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// Check user credentials
	UtenteBean user = (UtenteBean) request.getSession(false).getAttribute("user");
	String pagina = (String) request.getAttribute("page");
	String path = request.getContextPath();
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
		//response.sendRedirect("./index");
	}
	
	//Categorie
	CategoriaDAOImp modelCategoria = new CategoriaDAOImp();
	Collection<CategoriaBean> categorie = modelCategoria.doRetrieveAll();
%>
<!DOCTYPE html>
<html lang="it">
<head>
  <!-- Required meta tags -->
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Owl Carousel CDN-->
  <link rel="stylesheet" href="./assets/css/owl.carousel.min.css">
  <link rel="stylesheet" href="./assets/css/owl.theme.default.min.css">
    
  <!-- Bootstrap CSS CDN-->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
  
  <!-- Default CSS -->
  <link rel="stylesheet" href="./assets/css/header_style.css">
  <link rel="stylesheet" href="./assets/css/card_style.css">
  <% if(pagina != null && pagina.equalsIgnoreCase("register")) { %>
	  <link rel="stylesheet" href="./assets/css/login_style.css">
	  <link rel="stylesheet" href="./assets/css/<%=pagina %>_style.css">
  <% }else{ %>
  	  <link rel="stylesheet" href="./assets/css/<%=pagina %>_style.css">
  <% } %>
  <!-- Icon CSS -->
  <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"/>
  <link rel="stylesheet" href="./assets/css/all.css">
  <script src="https://kit.fontawesome.com/2a789f15df.js"></script>
  
  <link rel="icon" href="./images/icon.png" type="image/icon type">
  <title>FoodArt</title>
</head>
<body>
<div class="sticky-top">
  <nav class="navbar navbar-light" style="background-color:  #fcba03;">
 	<a class="navbar-brand" href="<%=path%>/index">
   	  <img src="./images/logoLungoL.png" width="auto" height="45" class="d-inline-block align-top" alt="">
	</a>
	<div class="input-group mainNavBar">
	  <input type="text" class="form-control">
	  <div class="input-group-append">
	    <button class="btn btn-secondary" type="button"><i class="fa fa-search"></i></button>
	  </div>
	</div>
	<ul class="navbar-nav navbar-main-link">
	  <li class="nav-item" id="nav-search">
	    <a class="nav-link" href="#"><i class="fa fa-search"></i></a>
	  </li>
	  <li class="nav-item dropdown">
	    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fas fa-user"></i></a>
	  	<div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="<%=path %>/login">Login</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="<%=path %>/register">Sei nuovo? Registrati</a>
        </div>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" href="<%=path %>/cart"><i class="fas fa-shopping-cart"></i></a>
	  </li>
    </ul>
  </nav>
  <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #ffdd00;">
 	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarMain" aria-controls="navbarMain" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
 	</button>
 	<div class="collapse align-content-center navbar-collapse" id="navbarMain">
      <ul class="navbar-nav mx-auto">
      <%
			if (categorie != null && categorie.size() != 0) {
				for (CategoriaBean category: categorie) {
			%>
        <li class="nav-item">
          <a class="nav-link" href="categoria?idCategoria=<%=category.getIdCategoria()%>"><%=category.getNome()%></a>
        </li>
        <%}} %>
      </ul>
    </div>
  </nav>
</div>