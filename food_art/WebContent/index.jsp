  <%@include file="./include/header.jsp"%>
  <!-- Carosello Principale-->
  <div id="carouselMain" class="carousel slide" data-ride="carousel" data-interval="6000">
	<ol class="carousel-indicators">
	  <li data-target="#carouselMain" data-slide-to="0" class="active"></li>
	  <li data-target="#carouselMain" data-slide-to="1"></li>
	  <li data-target="#carouselMain" data-slide-to="2"></li>
	</ol>
	<div class="carousel-inner">
	  <div class="carousel-item active">
	    <img class="d-block w-100" src="./images/slider1.jpg" alt="Prima slide">
	    <div class="carousel-caption">
		  <div class="container">
			<div class="row justify-content-end">
			  <div class="d-none d-md-block col-md-11 col-lg-9 col-xl-8 bg-dark text-right">
	   	  		<h3 class="pb-3">3&#176; Festival Fruttariano Italiano</h3>
	   	  		<div class="border-top border-white mb-3 w-75 ml-auto"></div>
	   	  		<p class="lead">Per la prima volta, Foodart permette di avere l'esclusiva per l'acquisto dei prodotti ecosostenibili preparati al Festival!</p>
	   	  		<a href="#" class="btn btn-primary btn-md">Leggi di Pi&#249;!</a>
  		      </div>
	        </div>
	 	  </div>
	 	</div>
	  </div>
	  <div class="carousel-item">
	    <img class="d-block w-100" src="./images/cannavacciuolo.jpg" alt="Seconda slide">
	    <div class="carousel-caption">
		  <div class="container">
			<div class="row justify-content-end">
			  <div class="d-none d-md-block col-md-11 col-lg-9 col-xl-8 bg-dark text-right">
	   	  		<h3 class="pb-3">In cucina vince la fantasia</h3>
	   	  		<div class="border-top border-white mb-3 w-75 ml-auto"></div>
	   	  		<p class="lead">Leggi un estratto dell'intervista esclusiva di chef Antonino Cannavacciuolo a FoodArt!</p>
	   	  		<a href="#" class="btn btn-primary btn-md">Leggi di Pi&#249;!</a>
   	  		  </div>
  		    </div>
	      </div>
	 	</div>
	  </div>
	  <div class="carousel-item">
	    <img class="d-block w-100" src="./images/slider3.jpg" alt="Terza slide">
	    <div class="carousel-caption">
		  <div class="container">
			<div class="row justify-content-end">
			  <div class="d-none d-md-block col-md-11 col-lg-9 col-xl-8 bg-dark text-right">
	   	  		<h3 class="pb-3">Festival del Formaggio di Campo Tures</h3>
	   	  		<div class="border-top border-white mb-3 w-75 ml-auto"></div>
	   	  		<p class="lead">Acquista da noi i migliori formaggi dell'Alto Adige!</p>
	   	  		<a href="#" class="btn btn-primary btn-md">Leggi di Pi&#249;!</a>
	   	  	  </div>
  		    </div>
	      </div>
	 	</div>
	  </div>
	</div>
	<a class="carousel-control-prev" href="#carouselMain" role="button" data-slide="prev" onclick="$('#carousel').carousel('prev')">
	  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	  <span class="sr-only">Precedente</span>
	</a>
	<a class="carousel-control-next" href="#carouselMain" role="button" data-slide="next" onclick="$('#carousel').carousel('next')">
	  <span class="carousel-control-next-icon" aria-hidden="true"></span>
	  <span class="sr-only">Successivo</span>
	</a>
  </div>

  <%@include file="./include/footer.html" %>
  <%@include file="./include/script.html" %>
</body>
</html>