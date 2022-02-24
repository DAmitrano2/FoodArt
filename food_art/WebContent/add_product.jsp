<%@include file="./include/header.jsp"%>
	<div class="container">
		<nav aria-label="breadcrumb">
		  <ol class="breadcrumb">
		    <li class="breadcrumb-item"><a href="<%=path%>/dashboard">Il mio account</a></li>
		    <li class="breadcrumb-item"><a href="<%=path%>/dashboard/dashboard_general?title=I miei prodotti">I miei prodotti</a></li>
		    <li class="breadcrumb-item active" aria-current="page">Aggiunta prodotto</li>
		  </ol>
		</nav>
   <div class="d-flex justify-content-center">
      <div class="col-sm-6">
        <div class="card" id="product-card">
         <div class="card-header py-3">
            <strong>Inserisci un nuovo prodotto</strong>
         </div>
         <form id="form" action="add_product" method="post">
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
            <div class="row justify-content-center">
              <label for="image-picker">
                <img class="img-fluid" id="image-preview" src="<%=path%>/assets/images/default-background.jpg" alt="your image" />
              </label>
              <input id="image-picker" type="file" name="fProduct" accept="image/*" />
              <div class="div-error">
                <div class="error"></div>
              </div>
            </div>
            <div class="row">
             <div class="col-sm-12">
                <div class="form-group">
                  <label for="name">Titolo</label>
                  <input class="form-control" id="productName" name="title" type="text">
                  <div class="div-error">
                    <div class="error"></div>
                  </div>
                </div>
             </div>
            </div>
            <div class="row">
              <div class="col-sm-12">
                <div class="form-group">
                  <label for="name">Categoria</label>
                  <select name="category" class="form-control" id="category">
                    <option id="categoryOption" value="1">Carne</option>
                    <option id="categoryOption" value="2">Pesce</option>
                    <option id="categoryOption" value="3">Cereali e Derivate</option>
                    <option id="categoryOption" value="4">Latte, Derivati e Uova</option>
                    <option id="categoryOption" value="5">Pasticceria</option>
                    <option id="categoryOption" value="6">Frutta e Verdura</option>
                    <option id="categoryOption" value="7">Bevande</option>
                    <option id="categoryOption" value="8">Conserve</option>
                    <option id="categoryOption" value="9">Condimenti</option>
                  </select>
                </div>
              </div>
            </div>
            <div class="form-group">
             <label for="addInfo">Descrizione</label>
             <textarea class="form-control" name="feedback" id="exampleFormControlTextarea1" rows="3" placeholder="Una breve descrizione del prodotto" style="resize: none;"></textarea>
             <div class="div-error">
               <div class="error"></div>
             </div>
            </div>
            <div class="row">
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="cap">Prezzo</label>
                  <input class="form-control" id="price" name="price" type="text" placeholder="&#8364;">
                  <div class="div-error">
                    <div class="error"></div>
                  </div>
                </div>
              </div>
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="city">Unit&#224; di misura</label>
                  <select name="unmeasure" class="form-control" id="unmeasure">
                    <option id="unmeasureOption" value="pz">Pezzo</option>
                    <option id="unmeasureOption" value="kg">Litro</option>
                    <option id="unmeasureOption" value="lt">Chilo</option>
                  </select>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="province">Quantit&#224;</label>
                  <input class="form-control" name="qtymin" type="number" value="1" min="1">
                </div>
              </div>
              <div class="col-sm-6">
                <div class="form-group">
                  <label for="tnumber">Quantit&#224; minima di acquisto</label>
                  <input class="form-control" name="qtydisp" type="number" value="1" min="1">
                </div>
              </div>
            </div>
				</div>
				<div class="card-footer">
	      	<input name="submit" type="submit" value="Invia" class="btn bg-cart float-right" id="productSub">
	      </div>
			</form>
        </div>
      </div>
    </div>
	</div>
	<%@include file="./include/footer.html"%>
	<%@include file="./include/script.jsp"%>
  <script src="<%=path%>/assets/js/add_product.js"></script>
</body>
</html>