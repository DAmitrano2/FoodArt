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
	    <img class="d-block w-100" src="<%=path%>/assets/images/slider1.png" alt="Prima slide">
	    <div class="carousel-caption">
			  <div class="container">
					<div class="row justify-content-end">
					  <div class="d-none d-md-block col-md-11 col-lg-9 col-xl-8 bg-dark text-right">
		   	  		<h3 class="pb-3">Festival degli Orti</h3>
		   	  		<div class="border-top border-white mb-3 w-75 ml-auto"></div>
		   	  		<p class="lead">Tutto ci&#242; che di buono e salutare l'orto ci regala</p>
		   	  		<a href="./dealer_dashboard.jsp" class="btn btn-primary btn-md">Leggi di Pi&#249;!</a>
	  		    </div>
		      </div>
		 	  </div>
	 		</div>
	  </div>
	  <div class="carousel-item">
	  	<img class="d-block w-100" src="<%=path%>/assets/images/slider2.jpg" alt="Seconda slide">
	    <div class="carousel-caption">
			  <div class="container">
					<div class="row justify-content-end">
					  <div class="d-none d-md-block col-md-11 col-lg-9 col-xl-8 bg-dark text-right">
		   	  		<h3 class="pb-3">La dieta mediterranea</h3>
		   	  		<div class="border-top border-white mb-3 w-75 ml-auto"></div>
		   	  		<p class="lead">Pi&#249; tendente allo stile vegetariano e da seguire soprattutto con l'avanzare dell'et&#224;.</p>
		   	  		<a href="./admin_dashboard.jsp" class="btn btn-primary btn-md">Leggi di Pi&#249;!</a>
  	  		  </div>
 		    	</div>
	      </div>
	 		</div>
	  </div>
	  <div class="carousel-item">
	    <img class="d-block w-100" src="<%=path%>/assets/images/slider3.jpg" alt="Terza slide">
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
						for (CategoryBean category: categorie) {
					%>
					<div class="category-content">
						<div class="image-container">
							<img src="./getCategoryImage?idCategoria=<%=category.getIdCategoria() %>" alt="imageCategory.png">
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
			<a class="product_link" href="./single_product?idProdotto=1">
				<img src="./getProductImage?idProdotto=1" alt="">
				<h4>Confettura Albicocche</h4>
			</a>
			<h6><a href="./dealer_info?idDealer=6">Societ&#224; Agricola Amitrano</a></h6>
			<div class="rating">
				<i class="fas fa-star"></i>
				<i class="fas fa-star"></i>
				<i class="fas fa-star"></i>
				<i class="fas fa-star"></i>
				<i class="far fa-star"></i>
			</div>
			<p>&#8364; 6.00, pz</p>
			<button type="button" class="btn bg-cart" onclick="addCart('add', 1, '<%="index"%>')"><i class="fas fa-cart-plus mr-2"></i>Aggiungi al Carrello</button>
		</div>
		<div class="col-4 text-center">
			<a class="product_link" href="./single_product?idProdotto=2">
				<img src="./getProductImage?idProdotto=2" alt="">
				<h4>Salame Toscano</h4>
			</a>
			<h6><a href="./dealer_info?idDealer=14">La Salumeria dello Zio</a></h6>
			<div class="rating">
				<i class="fas fa-star"></i>
				<i class="fas fa-star"></i>
				<i class="fas fa-star"></i>
				<i class="fas fa-star"></i>
				<i class="far fa-star"></i>
			</div>
			<p>&#8364; 11.50, pz</p>
			<button type="button" class="btn bg-cart" onclick="addCart('add', 2, '<%="index"%>')"><i class="fas fa-cart-plus mr-2"></i>Aggiungi al Carrello</button>
		</div>
		<div class="col-4 text-center">
			<a class="product_link" href="./single_product?idProdotto=3">
				<img src="./getProductImage?idProdotto=3" alt="">
				<h4>Pere Santa Maria</h4>
			</a>
			<h6><a href="./dealer_info?idDealer=7">Frutta & Verdura Zappia</a></h6>
			<div class="rating">
				<i class="fas fa-star"></i>
				<i class="fas fa-star"></i>
				<i class="fas fa-star"></i>
				<i class="fas fa-star-half-alt"></i>
				<i class="far fa-star"></i>
			</div>
			<p>&#8364; 1.25, kg</p>
			<button type="button" class="btn bg-cart" onclick="addCart('add', 3, '<%="index"%>')"><i class="fas fa-cart-plus mr-2"></i>Aggiungi al Carrello</button>
		</div>
		<div class="col-4 text-center">
			<a class="product_link" href="./single_product?idProdotto=4">
				<img src="./getProductImage?idProdotto=4" alt="">
				<h4>Birra Artigianale 0,3l</h4>
			</a>
			<h6><a href="./dealer_info?idDealer=19">Cantina Marrazzo</a></h6>
			<div class="rating">
				<i class="fas fa-star"></i>
				<i class="fas fa-star"></i>
				<i class="fas fa-star"></i>
				<i class="fas fa-star"></i>
				<i class="fas fa-star-half-alt"></i>
			</div>
			<p>&#8364; 9.20</p>
			<button type="button" class="btn bg-cart" onclick="addCart('add', 4, '<%="index"%>')"><i class="fas fa-cart-plus mr-2"></i>Aggiungi al Carrello</button>
		</div>
	</div>
	<!-- Ultimi Arrivi -->
	<%
		ProductDAOImp modelProdotto = new ProductDAOImp(); 
		DealerDAOImp modelRivenditore = new DealerDAOImp();
		Collection<ProductBean> prodotti = modelProdotto.getLastArrivals(8);
	%>
	<h2 class="title">Ultimi Arrivi</h2>
		<div class="row">
			<%
				if (prodotti != null && prodotti.size() != 0) {
					for(ProductBean product: prodotti) {
			%>
			<div class="col-4 text-center">
				<a class="product_link" href="./single_product?idProdotto=<%=product.getIdProdotto()%>">
					<img src="./getProductImage?idProdotto=<%= product.getIdProdotto() %>" alt="imageProduct.png">
					<h4><%= product.getTitolo() %></h4>
				</a>
				<h6><a href="./dealer_info?idDealer=<%=product.getIdUtente() %>"><%= modelRivenditore.doRetriveNameById(product.getIdUtente()) %></a></h6>
				<div class="rating"> 
			 	<% if(product.getValutazione() > 0){
				 	float rating = product.getValutazione();
				 	if(rating>=1 && rating<2){				//1 stella%>
		    		<i class="fas fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i>
			   	<%}else if(rating>=2 && rating<3){		//2 stelle%>
		    		<i class="fas fa-star"></i><i class="fas fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i>
			   	<%}else if(rating>=3 && rating<4){		//3 stelle%>
		    		<i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i>
			   	<%}else if(rating>=4 && rating<5){		//4 stelle%>
		    		<i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="far fa-star"></i>
			   	<%}else if(rating==5){					//5 stelle%>
					<i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i>
		    	<%}}%>
		    	</div>
				<p><%= product.getPrezzo()%> &#8364; al <%= product.getUnitaMisura()%></p>
				<button type="button" class="btn bg-cart" onclick="addCart('add', <%=product.getIdProdotto()%>, '<%="index"%>')">
					<i class="fas fa-cart-plus mr-2"></i>Aggiungi al Carrello
				</button>
			</div>
			<%}}%>
		</div>
  </div>
  <%@include file="./include/footer.html" %>
  <%@include file="./include/script.jsp" %>
</body>
</html>