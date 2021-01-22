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