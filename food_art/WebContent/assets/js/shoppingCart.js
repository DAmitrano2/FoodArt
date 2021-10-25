function addCart(action, id, page) {
	window.location.href='cart?action='+action+'&idProdotto='+id+'&page='+page;
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