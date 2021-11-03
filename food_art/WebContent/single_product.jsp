<%@page import="model.feedback.FeedbackBean"%>
<%@page import="model.feedback.FeedbackDAOImp"%>
<%@include file="./include/header.jsp"%>
<section class="container sproduct my-5">
	<div class="row mt-5">
		<div class="col-lg-5 col-md-12 col-12">
			<%
		    	int idProdotto = (int)request.getAttribute("idProdotto");
					ProdottoDAOImp modelProdotto = new ProdottoDAOImp(); 
					RivenditoreDAOImp modelRivenditore = new RivenditoreDAOImp();
					ProdottoBean prodotto = modelProdotto.doRetrieveByKey(idProdotto);
				%>
			<img class="img-fluid w-100 pb-1"
				src="./getProductImage?idProdotto=<%= prodotto.getIdProdotto() %>"
				id="MainImg" alt="imageProduct.png">
			<!-- div class="small-img-group">
	        <div class="small-img-col">
            <img src="images/primaprodottosingolo.jpg" width="100%" class="small-img" alt="">
	        </div>
	        <div class="small-img-col">
            <img src="images/secondaprodottosingolo.jpg" width="100%" class="small-img" alt="">
	        </div>
	        <div class="small-img-col">
            <img src="images/terzaprodottosingolo.jpg" width="100%" class="small-img" alt="">
	        </div>
	        <div class="small-img-col">
            <img src="images/quartaprodottosingolo.jpg" width="100%" class="small-img" alt="">
	        </div>
	      </div-->
		</div>
		<div class="col-lg-6 col-md-12 col-12">
			<h2><%= prodotto.getTitolo() %></h2>
			<h6>
				da <a href="#"><%= modelRivenditore.doRetriveNameById(prodotto.getIdUtente()) %></a>
			</h6>
			<div class="rating">
				<i class="fas fa-star"></i> <i class="fas fa-star"></i> <i
					class="fas fa-star"></i> <i class="fas fa-star"></i> <i
					class="far fa-star"></i>
			</div>
			<hr>
			<h3><%= prodotto.getPrezzo()%>
				&#8364; al
				<%= prodotto.getUnitaMisura()%></h3>
			<select class="selectpicker my-3">
				<option active>Seleziona la quantit&#224</option>
				<%
	          	int nMin = prodotto.getQuantitaMinima();
	          	int nMax = prodotto.getQuantitaDisponibile();
	          	for(int i=nMin; i<=nMax; i++){
						%>
				<option class="dropdown-item"><%= i %></option>
				<%} %>
			</select>
			<button type="button" id="addCart" class="btn bg-cart"
				onclick="addQuantityCart(<%=prodotto.getIdProdotto()%>, '<%=pagina+"?idProdotto="+idProdotto%>')">
				<i class="fas fa-cart-plus mr-2"></i>Aggiungi al Carrello
			</button>
			<h4 class="mt-3 mb-2">Dettagli sul Prodotto</h4>
			<span><%= prodotto.getDescrizione() %></span>
		</div>
	</div>
</section>
<div class="small-container justify-content-center">
	<h2 class="title">Prodotti Correlati</h2>
	<div class="row">
		<%
				Collection<ProdottoBean> prodottiCategorizzati = modelProdotto.getProductByIdCategory(prodotto.getIdCategoria(), 4, idProdotto);
				if (prodottiCategorizzati != null && prodottiCategorizzati.size() != 0) {
					for(ProdottoBean product: prodottiCategorizzati) {
			%>
		<div class="col-4 text-center">
			<a class="product_link"
				href="./single_product?idProdotto=<%=product.getIdProdotto()%>">
				<img
				src="./getProductImage?idProdotto=<%= product.getIdProdotto() %>"
				alt="prodottiCategorizzati.png">
				<h4><%= product.getTitolo() %></h4>
			</a> <span href="test.jsp"><%= modelRivenditore.doRetriveNameById(product.getIdUtente()) %></span>
			<div class="rating">
				<i class="fas fa-star"></i> <i class="fas fa-star"></i> <i
					class="fas fa-star"></i> <i class="fas fa-star"></i> <i
					class="far fa-star"></i>
			</div>
			<p><%= product.getPrezzo()%>
				&#8364; al
				<%= product.getUnitaMisura()%></p>
			<button type="button" class="btn bg-cart"
				onclick="addCart('add', <%=product.getIdProdotto()%>, '<%=pagina+"?idProdotto="+idProdotto%>')">
				<i class="fas fa-cart-plus mr-2"></i>Aggiungi al Carrello
			</button>
		</div>
		<%}}%>
	</div>
</div>
<section id="testimonials">
	<div class="small-container justify-content-center">
		<%
						FeedbackDAOImp collectionFb = new FeedbackDAOImp();
						Collection<FeedbackBean> feedback = collectionFb.doRetriveByProduct(idProdotto);
						if (feedback != null && feedback.size() != 0) {
							int i=0;
							for(FeedbackBean fb: feedback) {
								i++;
								if(i==1){
			%>
		<h2 class="title">Recensioni in Evidenza</h2>
		<%} %>
		<div class="testimonial-box-container">
			<div class="testimonial-box">

				<div class="box-top">
					<div class="profile">
						<div class="profile-img">
							<img src="./assets/images/default-user-image.png" alt="">
						</div>
					</div>
					<div class="user-informations">
						<div class="title-review">
							<div class="rating">
								<i class="fas fa-star"></i> <i class="fas fa-star"></i> <i
									class="fas fa-star"></i> <i class="fas fa-star"></i> <i
									class="fas fa-star-half-alt"></i>
							</div>
							<strong><%= fb.getTitolo() %></strong>
						</div>
						<div class="name-user">
							<%
									UtenteDAOImp utenteDao = new UtenteDAOImp();
									UtenteBean utente = utenteDao.doRetrieveById(fb.getIdCommentatore()); 
								%>
							<span><%= utente.getNome() %> <%= utente.getCognome() %></span>
						</div>
					</div>
				</div>
				<div class="client-comment">
					<p><%= fb.getCommento() %></p>
				</div>

			</div>
		</div>
		<%}} %>
	</div>
</section>
<%@include file="./include/footer.html"%>
<%@include file="./include/script.html"%>
<script src="./assets/js/shoppingCart.js"></script>
</body>
</html>