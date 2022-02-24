const responsive = {
    0:{
        items: 1
    },
    320: {
        items: 1
    },
    500:{
        items: 2
    },
    1024:{
        items: 3
    },
    1440:{
        items: 4
    }
}
$(document).ready(function(){
    // owl-carousel for category
    $('.owl-carousel').owlCarousel({
        items: 4,
        loop: true,
        autoplay: false,
        autoplayTimeout: 3000,
        dots: false,
        nav: true,
        navText: ['<i class="fa fa-angle-left"></i>','<i class="fa fa-angle-right"></i>'],
        responsive: responsive
    });
});

$(document).ready(function(){
	$("#btnSearchBar").click(function(){
		window.location.href='search_page?title='+$("#searchBar").val();
	});
	$("#searchBar").on('keypress', function(e) {
    if(e.which == 13) {
			window.location.href='search_page?title='+$("#searchBar").val();
		}
	});
});
