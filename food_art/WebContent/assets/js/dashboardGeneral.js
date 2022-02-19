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
		console.log(window.location.href);
		window.location.href='dashboard_general/add_address';
	});
}else if($('.title')[0].innerText == 'I miei pagamenti'){
	$('.first-card').click(function(){
		console.log(window.location.href);
		window.location.href='dashboard_general/add_credit_card';
	});
}