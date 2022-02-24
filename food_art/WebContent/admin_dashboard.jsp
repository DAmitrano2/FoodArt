<%@include file="./include/header.jsp"%>
<main class="mt-5 pt-3">
    <div class="container-fluid">
        <div class="row"></div>
        <div class="small-container">
          <h2 class="title">Bentornato, Admin <%=user.getNome()%> </h2>
	        <div id="rowAdmin" class="row justify-content-center">
		        <%
	          	ProductDAOImp prodDao = new ProductDAOImp();
	          	Collection<ProductBean> prodotti = prodDao.doRetrieveAll();
	          %>
		        <div class="col-md-3 mb-3">
		          <div id="adminCard" class="card bg-primary text-white h-100">
		          	<%
	            		if ( prodotti != null && prodotti.size() != 0) {
	            	%>
	              <div class="card-body py-4">Prodotti <span class="badge bg-secondary"><%=prodotti.size() %></span></div>
	              <%
	            		}else {
	              %>
	              <div class="card-body py-4">Prodotti <span class="badge bg-secondary">0</span></div>
	              <%} %>
		            <div onclick="hideProductsList()" id="adminCardFooter" class="card-footer d-flex">
		              Vedi i dettagli
		              <span class="ms-auto">
		                <i class="fas fa-chevron-right"></i>
		              </span>
		            </div>
		          </div>
		        </div>
		        <%
	          	DealerDAOImp dealerDao = new DealerDAOImp();
	          	Collection<DealerBean> rivenditori = dealerDao.doRetrieveAll();
	          %>
		        <div class="col-md-3 mb-3">
		          <div id="adminCard" class="card bg-primary text-white h-100">
		          	<%
	            		if ( rivenditori != null && rivenditori.size() != 0) {
	            	%>
	              <div class="card-body py-4">Rivenditori <span class="badge bg-secondary"><%=rivenditori.size() %></span></div>
	              <%
	            		}else {
	              %>
	              <div class="card-body py-4">Rivenditori <span class="badge bg-secondary">0</span></div>
	              <%} %>
		            <div onclick="hideDealersList()" id="adminCardFooter" class="card-footer d-flex">
		              Vedi i dettagli
		              <span class="ms-auto">
		                <i class="fas fa-chevron-right"></i>
		              </span>
		            </div>
		          </div>
		        </div>
		        <%
	          	FeedbackDAOImp fbDao = new FeedbackDAOImp();
	          	Collection<FeedbackBean> feedback = fbDao.doRetrieveAll();
	          %>
	          <div class="col-md-3 mb-3">
	            <div id="adminCard" class="card bg-warning text-white h-100">
	            	<%
	            		if ( feedback != null &&  feedback.size() != 0) {
	            	%>
	              <div class="card-body py-4">Commenti <span class="badge bg-secondary"><%=feedback.size() %></span></div>
	              <%
	            		}else {
	              %>
	              <div class="card-body py-4">Commenti <span class="badge bg-secondary">0</span></div>
	              <%} %>
	              <div onclick="hideFeedbackList()" id="adminCardFooter" class="card-footer d-flex">
	                Vedi i dettagli
	                <span class="ms-auto">
	                  <i class="fas fa-chevron-right"></i>
	                </span>
	              </div>
	            </div>
	          </div>
	        </div>
	      </div>
	        <div id="div-products" class="container wrapper">
		        <table id="products" class="table table-bordered" cellspacing="0" width="100%">
		          <thead>
	              <tr>
	                 <th class="col-md-2">#ID</th>
	                 <th class="col-md-2">Titolo</th>
	                 <th class="col-md-2">Descrizione</th>
					 <th class="col-md-2">Prezzo</th>
	                 <th class="col-md-2">Provenienza</th>
	                 <th class="col-md-2">Categoria</th>
					 <th class="col-md-2">Azione</th>
	              </tr>
		          </thead>
		          <tbody>
		          	<% 
		          		if ( prodotti != null &&  prodotti.size() != 0) {
										for ( ProductBean product : prodotti) {
								%>
	              <tr id="idProduct<%=product.getIdProdotto() %>">
	                 <td><%=product.getIdProdotto() %></td>
	                 <td><%=product.getTitolo() %></td>
	                 <td><div class="scrollable"><%=product.getDescrizione() %></div></td>
					 				 <td><%=product.getPrezzo() %> &#8364; al <%=product.getUnitaMisura() %></td>
	                 <td><%=product.getCittaProvenienza() %>, <%=product.getProvinciaProvenienza() %> </td>
	                 <td><%=product.getIdCategoria() %></td>
					 				 <td><button type="button" onclick="remove('Prodotto', 'delete', '<%=product.getIdProdotto() %>')" class="btn bg-cart">Elimina</button></td>
	              </tr>
	              <%}} %>
		          </tbody>
		      </table>
	    	</div>
	    	<div id="div-dealers" class="container wrapper">
		      <table id="dealers" class="table table-bordered" cellspacing="0" width="100%">
		        <thead>
	            <tr>
	              <th class="col-md-2">#ID</th>
	              <th class="col-md-2">Codice Fiscale</th>
	              <th class="col-md-2">Partita IVA</th>
	              <th class="col-md-2">Documento</th>
	              <th class="col-md-2">Ragione Sociale</th>
				  <th class="col-md-2">Azione</th>
	            </tr>
		        </thead>
		        <tbody>
		       		<% 
		       			if ( rivenditori != null &&  rivenditori.size() != 0) {
									for ( DealerBean  dealer: rivenditori) {
							%>
		          <tr id="idDealer<%=dealer.getIdUtente()%>">
	              <td><%=dealer.getIdUtente() %></td>
	              <td><%=dealer.getCodiceFiscale() %></td>
	              <td><%=dealer.getFilePartitaIva() %></td>
	              <td><%=dealer.getFileDocumentoIdentita() %></td>
	              <td><%=dealer.getRagioneSociale() %></td>
				  			<td><button type="button" onclick="remove('Rivenditore', 'delete', '<%=dealer.getIdUtente() %>')" class="btn bg-cart">Elimina</button></td> 
	            </tr>
		          <%}} %>
		        </tbody>
		    	</table>
	    	</div>
	      <div id="div-feedback" class="container wrapper">
		      		  		<table id="feedback" class="table table-bordered" cellspacing="0" width="100%">
		        				<thead>
	            					<tr>
                						<th class="col-md-2">#ID</th>
                						<th class="col-md-2">Titolo</th>
                						<th class="col-md-2">Commento</th>
                						<th class="col-md-2">Valutazione</th>
										<th class="col-md-2">Azione</th>
	           				 		</tr>
		        				</thead>
		        				<tbody>
		       						<% 
		       							if ( feedback != null &&  feedback.size() != 0) {
										for ( FeedbackBean  fb: feedback) {
									%>
		        					<tr id="idFeedback<%=fb.getIdFeedback()%>">
										<td><%=fb.getIdFeedback() %></td>
										<td><%=fb.getTitolo() %></td>
										<td><%=fb.getCommento() %></td>
										<td><%=fb.getValutazione() %></td>
										<td><button type="button" onclick="remove('Commento', 'delete', '<%=fb.getIdFeedback() %>')" class="btn bg-cart">Elimina</button></td>
									</tr>
		          					<%}} %>
		        				</tbody>
		    				</table>
	    	</div>
    </div>
</main>
<%@include file="./include/footer.html"%>
<%@include file="./include/script.jsp"%>
<script src="${pageContext.request.contextPath}/assets/jQuery/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/dataTables.responsive.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/dataTables.bootstrap4.min.js"></script>
<script src="<%=path%>/assets/js/admin_dashboard.js"></script>
</body>
</html>