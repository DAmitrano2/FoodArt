	<%@page import="model.rivenditore.*"%>
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
							RivenditoreBean rivenditore = new RivenditoreBean();
							rivenditore = modelRivenditore.doRetriveById(product.getIdRivenditore());
				%>
				<div class="row">
					<div class="col-4 text-center">
						<img src="./getImage?idProdotto=<%= product.getIdProdotto()%>" alt="imageProduct.png">
						<h4><%= product.getTitolo()%></h4>
						<span><%= rivenditore.getRagioneSociale() %></span>
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
		</div>
	</div>
	
	<%@include file="./include/footer.html" %>
	<%@include file="./include/script.html" %>
</body>
</html>