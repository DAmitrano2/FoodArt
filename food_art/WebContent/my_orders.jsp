<%@include file="./include/header.jsp"%>
	<div class="container-fluid">
    <div class="small-container">
     	<nav aria-label="breadcrumb">
			  <ol class="breadcrumb">
			    <li class="breadcrumb-item"><a href="<%=path%>/dashboard">Il mio account</a></li>
			    <li class="breadcrumb-item active" aria-current="page">I miei ordini</li>
			  </ol>
			</nav>
			<h2 class="title">I miei ordini</h2>
			<section class="h-100 gradient-custom">
			  <div class="container py-5 h-100">
			    <div class="row d-flex justify-content-center align-items-center h-100">
			      <div class="col-lg-10 col-xl-8">
				      <%
				      	
								OrderDAOImp modelOrdine = new OrderDAOImp();
								Collection<OrderBean> ordini = modelOrdine.doRetrieveAll(user.getIdUtente());
								if (ordini != null && ordini.size() != 0) {
									for (OrderBean order: ordini) {
										float tot = 0;
							%>
			        <div class="card" style="border-radius: 10px;">
			          <div class="card-header px-2 py-3">
			            <h5 class="text-muted mb-0">Ordine nr&#176;: <span><%=order.getIdOrdine() %></span></h5>
			          </div>
			          <div class="card-body p-4">
				          <%
					          EntryDAOImp modelEntry = new EntryDAOImp();
										Collection<EntryBean> voci = modelEntry.doRetrieveByOrderKey(order.getIdOrdine());
										if (voci != null && voci.size() != 0) {
											for (EntryBean entry: voci) {
												ProductDAOImp modelProduct = new ProductDAOImp();
												DealerDAOImp modelRivenditore = new DealerDAOImp();
												ProductBean product = modelProduct.doRetrieveByKey(entry.getIdProdotto());
									%>
									<div class="card shadow-0 border mb-4">
			              <div class="card-body">
			                <div class="row">
			                  <div class="col-md-2">
			                    <img src="<%=path%>/getProductImage?idProdotto=<%=product.getIdProdotto() %>" alt="imageProduct.png" class="img-fluid">
			                  </div>
			                  <div class="col-md-2 text-center d-flex justify-content-center align-items-center">
			                    <p class="text-muted mb-0"><%= product.getTitolo() %></p>
			                  </div>
			                  <div class="col-md-2 text-center d-flex justify-content-center align-items-center">
			                    <p class="text-muted mb-0 small"><%= modelRivenditore.doRetriveNameById(product.getIdUtente()) %></p>
			                  </div>
			                  <div class="col-md-2 text-center d-flex justify-content-center align-items-center">
			                    <p class="text-muted mb-0 small"><%= product.getUnitaMisura() %>: <%=(int)entry.getQuantita() %></p>
			                  </div>
			                  <div class="col-md-2 text-center d-flex justify-content-center align-items-center">
			                    <p class="text-muted mb-0 small">&#8364; <%=entry.getPrezzo() %></p>
			                    <%tot += entry.getPrezzo()*entry.getQuantita();%>
			                  </div>
			                </div>
			              </div>
			            </div>
			            <%}} %>
			            <div class="d-flex justify-content-between pt-2">
			              <p class="fw-bold mb-0">Dettagli Ordine</p>
			            </div>
			            <div class="d-flex justify-content-between pt-2">
			              <p class="text-muted mb-0">Data Ricezione : <%=order.getDataOra() %></p>
			            </div>
			            <div class="d-flex justify-content-between">
			              <p class="text-muted mb-0">Indirizzo di Consegna : <%=order.getVia() %> <%=order.getNumeroCivico() %>, <%=order.getCitta() %>, <%=order.getProvincia() %>, <%=order.getCap() %></p>
			            </div>
			          </div>
			          <div class="mo-card-footer border-0 px-2 py-3">
			            <h5 class="d-flex align-items-center justify-content-end text-white text-uppercase mb-0 mr-4">Totale: &#8364; <%=tot %></h5>
			          </div>
			        </div>
			        <%}} %>
			      </div>
			    </div>
			  </div>
			</section>
		</div>
	</div>
	<%@include file="./include/footer.html" %>
  <%@include file="./include/script.jsp" %>
</body>
</html>