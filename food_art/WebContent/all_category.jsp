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
					<a class="title-left" href="category?idCategoria=0">Tutte le categorie</a>
				</div>
				<div class="list-group" id="left-list-group">
					<%
						if (categorie != null && categorie.size() != 0) {
							for (CategoriaBean category: categorie) {
					%>
					<a class="list-group-item list-group-item-action" href="category?idCategoria=<%=category.getIdCategoria()%>"><%=category.getNome()%></a>
					<%}} %>
				</div>
			</div>
			<div class="col-lg-9">
				<h2 class="title">Tutte le categorie</h2>
				<div class="row">
				<%
					if (categorie != null && categorie.size() != 0) {
						for (CategoriaBean category: categorie) {
				%>
					<div class="col-4 text-center">
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