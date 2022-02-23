$('#nav-search').click(e => {
	if($('.navbar .mainNavBar').css('display') == 'none'){
		$('.navbar .mainNavBar').css('display', 'flex');
	} else if($('.navbar .mainNavBar').css('display') == 'flex'){
		$('.navbar .mainNavBar').css('display', 'none');
	}
});