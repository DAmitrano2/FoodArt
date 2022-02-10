$('.card:first').mouseenter(function(){
	$(this).css('background-color', '#f0f0f0');
	 $(this).css('cursor','pointer');
});
$('.card:first').mouseleave(function(){
	$(this).css('background-color', '#fff');
});
$('.card:first').click(function(){
	console.log('ciao');
	//window.location.href='dashboard_general?title='+$(this).find('.card-title').text();
});