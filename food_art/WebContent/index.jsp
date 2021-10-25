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
	    <img class="d-block w-100" src="./assets/images/slider1.png" alt="Prima slide">
	    <div class="carousel-caption">
			  <div class="container">
					<div class="row justify-content-end">
					  <div class="d-none d-md-block col-md-11 col-lg-9 col-xl-8 bg-dark text-right">
		   	  		<h3 class="pb-3">Festival degli Orti</h3>
		   	  		<div class="border-top border-white mb-3 w-75 ml-auto"></div>
		   	  		<p class="lead">Tutto ci&#242; che di buono e salutare l'orto ci regala</p>
		   	  		<a href="#" class="btn btn-primary btn-md">Leggi di Pi&#249;!</a>
	  		    </div>
		      </div>
		 	  </div>
	 		</div>
	  </div>
	  <div class="carousel-item">
	  	<img class="d-block w-100" src="./assets/images/slider2.jpg" alt="Seconda slide">
	    <div class="carousel-caption">
			  <div class="container">
					<div class="row justify-content-end">
					  <div class="d-none d-md-block col-md-11 col-lg-9 col-xl-8 bg-dark text-right">
		   	  		<h3 class="pb-3">La dieta mediterranea</h3>
		   	  		<div class="border-top border-white mb-3 w-75 ml-auto"></div>
		   	  		<p class="lead">Pi&#249; tendente allo stile vegetariano e da seguire soprattutto con l'avanzare dell'et&#224;.</p>
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
		   	  		<h3 class="pb-3">In Vino Veritas</h3>
		   	  		<div class="border-top border-white mb-3 w-75 ml-auto"></div>
		   	  		<p class="lead">Intervista a Luca Gardini, miglior sommelier italiano.</p>
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
					<%
						if (categorie != null && categorie.size() != 0) {
							for (CategoriaBean category: categorie) {
					%>
					<div class="category-content">
						<div class="image-container">
							<img src="./getCategoryImage?idCategoria=<%= category.getIdCategoria() %>" alt="imageCategory.png">
						</div>
						<div class="category-title">
							<h3><%=category.getNome()%></h3>
							<a href="./category?idCategoria=<%=category.getIdCategoria()%>" class="btn btn-category">Visualizza prodotti</a>
							<span></span>
						</div>
					</div>
					<%}} %>
				</div>
		  </div>
		</div>
  </section>
  
  <!-- In Primo Piano -->
  <div class="small-container justify-content-center">
	<h2 class="title">Prodotti In Primo Piano</h2>
	<div class="row">
		<div class="col-4 text-center">
			<img src="./assets/images/primo-piano-1.jpg" alt="">
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
			<img src="./assets/images/primo-piano-2.jpg" alt="">
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
			<img src="./assets/images/primo-piano-3.jpg" alt="">
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
			<img src="./assets/images/primo-piano-4.jpg" alt="">
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
		Collection<ProdottoBean> prodotti = modelProdotto.getLastArrivals(8);
	%>
	<h2 class="title">Ultimi Arrivi</h2>
		<div class="row">
			<%
				if (prodotti != null && prodotti.size() != 0) {
					for(ProdottoBean product: prodotti) {
			%>
			<div class="col-4 text-center">
				<a class="product_link" href="./single_product?idProdotto=<%=product.getIdProdotto()%>">
					<img src="./getProductImage?idProdotto=<%= product.getIdProdotto() %>" alt="imageProduct.png">
					<h4><%= product.getTitolo() %></h4>
				</a>
				<span><%= modelRivenditore.doRetriveNameById(product.getIdUtente()) %></span>
				<div class="rating">
					<i class="fas fa-star"></i>
					<i class="fas fa-star"></i>
					<i class="fas fa-star"></i>
					<i class="fas fa-star"></i>
					<i class="far fa-star"></i>
				</div>
				<p><%= product.getPrezzo()%> &#8364; al <%= product.getUnitaMisura()%></p>
				<button type="button" class="btn bg-cart"><i class="fas fa-cart-plus mr-2"></i>Aggiungi al Carrello</button>
			</div>
			<%}}%>
		</div>
  </div>
  
  <%@include file="./include/footer.html" %>
  <%@include file="./include/script.html" %>
</body>
</html>