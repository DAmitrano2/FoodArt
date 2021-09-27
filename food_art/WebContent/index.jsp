  <%@include file="./include/header.jsp"%>
  <!-- Inizio Carosello Principale-->
  <div id="carouselMain" class="carousel slide" data-ride="carousel" data-interval="6000">
	<ol class="carousel-indicators">
	  <li data-target="#carouselMain" data-slide-to="0" class="active"></li>
	  <li data-target="#carouselMain" data-slide-to="1"></li>
	  <li data-target="#carouselMain" data-slide-to="2"></li>
	</ol>
	<div class="carousel-inner">
	  <div class="carousel-item active">
	    <img class="d-block w-100" src="./assets/images/slider1.jpg" alt="Prima slide">
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
	    <img class="d-block w-100" src="./assets/images/cannavacciuolo.jpg" alt="Seconda slide">
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
	    <img class="d-block w-100" src="./assets/images/slider3.jpg" alt="Terza slide">
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
  <!-- Fine Carosello Principale-->

  <!-- Inizio Carosello Categorie-->
  <section id="categoryCarousel" data-ride="carouselCat">
	  <div class="category">
		  <div class="category-container">
			<div class="owl-carousel owl-theme category-card">
				<div class="category-content">
					<div class="image-container">
					<img src="./images/category/C1_Carne.jpg" alt="CT1">
					</div>
					<div class="category-title">
						<h3>CARNE</h3>
						<button class="btn btn-category">Visualizza prodotti</button>
						<span></span>
					</div>
				</div>
				<div class="category-content">
					<div class="image-container">
					<img src="./images/category/C2_Pesce.jpeg" alt="CT2">
					</div>
					<div class="category-title">
						<h3>PESCE</h3>
						<button class="btn btn-category">Visualizza prodotti</button>
						<span></span>
					</div>
				</div>
				<div class="category-content">
					<div class="image-container">
					<img src="./images/category/C3_Cereali.jpg" alt="CT3">
					</div>
					<div class="category-title">
						<h3>CEREALI E DERIVATI</h3>
						<button class="btn btn-category">Visualizza prodotti</button>
						<span></span>
					</div>
				</div>
				<div class="category-content">
					<div class="image-container">
					<img src="./images/category/C4_LatteDerivatiUova.jpg" alt="CT4">
					</div>
					<div class="category-title">
						<h3 id="latte">LATTE, DERIVATI E UOVA</h3>
						<button class="btn btn-category">Visualizza prodotti</button>
						<span></span>
					</div>
				</div>
				<div class="category-content">
					<div class="image-container">
					<img src="./images/category/C5_Pasticceria.jpg" alt="CT5">
					</div>
					<div class="category-title">
						<h3>PASTICCERIA</h3>
						<button class="btn btn-category">Visualizza prodotti</button>
						<span></span>
					</div>
				</div>
				<div class="category-content">
					<div class="image-container">
					<img src="./images/category/C6_FruttaVerdura.jpg" alt="CT6">
					</div>
					<div class="category-title">
						<h3>FRUTTA E VERDURA</h3>
						<button class="btn btn-category">Visualizza prodotti</button>
						<span></span>
					</div>
				</div>
				<div class="category-content">
					<div class="image-container">
					<img src="./images/category/C7_Bevande.jpg" alt="CT7">
					</div>
					<div class="category-title">
						<h3>BEVANDE</h3>
						<button class="btn btn-category">Visualizza prodotti</button>
						<span></span>
					</div>
				</div>
				<div class="category-content">
					<div class="image-container">
					<img src="./images/category/C8_Conserve.jpg" alt="CT8">
					</div>
					<div class="category-title">
						<h3>CONSERVE</h3>
						<button class="btn btn-category">Visualizza prodotti</button>
						<span></span>
					</div>
				</div>
				<div class="category-content">
					<div class="image-container">
					<img src="./images/category/C9_Condimenti.jpeg" alt="CT9">
					</div>
					<div class="category-title">
						<h3>CONDIMENTI</h3>
						<button class="btn btn-category">Visualizza prodotti</button>
						<span></span>
					</div>
				</div>
			</div>
		  </div>
		 </div>
	  
  </section>
  <!-- In Primo Piano -->
  <div class="small-container justify-content-center">
	<h2 class="title">Prodotti In Primo Piano</h2>
	<div class="row">
		<div class="col-4 text-center">
			<img src="images/primo-piano-1.jpg" alt="">
			<h4>Confettura Albicocche</h4>
			<span>SOCIET&#192; AGRICOLA AMITRANO</span>
			<div class="rating">
				<i class="fas fa-star"></i>
				<i class="fas fa-star"></i>
				<i class="fas fa-star"></i>
				<i class="fas fa-star"></i>
				<i class="far fa-star"></i>
			</div>
			<p>&#8364; 6.00, pz</p>
			<button type="button" class="btn bg-cart"><i class="fas fa-cart-plus mr-2"></i>Aggiungi al Carrello</button>
		</div>
		<div class="col-4 text-center">
			<img src="images/primo-piano-2.jpg" alt="">
			<h4>Salame Toscano</h4>
			<span>SALUMERIA GROSSETANA</span>
			<div class="rating">
				<i class="fas fa-star"></i>
				<i class="fas fa-star"></i>
				<i class="fas fa-star"></i>
				<i class="fas fa-star"></i>
				<i class="far fa-star"></i>
			</div>
			<p>&#8364; 11.50, pz</p>
			<button type="button" class="btn bg-cart"><i class="fas fa-cart-plus mr-2"></i>Aggiungi al Carrello</button>
		</div>
		<div class="col-4 text-center">
			<img src="images/primo-piano-3.jpg" alt="">
			<h4>Pere Santa Maria</h4>
			<span>FRUTTETO ZAPPIA</span>
			<div class="rating">
				<i class="fas fa-star"></i>
				<i class="fas fa-star"></i>
				<i class="fas fa-star"></i>
				<i class="fas fa-star-half-alt"></i>
				<i class="far fa-star"></i>
			</div>
			<p>&#8364; 1.25, kg</p>
			<button type="button" class="btn bg-cart"><i class="fas fa-cart-plus mr-2"></i>Aggiungi al Carrello</button>
		</div>
		<div class="col-4 text-center">
			<img src="images/primo-piano-4.jpg" alt="">
			<h4>Birra Artigianale 0,3l</h4>
			<span>BIRRIFICIO MIRANDA</span>
			<div class="rating">
				<i class="fas fa-star"></i>
				<i class="fas fa-star"></i>
				<i class="fas fa-star"></i>
				<i class="fas fa-star"></i>
				<i class="fas fa-star-half-alt"></i>
			</div>
			<p>&#8364; 9.20</p>
			<button type="button" class="btn bg-cart"><i class="fas fa-cart-plus mr-2"></i>Aggiungi al Carrello</button>
		</div>
	</div>
	<!-- Ultimi Arrivi -->
	<%
		ProdottoDAOImp modelProdotto = new ProdottoDAOImp(); 
		RivenditoreDAOImp modelRivenditore = new RivenditoreDAOImp();
		Collection<ProdottoBean> prodotti = modelProdotto.getLastArrivals();
	%>
	<h2 class="title">Ultimi Arrivi</h2>
		<div class="row">
			<%
				if (prodotti != null && prodotti.size() != 0) {
					for(ProdottoBean product: prodotti) {
			%>
				<div class="col-4 text-center">
					<img src="./getImage?idProdotto=<%= product.getIdProdotto() %>" alt="imageProduct.png">
					<h4><%= product.getTitolo() %></h4>
					<span><%= modelRivenditore.doRetriveNameById(product.getIdUtente()) %></span>
					<div class="rating">
						<i class="fas fa-star"></i>
						<i class="fas fa-star"></i>
						<i class="fas fa-star"></i>
						<i class="fas fa-star"></i>
						<i class="far fa-star"></i>
					</div>
					<p><%= product.getPrezzo()%>&#8364; al <%= product.getUnitaMisura()%></p>
					<button type="button" class="btn bg-cart"><i class="fas fa-cart-plus mr-2"></i>Aggiungi al Carrello</button>
				</div>
				<%}}%>
			</div>
  </div>
  
  <!--Footer-->
  <section id="footer">
	  <div class="container">
		  <div class="row text-center text-xs-center text-sm-left text-md-left">
			  <div class="col-xs-12 col-sm-4 col-md-4">
					<h5>  Informazioni</h5>
					<ul class="list-unstyled quick-links">
						<li><a href="#"></a>Chi siamo?</li>
						<li><a href="#"></a>Come selezioniamo?</li>
						<li><a href="#"></a>Come vendere su FoodArt?</li>
						<li><a href="#"></a>Termini e Condizioni</li>
						<li><a href="#"></a>Privacy e Cookie</li>
					</ul>
				</div>
				<div class="col-xs-12 col-sm-4 col-md-4">
					<h5>  Contatti</h5>
					<ul class="list-unstyled quick-links">
						<li><a href="#"></a><i class="fas fa-map-marker-alt"></i> Via Filettine, 194, Pagani, Salerno</li>
						<li><a href="#"></a><i class="fas fa-envelope"></i> support@foodart.com</li>
					</ul>
				</div>
				<div class="col-xs-12 col-sm-4 col-md-4">
				  <h5>  Supporto</h5>
				  <ul class="list-unstyled quick-links">
					  <li><a href="#"></a>Consegne</li>
					  <li><a href="#"></a>Resi</li>
					  <li><a href="#"></a>FAQ</li>
				  </ul>
			  </div>
		  </div>
		  <div id="social" class="row">
			  <div class="col-xs-12 col-sm-12 col-md-12 mt-2 mt-sm-5">
				<ul>
					<li><a href="#"><i class="fab fa-facebook"></i></a></li>
					<li><a href="#"><i class="fab fa-twitter"></i></a></li>
					<li><a href="#"><i class="fab fa-instagram"></i></a></li>
				</ul>
			  </div>
			  <hr>
		  </div>
		</div>
		<div class="sub-footer">
			<div class="col-xs-12 col-sm-12 col-md-12 mt-2 mt-sm-2 text-center text-white">
				<p class="h6"><i class="far fa-copyright"></i> Tutti i diritti Riservati <a class="text-green ml-2" href="#" target="_blank">| FoodArt&#153;</a></p>
			</div>
		</div>
  </section>

  <%@include file="./include/footer.html" %>
  <%@include file="./include/script.html" %>
</body>
</html>