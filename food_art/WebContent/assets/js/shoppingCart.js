function addCart(action, id, page) {
	$.ajax({
	       type: "GET",
	       url: './cart?action='+action+'&idProdotto='+id+'&page='+page,
	       success: function(data)
	       {
	    	   	console.log("Aggiunto");
						var badge = $('span.badge-light')[0].innerHTML;
						var val = parseInt(badge)+1;
						$('span.badge-light')[0].innerHTML = val;
	       },
	       error: function(data, status) {
	    	   if( data.status === 400 ) {
	    		   var json = JSON.parse(data.responseJSON);
	    	   }
	       }
	   });
}

function setQuantityCart(action, id, page, e){
	$(e).find('.dropdown-item').on('click dblclick mouseenter mouseleave', function(){
		if(!$(e).find('.dropdown').hasClass('show')){
			window.location.href='cart?action='+action+'&idProdotto='+id+'&page='+page+'&quantita='+$(e).find('.filter-option-inner-inner').text();
		}
	});
}

function addQuantityCart(id, page){
	var quantita = $('.dropdown .btn').attr('title');
	if(quantita>0){
		window.location.href='cart?action=set&idProdotto='+id+'&page='+page+'&quantita='+quantita;
	}
}