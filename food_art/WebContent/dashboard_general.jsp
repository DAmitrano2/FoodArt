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
				<div class="row justify-content-center">
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
	      	<div class="col-md-4 mb-3">
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
	            	<a type="button" class="btn btn-sm">Rimuovi</a>
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
         	<div class="col-md-4 mb-3">
	      		<div class="card position-relative">
	      			<div class="card-body">
			          <div class="form-check form-check-paycard my-3">
								  <label class="form-check-label ml-2">
								    <span class="title-card"><%=paycard.getIntestatario() %></span>
								    <span class="number-card">Carta di debito che termina con ****<%=paycard.getNumeroCarta(4) %></span>
								  </label>
								</div>
								<div class="position-absolute">
		            	<a type="button" class="btn btn-sm">Rimuovi</a>
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