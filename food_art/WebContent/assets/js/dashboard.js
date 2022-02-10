$('.card').mouseenter(function(){
	$(this).css('background-color', '#e9e9e9');
	 $(this).css('cursor','pointer');
});
$('.card').mouseleave(function(){
	$(this).css('background-color', '#fff');
});
$('.card').click(function(){
	window.location.href='dashboard_general?title='+$(this).find('.card-title').text();
});