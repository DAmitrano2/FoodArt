<%@include file="./include/header.jsp"%>
<div class="container">
	<div class="d-flex justify-content-center h-100">
		<div class="card">
			<div class="card-header">
				<h3>Accedi</h3>
				<!-- <div class="d-flex justify-content-end social_icon"> //accesso tramite social non attivo
					<span><i class="fab fa-facebook-square"></i></span>
					<span><i class="fab fa-google-plus-square"></i></span>
					<span><i class="fab fa-twitter-square"></i></span>
				</div> -->
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
						<label class="checkbox-container">Resta connesso.
							<input type="checkbox" checked="checked">
							<span class="checkmark"></span>
						</label>
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
<%@include file="./include/footer.html" %>
<%@include file="./include/script.html" %>
</body>
</html>