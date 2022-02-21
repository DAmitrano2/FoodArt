$('document').ready(function() {
    $('#users').DataTable({
        responsive: true
    });
} );

$(document).ready(function() {
    $('#products').DataTable();
} );

function hideUsersList(){
    var x = document.getElementById("users");
    if(x.style.display==="none"){
        x.style.display="table";
    } else {
        x.style.display = "none";
    }
};

function hideProductsList(){
    var x = document.getElementById("products");
    if(x.style.display==="none"){
        x.style.display="table";
    } else {
        x.style.display = "none";
    }
};