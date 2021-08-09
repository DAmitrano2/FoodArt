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
					<a class="title-left" href="categoria?idCategoria=0">Tutte le categorie</a>
				</div>
				<div class="list-group" id="left-list-group">
					<%
						if (categorie != null && categorie.size() != 0) {
							for (CategoriaBean category: categorie) {
					%>
					<a class="list-group-item list-group-item-action" href="categoria?idCategoria=<%=category.getIdCategoria()%>"><%=category.getNome()%></a>
					<%}} %>
				</div>
			</div>
			<div class="col-lg-9">
				<h2 class="title">Tutte le categorie</h2>
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
			</div>
		</div>
	</div>
	<%@include file="./include/footer.html" %>
	<%@include file="./include/script.html" %>
</body>
</html>