<%@include file="./include/header.jsp"%>
<div class="container rounded bg-white">
    <div class="row d-flex justify-content-center pb-5 pt-5">
        <div class="col-sm-6 col-md-6">
            <div class="d-flex pt-2">
                <div>
                    <p><b>SELEZIONA INDIRIZZO</b></p>
                </div>
                <a href="<%=path %>/dashboard/dashboard_general/add_address" class="ml-auto">
                    <p id="media-plus"><i class="fa fa-plus-circle text-primary"></i></p>
                    <p class="text-primary" data-toggle="collapse"  role="button" aria-expanded="false" aria-controls="collapseAddress"><i class="fa fa-plus-circle text-primary"></i> Aggiungi un nuovo indirizzo </p>
                </a>
            </div>
            <%
            	AddressDAOImp indirizzoDao = new AddressDAOImp();
      				Collection<AddressBean> indirizzi = indirizzoDao.getIndirizzoByIdUser(user.getIdUtente());
           		if (indirizzi != null && indirizzi.size() != 0) {
           			int i=0;
           			for(AddressBean address: indirizzi) {
       					i++;
            %>
            <div class="form-check form-check-address my-3">
            	<input class="form-check-input" type="radio" name="flexRadioAddress" id="flexRadioAddress<%=i%>" onclick="setAddress(<%=address.getIdIndirizzoConsegna() %>)">
            	<label class="form-check-label ml-2" for="flexRadioAddress<%=i%>">
	                <span class="address title-card"><%=address.getNome()+" "+address.getCognome() %></span>
	                <span class="address"><%=address.getVia()+" "+address.getNumeroCivico() %></span>
	                <%
	                	if(address.getDescrizione() != null){
	                %>
	                <span class="address"><%=address.getDescrizione() %></span>
	                <%} %>
	                <span class="address"><%=address.getCitta()+", "+address.getProvincia()+", "+address.getCap() %></span>
              	</label>
            </div>
            <%}} %>
            <hr>
            <div class="d-flex pt-2">
                <div>
                    <p><b>SELEZIONA PAGAMENTO</b></p>
                </div>
                <a href="<%=path %>/dashboard/dashboard_general/add_credit_card" class="ml-auto">
                    <p id="media-plus"><i class="fa fa-plus-circle text-primary"></i></p>
                    <p class="text-primary" data-toggle="collapse" role="button" aria-expanded="false" aria-controls="collapseCard"><i class="fa fa-plus-circle text-primary"></i> Aggiungi metodo di pagamento</p>
                </a>
            </div>
            <div class="small-container justify-content-center collapse" id="collapseCard">
				<div class="testimonial-box-container">
					<div class="testimonial-box">
						<div class="mb-3">
							<p>Numero della Carta</p>
							<div class="form-row">
								<div class="comment-group input-group-sm col-md-12">
									<input type="text" id="via-address" class="comment-input form-control" placeholder="1234 5678 9012 3456">
								</div>
							</div>
						</div>
						<div class="mb-3">
							<p>Nome intestatario</p>
							<div class="form-row">
								<div class="comment-group input-group-sm col-md-12">
									<input type="text" id="citta-address" class="comment-input form-control" placeholder="Es. Jeff Bezos">
								</div>
							</div>
						</div>
						<div>
							<p>Data Scadenza e CVV</p>
							<div class="form-row">
								<div class="comment-group input-group-sm col-md-8">
									<input type="text" id="provincia-address" class="comment-input form-control" placeholder="data">	
								</div>
								<div class="comment-group input-group-sm col-md-4">
									<input type="text" id="cap-address" class="comment-input form-control" placeholder="cvv" maxlength="5">	
								</div>
							</div>
						</div>
						<div class="form-group" style="display: flow-root;">
							<button type="button" class="btn btn-primary float-right comment_btn mt-3">Invia</button>
						</div>
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
            <div class="form-check form-check-paycard my-3">
			  <input class="form-check-input" type="radio" name="flexRadioCard" id="flexRadioCard<%=i%>" onclick="setCard(<%=paycard.getNumeroCarta() %>)">
			  <label class="form-check-label ml-2" for="flexRadioCard<%=i%>">
			    <span class="title-card">La carta &#232; intestata a <%=paycard.getIntestatario() %></span>
			    <span class="number-card">Carta di debito che termina con ****<%=paycard.getNumeroCarta(4) %></span>
			  </label>
			</div>
			<%}}%>
			<hr>
   			<button onclick="enter()" class="btn btn-primary btn-block">Acquista ora</button>
    		</div>
    	</div>
    </div>
	<%@include file="./include/footer.html" %>
	<%@include file="./include/script.jsp" %>
	<script src="<%=path%>/assets/js/completeOrder.js"></script>
</body>
</html>