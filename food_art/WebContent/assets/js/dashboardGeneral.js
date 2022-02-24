$('.card:first').mouseenter(function(){
	$(this).css('background-color', '#f0f0f0');
	 $(this).css('cursor','pointer');
});
$('.card:first').mouseleave(function(){
	$(this).css('background-color', '#fff');
});
$('.card:first').click(function(){
	//window.location.href='dashboard_general?title='+$(this).find('.card-title').text();
});
if($('.title')[0].innerText == 'Indirizzi'){
	$('.first-card').click(function(){
		window.location.href='dashboard_general/add_address';
	});
}else if($('.title')[0].innerText == 'I miei pagamenti'){
	$('.first-card').click(function(){
		window.location.href='dashboard_general/add_credit_card';
	});
}else if($('.title')[0].innerText == 'I miei prodotti'){
	$('.first-card').click(function(){
		window.location.href='dashboard_general/add_product';
	});
}
function remove(title, action, id) {
	$.ajax({
	       type: "GET",
	       url: './dashboard_general?title='+title+'&action='+action+'&id='+id,
	       success: function(data)
	       {
	    	   	if(title === "Indirizzi"){
							$('#address'+id).remove();
						}else if(title === "I miei pagamenti"){
							$('#card'+id).remove();
						}else if(title === "I miei prodotti"){
							$('#product'+id).remove();
						}
	       },
	       error: function(data, status) {
	    	   if( data.status === 400 ) {
	    		   var json = JSON.parse(data.responseJSON);
	    	   }
	       }
	   });
}