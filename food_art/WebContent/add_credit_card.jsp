<%@include file="./include/header.jsp"%>
<div class="container">
	<nav aria-label="breadcrumb">
	  <ol class="breadcrumb">
	    <li class="breadcrumb-item"><a href="<%=path%>/dashboard">Il mio account</a></li>
	    <li class="breadcrumb-item"><a href="<%=path%>/dashboard/dashboard_general?title=I%20miei%20pagamenti">I miei pagamenti</a></li>
	    <li class="breadcrumb-item active" aria-current="page">Aggiunta carta di credito</li>
	  </ol>
	</nav>
	<div class="d-flex justify-content-center">
  	<div class="col-sm-6">
	    <div class="card cc-card">
        <div class="card-header py-3">
        	<strong>Inserisci una nuova carta di credito</strong>
        </div>
        <div class="card-body">
	        <div class="row">
	          <div class="col-sm-12">
	            <div class="form-group">
	              <label for="name">Nome dell'intestatario</label>
	              <input class="form-control" id="nm" type="text" placeholder="Inserisci nome e cognome" autocomplete="cc-name">
	            </div>
	          </div>
	        </div>
	        <div class="row">
	          <div class="col-sm-12">
	            <div class="form-group">
	              <label for="ccnumber">Numero della carta</label>
	              <div class="input-group">
	                <input class="form-control" type="text" id="ccnum" placeholder="0000 0000 0000 0000" autocomplete="cc-number">
	                <div class="input-group-append">
	                  <span id="ct" class="input-group-text">
	                  </span>
	                </div>
	              </div>
	            </div>
	          </div>
	        </div>
	        <div class="row">
	          <div class="col-sm-4">
	            <div class="form-group">
	              <label for="cvv">Data di Scadenza</label>
	              <input class="form-control" id="ex" type="text" placeholder="MM / YY">
	            </div>
	          </div>
	          <div class="col-sm-4">
	            <div class="form-group">
	              <label for="cvv">CVV/CVC</label>
	              <input class="form-control" id="cv" type="text" placeholder="123">
	            </div>
	          </div>
	        </div>
        </div>
        <div class="cc-card-footer">
	        <button class="btn float-right" id="btnsub" type="submit">Invia</button>
	        <div id="result" class="emoji"></div>
        </div>
	    </div>
		</div>
  </div>
</div>
<script src="<%=path%>/assets/js/payform.min.js"></script>
<script src="<%=path%>/assets/js/add_credit_card.js"></script>
<%@include file="./include/footer.html"%>
<%@include file="./include/script.jsp"%>