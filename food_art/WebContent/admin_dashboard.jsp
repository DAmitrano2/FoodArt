<%@include file="./include/header.jsp"%>
<main class="mt-5 pt-3">
    <div class="container-fluid">
        <div class="row"></div>
        <div class="small-container">
          <h2 class="title">Bentornato Amministratore</h2>
	        <div id="rowAdmin" class="row justify-content-center">
		        <%
	          	ProductDAOImp prodDao = new ProductDAOImp();
	          	Collection<ProductBean> prodotti = prodDao.doRetrieveAll();
	          %>
		        <div class="col-md-3 mb-3">
		          <div id="adminCard" class="card bg-primary text-white h-100">
		            <div class="card-body py-4">Prodotti <span class="badge bg-secondary"><%=prodotti.size() %></span></div>
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
		            <div class="card-body py-4">Rivenditori <span class="badge bg-secondary"><%=rivenditori.size() %></span></div>
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
	              <div class="card-body py-4">Commenti <span class="badge bg-secondary"><%=feedback.size() %></span></div>
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
	      <div class="card">
	        <div id="products" class="table-container m-3">
		        <table class="table table-striped table-bordered responsive">
		          <thead>
	              <tr>
	                 <th>idProdotto</th>
	                 <th>titolo</th>
	                 <th>descrizione</th>
	                 <th>unitaMisura</th>
	                 <th>prezzo</th>
	                 <th>quantitaMinimaAcquisto</th>
	                 <th>quantitaDisponibile</th>
	                 <th>cittaProvenienza</th>
	                 <th>provinciaProvenienza</th>
	                 <th>valutazione</th>
	                 <th>idCategoria</th>
	                 <th>idUtente</th>
	              </tr>
		          </thead>
		          <tbody>
		          	<% 
		          		if ( prodotti != null &&  prodotti.size() != 0) {
										for ( ProductBean product : prodotti) {
								%>
	              <tr>
	                 <th><%=product.getIdUtente() %></th>
	                 <th><%=product.getTitolo() %></th>
	                 <th><%=product.getDescrizione() %></th>
	                 <th><%=product.getUnitaMisura() %></th>
	                 <th><%=product.getPrezzo() %></th>
	                 <th><%=product.getQuantitaMinima() %></th>
	                 <th><%=product.getQuantitaDisponibile() %></th>
	                 <th><%=product.getCittaProvenienza() %></th>
	                 <th><%=product.getProvinciaProvenienza() %></th>
	                 <th><%=product.getValutazione() %></th>
	                 <th><%=product.getIdCategoria() %></th>
	                 <th><%=product.getIdUtente() %></th> 
	              </tr>
	              <%}} %>
		          </tbody>
		      </table>
	    	</div>
	    	<div id="dealers" class="table-container m-3">
		      <table class="table table-striped table-bordered responsive">
		        <thead>
	            <tr>
	              <th>idUtente</th>
	              <th>dataNascita</th>
	              <th>citta</th>
	              <th>provincia</th>
	              <th>sesso</th>
	              <th>codiceFiscale</th>
	              <th>nPartitaIva</th>
	              <th>filePartitaIva</th>
	              <th>fileDocuIdentita</th>
	              <th>ragioneSociale</th>
	              <th>provinciaSedeLegale</th>
	              <th>cittaSedeLegale</th>
	              <th>viaSedeLegale</th>
	              <th>nCivicoSedeLegale</th>
	              <th>capSedeLegale</th>
	            </tr>
		        </thead>
		        <tbody>
		       		<% 
		       			if ( rivenditori != null &&  rivenditori.size() != 0) {
									for ( DealerBean  dealer: rivenditori) {
							%>
		          <tr>
	              <th><%=dealer.getIdUtente() %></th>
	              <th><%=dealer.getDataNascita() %></th>
	              <th><%=dealer.getCitta() %></th>
	              <th><%=dealer.getProvincia() %></th>
	              <th><%=dealer.getSesso() %></th>
	              <th><%=dealer.getCodiceFiscale() %></th>
	              <th><%=dealer.getNumeroPartitaIva() %></th>
	              <th><%=dealer.getFilePartitaIva() %></th>
	              <th><%=dealer.getFileDocumentoIdentita() %></th>
	              <th><%=dealer.getRagioneSociale() %></th>
	              <th><%=dealer.getProvinciaSedeLegale() %></th>
	              <th><%=dealer.getCittaSedeLegale() %></th>
	              <th><%=dealer.getViaSedeLegale() %></th>
	              <th><%=dealer.getNumeroCivicoSedeLegale() %></th>
	              <th><%=dealer.getCapSedeLegale() %></th>
	            </tr>
		          <%}} %>
		        </tbody>
		    	</table>
	    	</div>
	      <div id="feedback" class="table-container m-3">
		      <table class="table table-striped table-bordered responsive">
		        <thead>
	            <tr>
                <th>idFeedback</th>
                <th>titolo</th>
                <th>commento</th>
                <th>valutazione</th>
                <th>idCommentatore</th>
                <th>idProdotto</th>
                <th>idRivenditore</th>
	            </tr>
		        </thead>
		        <tbody>
		       		<% 
		       			if ( feedback != null &&  feedback.size() != 0) {
									for ( FeedbackBean  fb: feedback) {
							%>
		          <tr>
                <th><%=fb.getIdFeedback() %></th>
                <th><%=fb.getTitolo() %></th>
                <th><%=fb.getCommento() %></th>
                <th><%=fb.getValutazione() %></th>
                <th><%=fb.getIdCommentatore() %></th>
                <th><%=fb.getIdProdotto() %></th>
                <th><%=fb.getIdRivenditore() %></th>
	            </tr>
		          <%}} %>
		        </tbody>
		    	</table>
	    	</div>
    	</div>
    </div>
</main>
<%@include file="./include/footer.html"%>
<%@include file="./include/script.jsp"%>
<script src="<%=path%>/assets/js/admin_dashboard.js"></script>