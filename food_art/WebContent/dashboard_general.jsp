<%@include file="./include/header.jsp"%>
	<main>
		<%String title = String.valueOf(request.getAttribute("title")); %>
		<div class="container-fluid">
	    <div class="small-container">
	     	<nav aria-label="breadcrumb">
				  <ol class="breadcrumb">
				    <li class="breadcrumb-item"><a href="<%=path%>/dashboard">Il mio account</a></li>
				    <li class="breadcrumb-item active" aria-current="page"><%=title %></li>
				  </ol>
				</nav>
				<h2 class="title"><%=title %></h2>
				<%if(title.equals("Indirizzi")){ %>
				<div class="row justify-content-start">
	      	<div class="col-md-4 mb-3">
	      		<div class="card first-card">
	      			<div class="card-body first-card-body">
	      				<div class="address-plus"></div>
	      				<h2 style="color: #565959!important;">Aggiungi indirizzo</h2>
	      			</div>
      			</div>
	      	</div>
	      	<%
          	AddressDAOImp indirizzoDao = new AddressDAOImp();
    				Collection<AddressBean> indirizzi = indirizzoDao.getIndirizzoByIdUser(user.getIdUtente());
         		if (indirizzi != null && indirizzi.size() != 0) {
         			int i=0;
         			for(AddressBean address: indirizzi) {
     					i++;
          %>
	      	<div id="address<%=address.getIdIndirizzoConsegna() %>" class="col-md-4 mb-3">
	      		<div class="card position-relative">
	      			<div class="card-body">
	            	<label class="form-check-label ml-2">
	                <span class="address title-card"><%=address.getNome()+" "+address.getCognome() %></span>
	                <span class="address"><%=address.getVia()+" "+address.getNumeroCivico() %></span>
	                <%
	                	if(address.getDescrizione() != null){
	                %>
	                <span class="address"><%=address.getDescrizione() %></span>
	                <%} %>
	                <span class="address"><%=address.getCitta()+", "+address.getProvincia()+", "+address.getCap() %></span>
	                <span class="address"><%=address.getNumeroTelefono() %></span>
                </label>
            	</div>
	            <div class="position-absolute">
	            	<a type="button" onclick="remove('Indirizzi', 'delete', '<%=address.getIdIndirizzoConsegna() %>')" class="btn btn-sm">Rimuovi</a>
            	</div>
           	</div>
	      	</div>
	      	<%}} %>
      	</div>
      	<%}else if(title.equals("I miei pagamenti")){ %>
      	<div class="row justify-content-center">
	      	<div class="col-md-4 mb-3">
	      		<div class="card first-card">
	      			<div class="card-body first-card-body">
	      				<div class="address-plus"></div>
	      				<h2 style="color: #565959!important;">Aggiungi carta</h2>
	      			</div>
      			</div>
	      	</div>
	      	<%
         		CardDAOImp pagamentoDao = new CardDAOImp();
	   				Collection<CardBean> pagamenti = pagamentoDao.getMetodoPagamentoByIdUser(user.getIdUtente());
	   				if (pagamenti != null && pagamenti.size() != 0) {
	   					int i=0;
	   					for(CardBean paycard: pagamenti) {
	   						i++;
         	%>
         	<div id="card<%=paycard.getNumeroCarta() %>" class="col-md-4 mb-3">
	      		<div class="card position-relative">
	      			<div class="card-body">
			          <div class="form-check form-check-paycard my-3">
								  <label class="form-check-label ml-2">
								    <span class="title-card"><%=paycard.getIntestatario() %></span>
								    <span class="number-card">Carta di debito che termina con ****<%=paycard.getNumeroCarta(4) %></span>
								  </label>
								</div>
								<div class="position-absolute">
		            	<a type="button" onclick="remove('I miei pagamenti', 'delete', '<%=paycard.getNumeroCarta() %>')" class="btn btn-sm">Rimuovi</a>
	            	</div>
            	</div>
           	</div>
         	</div>
					<%}}%>
      	</div>
      	<%}else if(title.equals("I miei prodotti")){ %>
      	<div class="row justify-content-center">
	      	<div class="col-md-4 mb-3">
	      		<div class="card first-card">
	      			<div class="card-body first-card-body">
	      				<div class="address-plus"></div>
	      				<h2 style="color: #565959!important;">Aggiungi prodotto</h2>
	      			</div>
      			</div>
	      	</div>
	      	<%
         		ProductDAOImp prodottoDao = new ProductDAOImp();
	   				Collection<ProductBean> prodotti = prodottoDao.getProductByIdUser(user.getIdUtente());
	   				if (prodotti != null && prodotti.size() != 0) {
	   					for(ProductBean product: prodotti) {
         	%>
         	<div id="product<%=product.getIdProdotto() %>" class="col-md-4 mb-3">
	      		<div class="card position-relative">
	      			<div class="card-body">
			          <div class="form-check form-check-paycard my-3">
								  <label class="form-check-label">
								    <a class="product_link" href="<%=path %>/single_product?idProdotto=<%=product.getIdProdotto()%>">
											<img src="<%=path %>/getProductImage?idProdotto=<%=product.getIdProdotto() %>" class="img-fluid" alt="imageProduct.png">
											<h4><%= product.getTitolo() %></h4>
										</a>
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
								  </label>
								</div>
								<div class="position-absolute">
		            	<a type="button" onclick="remove('I miei prodotti', 'delete', '<%=product.getIdProdotto() %>')" class="btn btn-sm">Rimuovi</a>
	            	</div>
            	</div>
           	</div>
         	</div>
					<%}}%>
      	</div>
      	<%}%>
	    </div>
		</div>
	</main>
	<%@include file="./include/footer.html"%>
	<%@include file="./include/script.jsp"%>
	<script src="<%=path%>/assets/js/dashboardGeneral.js"></script>
</body>
</html>