<%@include file="./include/header.jsp"%>
<div class="container">
	<div class="d-flex justify-content-center h-100">
		<div class="card">
			<div class="card-header">
				<h3>Accedi</h3>
			</div>
			<div class="card-body">
				<form>
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-user"></i></span>
						</div>
						<input type="text" class="form-control" placeholder="e-mail">
					</div>
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-key"></i></span>
						</div>
						<input type="password" class="form-control" placeholder="password">
					</div>
					<div class="row align-items-center remember">
						<input type="checkbox">Resta connesso.
					</div>
					<div class="form-group">
						<input type="submit" value="Accedi" class="btn float-right login_btn">
					</div>
				</form>
			</div>
			<div class="card-footer">
				<div class="d-flex justify-content-center links">
					Non hai un account?<a href="#">Registrati</a>
				</div>
				<div class="d-flex justify-content-center">
					<a href="#">Hai dimenticato la password?</a>
				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="./include/footer.html" %>
<%@include file="./include/script.html" %>
</body>
</html>