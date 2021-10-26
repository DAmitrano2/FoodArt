$(document).ready(function() {
    $('#form_login').on("submit", function(e) {
      e.preventDefault();
      $.ajax({
         type: "POST",
         url: './login',
         data: $(this).serialize(),
         context: this,
         success: function(data) {
             this.submit();
         },
         error: function(data, status) {
             if( data.status === 401 ) {
                 var json = JSON.parse(data.responseJSON);
                 $('#errorAlert').html( json.message );
                 $('#alert').show();
                 //Reset form
                 $('#username').val('');
                 $('#password').val('');
             }
         }
     });
      return false;
   });
});

//Show password

function showPassword() {
var pass = document.getElementById("password");
if (pass.type == "password") {
  pass.type = "text";
} else {
  pass.type = "password";
}

}