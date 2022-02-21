$('.card').mouseenter(function(){
	$(this).css('background-color', '#e9e9e9');
	 $(this).css('cursor','pointer');
});
$('.card').mouseleave(function(){
	$(this).css('background-color', '#fff');
});
$('.card').click(function(){
	if($(this).find('.card-title').text()!='I miei ordini')
	window.location.href='/FoodArt/dashboard/dashboard_general?title='+$(this).find('.card-title').text();
});
function my_orders(){
	window.location.href='/FoodArt/dashboard/my_orders';
}