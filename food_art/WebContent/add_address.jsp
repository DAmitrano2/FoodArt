<%@include file="./include/header.jsp"%>
<div class="container">
	<nav aria-label="breadcrumb">
	  <ol class="breadcrumb">
	    <li class="breadcrumb-item"><a href="<%=path%>/dashboard">Il mio account</a></li>
	    <li class="breadcrumb-item"><a href="<%=path%>/dashboard/dashboard_general?title=Indirizzi">Indirizzi</a></li>
	    <li class="breadcrumb-item active" aria-current="page">Aggiunta indirizzo</li>
	  </ol>
	</nav>
  <div class="d-flex justify-content-center">
	  <div class="col-sm-6">
	    <div class="card address-card">
	      <div class="card-header py-3">
          <strong>Inserisci un nuovo indirizzo</strong>
	      </div>
	     	<form id="form" action="add_address" method="post">
	      	<div class="card-body">
	      	<%
						String error = String.valueOf(request.getAttribute("errorMessage"));
						if(error != "null"){
					%>
					<div class="alert alert-danger" role="alert">
					  <h4 class="alert-heading">Invio fallito</h4>
					  <p><%=error %></p>
					</div>
					<%} %>
	          <div class="row">
	            <div class="col-sm-6">
	              <div class="form-group">
	                <label for="name">Nome</label>
	                <input class="form-control" id="nome" name="name" type="text">
	                <div class="div-error">
	                  <div class="error"></div>
	                </div>
	              </div>
	            </div>
	            <div class="col-sm-6">
	              <div class="form-group">
	                <label for="surname">Cognome</label>
	                <input class="form-control" id="cognome" name="surname" type="text">
	                <div class="div-error">
	                  <div class="error"></div>
	                </div>
	              </div>
	            </div>
	          </div>
	          <div class="row">
	            <div class="col-sm-6">
	              <div class="form-group">
	                <label for="road">Via</label>
	                <input class="form-control" id="via" name="road" type="text">
	                <div class="div-error">
	                  <div class="error"></div>
	                </div>
	              </div>
	            </div>
	            <div class="col-sm-6">
	              <div class="form-group">
	                <label for="hnumber">Nr&#176; Civico</label>
	                <input class="form-control" id="ncivico" name="hnumber" type="text">
	                <div class="div-error">
	                  <div class="error"></div>
	                </div>
	              </div>
	            </div>
	          </div>
	         	<div class="row">
		          <div class="col-sm-6">
		             <div class="form-group">
		               <label for="city">Citt&#224;</label>
		               <input class="form-control" id="citta" name="city" type="text">
	                 <div class="div-error">
	                  <div class="error"></div>
	                </div>
		             </div>
		          </div>
		          <div class="col-sm-6">
		             <div class="form-group">
		               <label for="cap">CAP</label>
		               <input class="form-control" id="cap" name="cap" type="text">
	                 <div class="div-error">
	                  <div class="error"></div>
	                </div>
		             </div>
		          </div>
		        </div>
						<div class="row">
	            <div class="col-sm-6">
	              <div class="form-group">
	                <label for="province">Provincia</label>
	                <input class="form-control" id="provincia" name="province" type="text" placeholder="AA">
	                <div class="div-error">
	                  <div class="error"></div>
	                </div>
	              </div>
	            </div>
		          <div class="col-sm-6">
		            <div class="form-group">
	                <label for="tnumber">Nr&#176; di Telefono</label>
	                <input class="form-control" id="ntelefono" name="tnumber" type="text">
	                <div class="div-error">
	                  <div class="error"></div>
	                </div>
		            </div>
		          </div>
	          </div>
		       	<div class="form-group">
		          <label for="addInfo">Informazioni aggiuntive</label>
		          <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" placeholder="Piano, interno, ecc" style="resize: none;"></textarea>
		        </div>
		      </div>
		      <div class="card-footer">
		      	<input name="submit" type="submit" value="Invia" class="btn bg-cart float-right" id="addressSubmit">
		      </div>
	      </form>
	    </div>
	  </div>
  </div>
</div>
<script src="<%=path%>/assets/js/add_address.js"></script>
<%@include file="./include/footer.html"%>
<%@include file="./include/script.jsp"%>