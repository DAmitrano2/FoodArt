<%@include file="./include/header.jsp"%>
<%
	int idDealer = (int) request.getAttribute("idDealer");
	UserDAOImp modelUtente = new UserDAOImp();
	UserBean userDealer = modelUtente.doRetrieveById(idDealer);
	DealerDAOImp modelRivenditore = new DealerDAOImp();
	DealerBean dealer = modelRivenditore.doRetriveById(idDealer);
%>
<div class="container emp-profile">
	<div class="row">
    <div class="col-md-4">
      <div class="profile-img">
        <img src="./getUserImage?idUtente=<%=idDealer%>" alt="user.png">
      </div>
    </div>
    <div class="col-md-5">
      <div class="profile-head">
        <h3><%=dealer.getRagioneSociale() %></h3>
        <h6><%=userDealer.getNome() %> <%=userDealer.getCognome() %></h6>
        <h6><i class="fa-solid fa-location-dot"></i> <%=dealer.getViaSedeLegale() %> <%=dealer.getNumeroCivicoSedeLegale() %>, <%=dealer.getCittaSedeLegale() %>, <%=dealer.getProvinciaSedeLegale() %>, <%=dealer.getCapSedeLegale() %></h6>
      </div>
    </div>
	</div>
  <div class="row">
		<div class="col-md-4">
      <div class="profile-work">
        <h5>Informazioni</h5>
        <ul>
	        <%	
	        	ProductDAOImp modelProdotto = new ProductDAOImp();
	    			int numProduct = modelProdotto.getNumProductByIdUser(idDealer); 
	    		%>
          <li><i class="fa-solid fa-hashtag"></i> <%=numProduct %> prodotti</li>
          <li><i class="fa-solid fa-envelope"></i> <%=userDealer.getEmail() %></li>
        </ul>
        <!--%
        	FeedbackDAOImp modelFb = new FeedbackDAOImp();
	    		FeedbackBean fbTitle = modelFb.doRetriveBestFeedbackByUser(idDealer);
	    		if(fbTitle != null){
	    	%>
        <hr>
        
        <h5>Dicono di < %=dealer.getRagioneSociale() %></h5>
        < %
        	float rate = 0;
        	int c = 0;
	        
		    	Collection<FeedbackBean> feedback = modelFb.doRetriveByDealer(idDealer);
		    	if (feedback != null && feedback.size() != 0) {
						for(FeedbackBean fb: feedback) {
							rate += fb.getValutazione();
							c++;
						}
		    	}
		    	rate = rate / c;
				%>
        <div class="rating">
				 	< %
				 		if(rate>=1 && rate<2){				//1 stella%>
				    		<i class="fas fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i>
					   	< %}else if(rate>=2 && rate<3){		//2 stelle%>
				    		<i class="fas fa-star"></i><i class="fas fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i>
					   	< %}else if(rate>=3 && rate<4){		//3 stelle%>
				    		<i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i>
					   	< %}else if(rate>=4 && rate<5){		//4 stelle%>
				    		<i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="far fa-star"></i>
					   	< %}else if(rate==5){					//5 stelle%>
							<i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i>
		    	< % }%>
		    	</div>
	        <h6><a href=""><i class="fa-solid fa-quote-left"></i> < %=fbTitle.getTitolo() %></a><br/></h6>
	        < %} %-->
			</div>
		</div>
    <div class="col-md-8">
      <table class="table">
        <thead>
          <tr>
            <th colspan="15" scope="col">Prodotti</th>
          </tr>
        </thead>
        <tbody>
        	<% 
        		ProductDAOImp prodottoDao = new ProductDAOImp();
	   				Collection<ProductBean> prodotti = prodottoDao.getProductByIdUser(idDealer);
	   				if (prodotti != null && prodotti.size() != 0) {
	   					for(ProductBean product: prodotti) {%>
          <tr>
            <td><img src="./getProductImage?idProdotto=<%=product.getIdProdotto() %>" alt="imageProduct.png" class="img-fluid img-thumbnail" ></td>
			<td><%=product.getTitolo()%></td>
			<td><%=product.getPrezzo() %> &#8364; al <%=product.getUnitaMisura() %></td>
          </tr>
         	<%}} %>
        </tbody>
   		</table>
		</div>     
  </div>
</div>
<%@include file="./include/footer.html"%>
<%@include file="./include/script.jsp"%>