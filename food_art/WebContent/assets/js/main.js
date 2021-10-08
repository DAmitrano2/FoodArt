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
        navText: [$('.owl-navigation .owl-nav-prev'), $('.owl-navigation .owl-nav-next')],
        responsive: responsive
    });
});

/*var MainImg = document.getElementById('MainImg');
var smallImg = document.getElementsByClassName('small-img');
smallImg[0].onmouseover = function(){
    MainImg.src = smallImg[0].src;
}
smallImg[1].onmouseover = function(){
    MainImg.src = smallImg[1].src;
}
smallImg[2].onmouseover = function(){
    MainImg.src = smallImg[2].src;
}
smallImg[3].onmouseover = function(){
    MainImg.src = smallImg[3].src;
}*/

$("#btnSearchBar").click(function(){
	window.location.href='search_page?title='+$("#searchBar").val();
});

