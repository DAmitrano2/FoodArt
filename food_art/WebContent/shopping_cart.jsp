<%@include file="./include/header.jsp"%>
<div class="container-fluid">
  <div class="row">
    <aside class="col-lg-9">
	    <div class="card">
	        <table class="table table-borderless table-shopping-cart">
	          <thead class="text-muted">
	            <div class="small title-cart">
	            	<%
		            	if(cart != null && cart.getQuantita() != 0){
	            	%>  
		            		<h3>Carrello</h3>
		            <%
	            		}else {
           			%>  
    	            	<h3>Il tuo carrello &#232; vuoto</h3>
   	            	<%
	            		}
	            	%>
	            </div>
	          </thead>
	          <tbody>
					<%
  					RivenditoreDAOImp modelRivenditore = new RivenditoreDAOImp();
						if(cart != null && cart.getProducts().size() != 0){
		          		for(ProductItem product: cart.getProducts()){
							%>
	         		<tr class="d-flex align-items-center">
	              <td>
                  <figure class="itemside align-items-center">
	                  <div class="aside"><img src="./getProductImage?idProdotto=<%= product.getIdProdotto() %>" class="img-sm"></div>
	                  <figcaption class="info"><a href="./single_product?idProdotto=<%=product.getIdProdotto()%>" class="text-dark" data-abc="true"><%= product.getTitolo() %></a>
                    	<p class="text-muted small">da: <a href=""><%= modelRivenditore.doRetriveNameById(product.getIdUtente()) %></a></p>
	                  </figcaption>
                  </figure>
	              </td>
	              <td onClick="setQuantityCart('set', <%=product.getIdProdotto()%>, '<%=pagina%>', this)" id="quantita">
		              <select class="selectpicker my-3">
	         	 			<option active><%=product.getQuantita() %></option>
                  			<%
					          	int nMin = product.getQuantitaMinima();
					          	int nMax = product.getQuantitaDisponibile();
					          	for(int i=nMin; i<=nMax; i++){
					          		if(i!=product.getQuantita()){
							%>	
										<!-- %setQuantityCart('set', <-%=product.getIdProdotto() %>, 'shopping_cart', this) %-->
					          <option><%=i %></option>
					          <%}} %>
	              	</select>
	              	<p class="small"><%= product.getUnitaMisura()%></p>
	              </td>
	              <td>
                  <div class="price-wrap"><var class="price">&#8364; <%= product.getPrezzo()%></var></div>
	              </td>
	              <td class="text-right d-md-block">
	              	<a href="cart?action=delete&idProdotto=<%=product.getIdProdotto() %>" class="btn" data-abc="true"><i class="fas fa-trash-alt"></i> Rimuovi</a> 
	              </td>
	            </tr>
		          <%
		          	}}
		          %>
	          </tbody>
	        </table>
	    </div>
    </aside>
    <aside class="col-lg-3">
	    <div class="card">
	      <div class="card-body">
	        <dl class="dlist-align">
            <dt>Totale provvisorio:</dt>
            <%
            	if(cart != null && cart.getQuantita() != 0){
            %>
            <dd class="text-right ml-3">&#8364; <%=String.valueOf(cart.getPrezzoTotale()).replace(".", ",") %></dd>
	        	<%}else { %>
	        	<dd class="text-right ml-3">&#8364; 0</dd>
	        	<%} %>
	        </dl>
	        <hr>
	        <%if(auth && cart != null && cart.getQuantita() != 0){ %>
	        	<a href="recap_order" id="order" class="btn btn-out btn-primary btn-square btn-main" data-abc="true">
	        <%}else if(auth && (cart == null || cart.getQuantita() == 0)) { %>
	        	<a href="" id="order" class="btn btn-out btn-primary btn-square btn-main" data-abc="true">
	        <%}else if(!auth){ %>
	        	<a href="login" id="order" class="btn btn-out btn-primary btn-square btn-main" data-abc="true">
	        <%} %>
	        	<i class="fas fa-check-square"></i> Procedi all'ordine
        	</a> 
        	<a href="index" class="btn btn-out btn-success btn-square btn-main mt-2" data-abc="true">
        		<i class="fas fa-arrow-circle-left"></i> Continua lo shopping
        	</a>
	      </div>
   		</div>
    </aside>
  </div>
</div>
<%@include file="./include/footer.html" %>
<%@include file="./include/script.html" %>
<script src="./assets/js/shoppingCart.js"></script>
</body>
</html>