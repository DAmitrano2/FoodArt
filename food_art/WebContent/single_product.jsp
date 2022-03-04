<%@page import="model.feedback.FeedbackBean"%>
<%@page import="model.feedback.FeedbackDAOImp"%>
<%@include file="./include/header.jsp"%>
<section class="container sproduct my-5">
	<div class="row mt-5">
		<div class="col-lg-5 col-md-12 col-12">
			<%
				int idProdotto = (int)request.getAttribute("idProdotto");
				ProductDAOImp modelProdotto = new ProductDAOImp(); 
				DealerDAOImp modelRivenditore = new DealerDAOImp();
				ProductBean prodotto = modelProdotto.doRetrieveByKey(idProdotto);
			%>
			<img class="img-fluid w-100 pb-1" src="./getProductImage?idProdotto=<%=prodotto.getIdProdotto() %>" id="MainImg" alt="imageProduct.png">
		</div>
		<div class="col-lg-6 col-md-12 col-12">
			<h2><%=prodotto.getTitolo()%></h2>
			<h6>da <a href="./dealer_info?idDealer=<%=prodotto.getIdUtente() %>"><%=modelRivenditore.doRetriveNameById(prodotto.getIdUtente())%></a></h6>
			<div class="rating">
		 	<%
 		 	 	if(prodotto.getValutazione() > 0.0){
	 			 	float rating = prodotto.getValutazione();
	 		   		if(rating>=1 && rating<2){				//1 stel
 		 	%>
	    		<i class="fas fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i>
		   	<%
		   			}else if(rating>=2 && rating<3){		//2 stel
		   	%>
	    		<i class="fas fa-star"></i><i class="fas fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i>
		   	<%
		   			}else if(rating>=3 && rating<4){		//3 stel
		   	%>
	    		<i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i>
		   	<%
					}else if(rating>=4 && rating<5){		//4 stel
		   	%>
	    		<i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="far fa-star"></i>
		   	<%
		   			}else if(rating==5){					//5 stel
		   	%>
				<i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i>
	    	<%}}%>
		    </div>
			<hr>
			<h3><%=prodotto.getPrezzo()%>&#8364; al <%=prodotto.getUnitaMisura()%></h3>
			<select class="selectpicker my-3">
				<option active>Seleziona la quantit&#224</option>
				<%
		          	int nMin = prodotto.getQuantitaMinima();
		          	int nMax = prodotto.getQuantitaDisponibile();
		          	for(int i=nMin; i<=nMax; i++){
				%>
				<option class="dropdown-item"><%=i%></option>
				<%}%>
			</select>
			<button type="button" id="addCart" class="btn bg-cart" onclick="addQuantityCart(<%=prodotto.getIdProdotto()%>, '<%=pagina+"?idProdotto="+idProdotto%>')">
				<i class="fas fa-cart-plus mr-2"></i>Aggiungi al Carrello
			</button>
			<h4 class="mt-3 mb-2">Dettagli sul Prodotto</h4>
			<span><%=prodotto.getDescrizione()%></span>
			<h4 class="mt-3 mb-2">Provenienza</h4>
			<span><%=prodotto.getCittaProvenienza() %>, <%=prodotto.getProvinciaProvenienza() %></span>
		</div>
	</div>
</section>
<div class="small-container justify-content-center">
	<h2 class="title">Prodotti Correlati</h2>
	<div class="row">
		<%
			Collection<ProductBean> prodottiCategorizzati = modelProdotto.getProductByIdCategory(prodotto.getIdCategoria(), 4, idProdotto);
			if (prodottiCategorizzati != null && prodottiCategorizzati.size() != 0) {
				for(ProductBean product: prodottiCategorizzati) {
		%>
		<div class="col-4 text-center">
			<a class="product_link"	href="./single_product?idProdotto=<%=product.getIdProdotto()%>">
				<img src="./getProductImage?idProdotto=<%=product.getIdProdotto()%>" alt="prodottiCategorizzati.png">
				<h4><%=product.getTitolo()%></h4>
			</a>
			<h6><a href="./dealer_info?idDealer=<%=product.getIdUtente() %>"><%=modelRivenditore.doRetriveNameById(product.getIdUtente())%></a></h6>
			<div class="rating"> 
		 	<%
 		 	 if(product.getValutazione() > 0){
 			 	float rating = product.getValutazione();
			 	if(rating>=1 && rating<2){				//1 stel
 		 	%>
	    		<i class="fas fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i>
		   	<%
		   		}else if(rating>=2 && rating<3){		//2 stel
		   	%>
	    		<i class="fas fa-star"></i><i class="fas fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i>
		   	<%
		   		}else if(rating>=3 && rating<4){		//3 stel
		   	%>
	    		<i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i>
		   	<%
			   	}else if(rating>=4 && rating<5){		//4 stel
		   	%>
	    		<i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="far fa-star"></i>
		   	<%
		   		}else if(rating==5){					//5 stel
		   	%>
				<i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i>
	    	<%}}%>
	    	</div>
			<p><%=product.getPrezzo()%>&#8364; al <%=product.getUnitaMisura()%></p>
			<button type="button" class="btn bg-cart" onclick="addCart('add', <%=product.getIdProdotto()%>, '<%=pagina+"?idProdotto="+idProdotto%>')">
				<i class="fas fa-cart-plus mr-2"></i>Aggiungi al Carrello
			</button>
		</div>
		<%}}%>
	</div>
</div>
<section id="testimonials">
	<div class="small-container justify-content-center">
		<!-- Feedback form -->
		<%if(auth){ %>
		<h2 class="title">Lascia una recensione</h2>
		<div id="testimonial-id" data-id-prod="<%=idProdotto %>" data-id-user="<%=prodotto.getIdUtente() %>" class="testimonial-box-container">
			<div class="testimonial-box">
				<div class="box-top">
					<div class="user-informations">
						<div class="comment-group input-group input-group-sm mb-2">
							<h3 class="mr-3">Seleziona la valutazione</h3>
							<div class="rating mt-1" id="rating-comment" data-value="">
								<i class="far fa-star" onclick="oneStar()"></i><i class="far fa-star" onclick="twoStar()"></i><i class="far fa-star" onclick="threeStar()"></i><i class="far fa-star" onclick="fourStar()"></i><i class="far fa-star" onclick="fiveStar()"></i>
					    	</div>
							<div class="div-error">
								<div class="error"></div>
							  </div>					    	
						</div>
					</div>
				</div>
				<div class="comment-group input-group input-group-sm mb-3">
					<h3 class="mr-3">Aggiungi un titolo</h3>
					<input type="text" name="title" id="title-comment" class="comment-input form-control mt-2" placeholder="Quali sono le cose pi&#249; importanti da sapere?">
					<div class="div-error">
						<div class="error"></div>
					  </div>
				</div>
				<div class="comment-group client-comment input-group input-group-sm">
					<h3 class="mr-3">Aggiungi una recensione scritta</h3>
					<textarea id="textarea-comment" name="comment" class="comment-input form-control mt-2" placeholder="Che cosa ti &#232; piaciuto e cosa non ti &#232; piaciuto?"></textarea>
					<div class="div-error">
						<div class="error"></div>
					  </div>
				</div>
				<div class="form-group" style="display: flow-root;">
					<button id="inviaFb" type="button" class="btn float-right comment_btn mt-3">Invia</button>
				</div>
			</div>
		</div>
		<%}
		
			FeedbackDAOImp collectionFb = new FeedbackDAOImp();
			Collection<FeedbackBean> feedback = collectionFb.doRetriveByProduct(idProdotto);
			if (feedback != null && feedback.size() != 0) {
				int i=0;
				for(FeedbackBean fb: feedback) {
					i++;
					if(i==1){
		%>
		<h2 class="title">Recensioni</h2>
		<%}%>
		<!-- Feedback presi dal db -->
		<div class="testimonial-box-container">
			<div class="testimonial-box">
				<div class="box-top">
					<div class="profile">
						<div class="profile-img">
							<img src="./getUserImage?idUtente=<%=fb.getIdCommentatore()%>" alt="user.png">
						</div>
					</div>
					<div class="user-informations">
						<div class="title-review">
							<strong><%=fb.getTitolo()%></strong>
							<div class="rating">
						 	<%
						 	if(fb.getValutazione() > 0){
		 					 	float rating = fb.getValutazione();
		 					 	if(rating>=1 && rating<2){				//1 stel
						 	%>
					    		<i class="fas fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i>
						   	<%
						   		}else if(rating>=2 && rating<3){		//2 stel
						   	%>
					    		<i class="fas fa-star"></i><i class="fas fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i>
						   	<%
						   		}else if(rating>=3 && rating<4){		//3 stel
						   	%>
					    		<i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i>
						   	<%
						   		}else if(rating>=4 && rating<5){		//4 stel
						   	%>
					    		<i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="far fa-star"></i>
						   	<%
						   		}else if(rating==5){					//5 stel
						   	%>
								<i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i>
					    	<%}}%>
					    	</div>
						</div>
						<div class="name-user pb-2">
							<%
								UserDAOImp utenteDao = new UserDAOImp();
								UserBean utente = utenteDao.doRetrieveById(fb.getIdCommentatore());
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
<%@include file="./include/script.jsp"%>
<script src="<%=path%>/assets/js/feedback.js"></script>
</body>
</html>