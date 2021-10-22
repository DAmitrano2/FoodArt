<%@include file="./include/header.jsp"%>
<div class="container rounded bg-white">
    <div class="row d-flex justify-content-center pb-5">
        <div class="col-sm-5 col-md-5 ml-1">
            <div class="d-flex pt-2">
                <div>
                    <p><b>INDIRIZZO</b></p>
                </div>
                <div class="ml-auto">
                    <p id="media-plus"><i class="fa fa-plus-circle text-primary"></i></p>
                    <p class="text-primary"><i class="fa fa-plus-circle text-primary"></i> Aggiungi un nuovo indirizzo </p>
                </div>
            </div>
            <%
            	IndirizzoConsegnaDAOImp indirizzoDao = new IndirizzoConsegnaDAOImp();
        			Collection<IndirizzoConsegnaBean> indirizzi = indirizzoDao.getIndirizzoByIdUser(user.getIdUtente());
							if (indirizzi != null && indirizzi.size() != 0) {
								int i=0;
								for(IndirizzoConsegnaBean address: indirizzi) {
									i++;
            %>
            <div class="form-check form-check-address my-3">
            	<input class="form-check-input" type="radio" name="flexRadioAddress" id="flexRadioAddress<%=i%>" checked>
            	<label class="form-check-label ml-2" for="flexRadioAddress<%=i%>">
                <span class="address"><%=address.getNome()+" "+address.getCognome() %></span>
                <span class="address"><%=address.getVia()+" "+address.getNumeroCivico() %></span>
                <span class="address"><%=address.getDescrizione() %></span>
                <span class="address"><%=address.getCitta()+", "+address.getProvincia()+", "+address.getCap() %></span>
              </label>
            </div>
            <%}} %>
            <hr>
            <div class="pt-2">
	            <div class="d-flex pt-2">
	                <div>
	                    <p><b>PAGAMENTO</b></p>
	                </div>
	                <div id="payment" class="ml-auto p-2">
	                    <p id="media-plus"><i class="fa fa-plus-circle text-primary"></i></p>
	                    <p class="text-primary"><i class="fa fa-plus-circle text-primary"></i> Aggiungi metodo di pagamento</p>
	                </div>
	            </div>
	            <form class="pb-3">
	            	<% 
	            		MetodoPagamentoDAOImp pagamentoDao = new MetodoPagamentoDAOImp();
		        			Collection<MetodoPagamentoBean> pagamenti = pagamentoDao.getMetodoPagamentoByIdUser(user.getIdUtente());
									if (pagamenti != null && pagamenti.size() != 0) {
										int i=0;
										for(MetodoPagamentoBean paycard: pagamenti) {
											i++;
								%>
                <div class="form-check form-check-paycard my-3">
								  <input class="form-check-input" type="radio" name="flexRadioCard" onclick="setAttribute(this.id)" id="flexRadioCard<%=i%>">
								  <label class="form-check-label ml-2" for="flexRadioCard<%=i%>" data-id="<%=paycard.getNumeroCarta() %>" data-attribute="">
								    <span class="title-card">La carta &#232; intestata a <%=paycard.getIntestatario() %></span>
								    <span class="number-card">Carta di debito che termina con ****<%=paycard.getNumeroCarta(4) %></span>
								  </label>
								</div>
								<%}} %>
								<hr>
            		<button onclick="completeOrder(this)" class="btn btn-primary btn-block">Acquista ora</button>
	            </form>
            </div>
            
        </div>
    </div>
</div>
<%@include file="./include/footer.html" %>
<%@include file="./include/script.html" %>
	<script src="./assets/js/shoppingCart.js"></script>
</body>
</html>