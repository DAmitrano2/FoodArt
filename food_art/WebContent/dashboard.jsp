<%@include file="./include/header.jsp"%>
<main class="mt-3 pt-3">
	<div class="container-fluid">
		<div class="small-container">
	   	<h2 class="title">Bentornato, <%=user.getNome()%></h2>
	   	<div class="row justify-content-start">
	       <div class="col-md-4 mb-3">
	         <div class="card text-white h-100" onclick="my_orders()">
	           <div class="card-body">
				      <div class="row">
				      	<i class="fad fa-boxes-alt fa-3x ml-3"></i>
				      	<div class="card-body">
					        <h5 class="card-title">I miei ordini</h5>
					        <p class="card-text">Traccia, restituisci o acquista nuovamente degli articoli</p>
								</div>
							</div>
						</div>
	         </div>
	       </div>
	       <div class="col-md-4 mb-3">
	         <div class="card text-white h-100">
	           <div class="card-body">
				      <div class="row">
				      	<i class="fad fa-address-book fa-3x ml-3"></i>
				      	<div class="card-body">
					        <h5 class="card-title">Indirizzi</h5>
					        <p class="card-text">Modifica indirizzi e preferenze di consegna per gli ordini e i regali</p>
								</div>
							</div>
						</div>
     			</div>
	       </div>
	       <div class="col-md-4 mb-3">
         	<div class="card text-white h-100">
						<div class="card-body">
							<div class="row">
								<i class="fad fa-credit-card fa-3x ml-3"></i>
								<div class="card-body">
									<h5 class="card-title">I miei pagamenti</h5>
									<p class="card-text">Gestisci metodi e impostazioni di pagamento, visualizza saldi e offerte</p>
								</div>
							</div>
						</div>
	       	</div>
	    	</div>
	    	<%
	    		UserDAOImp userDao = new UserDAOImp();
	    		if(userDao.isRivenditore(user.getIdUtente())){
	    	%>
	    	<div class="col-md-4 mb-3">
         	<div class="card text-white h-100">
						<div class="card-body">
							<div class="row">
								<i class="fad fa-carrot fa-3x ml-3"></i>
								<div class="card-body">
									<h5 class="card-title">I miei prodotti</h5>
									<p class="card-text">Aggiungi ed elimina i tuoi prodotti in modo che siano sempre aggiornati</p>
								</div>
							</div>
						</div>
	       	</div>
	    	</div>
	    	<%} %>
	    </div>
	 	</div>
	</div>
</main>
<%@include file="./include/footer.html"%>
<%@include file="./include/script.jsp"%>
<script src="<%=path%>/assets/js/dashboard.js"></script>
</body>
</html>