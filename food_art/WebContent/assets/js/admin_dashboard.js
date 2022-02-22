$('document').ready(function() {
    $('#dealers').DataTable();
} );

$(document).ready(function() {
    $('#products').DataTable();
} );

$(document).ready(function() {
    $('#feednìback').DataTable();
} );

var products = document.getElementById("products");
var dealers = document.getElementById("dealers");
var fb = document.getElementById("feedback");

function hideDealersList(){
    if(dealers.style.display==="none"){
        dealers.style.display = "table";
				products.style.display = "none";
				fb.style.display = "none";
    } else {
        dealers.style.display = "none";
    }
};

function hideProductsList(){
    if(products.style.display==="none"){
        products.style.display = "table";
				dealers.style.display = "none";
				fb.style.display = "none";
    } else {
        products.style.display = "none";
    }
};

function hideFeedbackList(){
    if(fb.style.display==="none"){
        fb.style.display = "table";
				dealers.style.display = "none";
				products.style.display = "none";
    } else {
        fb.style.display = "none";
    }
};