<%@include file="./include/header.jsp"%>
<div class="container">
	<div class="d-flex justify-content-center h-100">
		<div class="card">
			<div class="card-header">
				<h3>Registrati</h3>
			</div>
			<div class="card-body">
				<form>
				<!-- user -->
					<div class="input-group form-group">
						<input name="nome" type="text" class="form-control" placeholder="nome">
					</div>
					<div class="input-group form-group">
						<input name="congnome" type="text" class="form-control" placeholder="congnome">
					</div>
					<div class="input-group form-group">
						<input name="email" type="text" class="form-control" placeholder="e-mail">
					</div>
					<div class="input-group form-group">
						<input name="password" type="password" class="form-control" placeholder="password">
					</div>
				<!-- rivenditore -->
					<div class="input-group form-group">
						<input name="data" type="date" min="1900-01-01" max="<%=new java.sql.Date(System.currentTimeMillis())%>" class="form-control">
					</div>
					<div class="input-group form-group">
						<input name="citta" type="text" class="form-control" placeholder="citt&#224;">
					</div>
					<div class="input-group form-group">
						<input name="provincia" type="text" class="form-control" placeholder="provincia">
					</div>
					<div class="input-group form-group">
						<select name="sesso" class="form-control" id="sesso">
							<option value="m">Maschio</option>
							<option value="f">Femmina</option>
						</select>
					</div>
					<div class="input-group form-group">
						<input name="codiceFiscale" type="text" maxlength="16" minlength="16" class="form-control" placeholder="codice fiscale">
					</div>
					<div class="input-group form-group">
						<input name="nPartitaIVA" type="text" maxlength="11" minlength="11" class="form-control" placeholder="partita IVA">
					</div>
					<div class="input-group form-group">
						<input name="fPartitaIVA" type="file" accept=".pdf">
					</div>
					<div class="input-group form-group">
						<input name="fCartaIdentita" type="file" accept="image/*">
					</div>
					<div class="input-group form-group">
						<input name="ragioneSociale" type="text" class="form-control" placeholder="ragione sociale">
					</div>
					<div class="input-group form-group">
						<input name="provinciaSedeLegale" type="text" class="form-control" placeholder="provincia sede legale">
					</div>
					<div class="input-group form-group">
						<input name="cittaSedeLegale" type="text" class="form-control" placeholder="citt&#224; sede legale">
					</div>
					<div class="input-group form-group">
						<input name="viaSedeLegale" type="text" class="form-control" placeholder="via sede legale">
					</div>
					<div class="input-group form-group">
						<input name="capSedeLegale" type="text" class="form-control" placeholder="cap sede legale">
					</div>
					<div class="input-group form-group">
						<input name="nCivicoSedeLegale" type="text" class="form-control" placeholder="numero civico sede legale">
					</div>
					
					<div class="form-group">
						<input name="submit" type="submit" value="Registrati" class="btn float-right login_btn">
					</div>
					
					<div class="form-group">
						<input type="submit" value="Registrati" class="btn float-right login_btn">
					</div>
				</form>
			</div>
			<div class="card-footer">
				<div class="d-flex justify-content-center links">
					Hai gi� un account?<a href="<%=path %>/login">Accedi</a>
				</div>
			</div>
		</div>
	</div>
</div>
<%@include file="./include/footer.html" %>
<%@include file="./include/script.html" %>
</body>
</html>