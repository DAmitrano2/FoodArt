<%@include file="./include/header.jsp"%>
<div class="container">
	<div class="d-flex justify-content-center h-100">
		<div class="card">
			<div class="card-header">
				<h3>Accedi</h3>
			</div>
			<div class="card-body">
				<form action="login" method="post">
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-user"></i></span>
						</div>
						<input type="text" name="email" class="form-control" placeholder="e-mail" required>
					</div>
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-key"></i></span>
						</div>
						<input type="password" name="password" id="password" class="form-control" placeholder="password" required>
					</div>
					<div class="row align-items-center remember">
						<input type="checkbox" name="remember" id="remember-check">
						<label for="remember-check">Resta connesso.</label>
					</div>
						
					<div class="row align-items-center remember">
						  <input type="checkbox" onclick="showPassword()">
	                      <label for="Pass">Mostra Password</label>
					</div>
					<div class="form-group">
						<input type="submit" value="Accedi" class="btn float-right login_btn">
					</div>
				</form>
			</div>
			<div class="card-footer">
				<div class="d-flex justify-content-center links">
					Non hai un account?<a href="<%=path %>/register">Registrati</a>
				</div>
				<div class="d-flex justify-content-center">
					<a href="<%=path %>/recovery">Hai dimenticato la password?</a>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
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
</script>
<%@include file="./include/footer.html" %>
</body>
</html>