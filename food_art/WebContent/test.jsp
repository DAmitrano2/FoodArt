	<%@include file="./include/header.jsp"%>
	<%
		int idCategoria = (int)request.getAttribute("idCategoria");
		ProdottoDAOImp modelProdotto = new ProdottoDAOImp();
		Collection<ProdottoBean> prodotti = modelProdotto.getProductByIdCategory(idCategoria);
	%>
	<div class="container justify-content-center">
		<div class="row">
			<div class="col-lg-3">
				<div class="text-info">Select Brand</div>
				<ul class="list-group">
					<li class="list-group-item">
						<div class="form-check">
							<label class="form-check-label">
								<input type="checkbox" class="form-check-control product_check" value="" id="">
							</label>
						</div>
					</li>
				</ul>
			</div>
			<div class="col-lg-9">
				<h2 class="title"><%= modelCategoria.doRetrieveByKey(idCategoria).getNome()%></h2>
				<%
					if (prodotti != null && prodotti.size() != 0) {
						for(ProdottoBean product: prodotti) {
				%>
				<div class="row">
					<div class="col-4 text-center">
						<img src="./getImage?idprodotto=<%= product.getIdProdotto()%>" alt="imageProduct.png">
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
					<%}}%>
				</div>
			</div>
		</div>
	</div>
	
	<%@include file="./include/footer.html" %>
	<%@include file="./include/script.html" %>
</body>
</html>