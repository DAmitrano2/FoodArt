	<%@include file="./include/header.jsp"%>
	<%	
		int idCategoria = (int)request.getAttribute("idCategoria");
		ProdottoDAOImp modelProdotto = new ProdottoDAOImp();
		RivenditoreDAOImp modelRivenditore = new RivenditoreDAOImp();
		Collection<ProdottoBean> prodotti = modelProdotto.getProductByIdCategory(idCategoria);
	%>
	<div class="container justify-content-center">
		<div class="row">
			<div class="col-lg-3">
				<div class="title-left-div">
					<a class="title-left" href="category?idCategoria=0"><i class="fas fa-arrow-circle-left"></i>Tutte le categorie</a>
				</div>
				<ul class="list-group"  id="left-list-group">
					<li class="list-group-item">
						<div class="mini-title">
							<p class="h6">Media recensioni clienti</p>
							<a href="#" class="star"><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="far fa-star"></i><p>o pi&#249;</p></a>
							<a href="#" class="star"><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i><p>o pi&#249;</p></a>
							<a href="#" class="star"><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i><p>o pi&#249;</p></a>
							<a href="#" class="star"><i class="fas fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i><p>o pi&#249;</p></a>
						</div>
						<div class="mini-title">
							<p class="h6">Prezzo</p>
							<a href="#" class="lead">Fino a 5 &euro;</a>
							<a href="#" class="lead">da 5 &euro; a 10 &euro;</a>
							<a href="#" class="lead">da 10 &euro; a 20 &euro;</a>
							<a href="#" class="lead">da 20 &euro; a 50 &euro;</a>
							<a href="#" class="lead">50 &euro; o pi&#249;</a>
						</div>
						<div class="mini-title">
							<p class="h6">Nuovi arrivi</p>
							<a href="#" class="lead">Ultimi 30 giorni</a>
							<a href="#" class="lead">Ultimi 90 giorni</a>
							<a href="#" class="lead">Prossimi 90 giorni</a>
						</div>
						<div class="mini-title">
							<p class="h6">Spedizione</p>
							<label class="form-check-label">
								<input type="checkbox" class="form-check-control product_check" value="" id="">Gratis
							</label>
						</div>
					</li>
				</ul>
			</div>
			<div class="col-lg-9">
				<h2 class="title"><%= modelCategoria.doRetrieveByKey(idCategoria).getNome() %></h2>
				<div class="row">
				<%
					if (prodotti != null && prodotti.size() != 0) {
						for(ProdottoBean product: prodotti) {
				%>
					<div class="col-4 text-center">
						<a class="product_link" href="./single_product?idProdotto=<%=product.getIdProdotto()%>">
							<img src="./getProductImage?idProdotto=<%=product.getIdProdotto() %>" alt="imageProduct.png">
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
						<button type="button" class="btn bg-cart" onclick="addCart('add', <%=product.getIdProdotto()%>, '<%=pagina+"?idCategoria="+idCategoria%>')"><i class="fas fa-cart-plus mr-2"></i>Aggiungi al Carrello</button>
					</div>
					<%}}%>
				</div>
			</div>
		</div>
	</div>
	
	<%@include file="./include/footer.html" %>
	<%@include file="./include/script.html" %>
	<script src="./assets/js/shoppingCart.js"></script>
</body>
</html>