<%@include file="./include/header.jsp"%>
<div class="container">
	<div class="d-flex justify-content-center h-100">
		<div class="card">
			<div class="card-header">
				<h3>Registrati</h3>
			</div>
			<div class="card-body">
				<form action="register" method="post" enctype="multipart/form-data">
				<!-- user -->
					<div class="input-group form-group">
						<input name="nome" type="text" class="form-control" placeholder="nome" required>
						<input name="cognome" type="text" class="form-control" placeholder="cognome" required>
					</div>
					<div class="input-group form-group">
						<input name="email" type="text" class="form-control" placeholder="e-mail" required>
						<input name="password" type="password" class="form-control" placeholder="password" required>
					</div>
					<div class="row align-items-center remember">
						<input name="rivenditore" type="checkbox" value="rivenditore-check" id="rivenditore-check" onclick="toggle()">
						<label for="rivenditore-check">Registrarti come rivenditore.</label>
					</div>
				<!-- rivenditore -->
				<div id="rivenditore-form" style="display: none;">
					<div class="card-header-sm">
						<h4>Dati Anagrafici</h4>
					</div>
					<div class="input-group form-group">
						<input name="data" id="data" type="date" min="1900-01-01" max="<%=new java.sql.Date(System.currentTimeMillis())%>" class="form-control">
						<select name="sesso" class="form-control" id="sesso">
							<option value="maschio">Maschio</option>
							<option value="femmina">Femmina</option>
						</select>
					</div>
					<div class="input-group form-group">
						<input name="citta" id="citta" type="text" class="form-control" placeholder="citt&#224;" >
						<input name="provincia" type="text" class="form-control" placeholder="provincia">
					</div>
					<div class="input-group form-group">
						<input name="codiceFiscale" id="codiceFiscale" type="text" maxlength="16" minlength="16" class="form-control" placeholder="codice fiscale">
					</div>
					
					<div class="card-header-sm">
						<h4>Sede Legale</h4>
					</div>
					<div class="input-group form-group">
						<input name="ragioneSociale" id="ragioneSociale" type="text" class="form-control" placeholder="ragione sociale" >
						<input name="provinciaSedeLegale" id="provinciaSedeLegale" type="text" class="form-control" placeholder="provincia">
					</div>
					<div class="input-group form-group">
						<input name="cittaSedeLegale" id="cittaSedeLegale" type="text" class="form-control" placeholder="citt&#224;">
						<input name="viaSedeLegale" id="viaSedeLegale" type="text" class="form-control" placeholder="via">
					</div>
					<div class="input-group form-group">
						<input name="capSedeLegale" id="capSedeLegale" maxlength="5" minlength="5" type="text" class="form-control" placeholder="cap">
						<input name="nCivicoSedeLegale" id="nCivicoSedeLegale" type="text" class="form-control" placeholder="numero civico">
					</div>
					<div class="input-group form-group">
						<input name="nPartitaIVA" id="nPartitaIva" type="text" maxlength="11" minlength="11" class="form-control" placeholder="partita IVA">
					</div>
					<div class="input-group form-group">
						<label for="fPartitaIVA" class="custom-file-upload form-control">
						    <i class="fa fa-cloud-upload"></i> Inserisci la partita iva
						</label>
						<input name="fPartitaIVA" type="file" class="form-control" accept=".pdf" id="fPartitaIVA" />
						<input name="fCartaIdentita" type="file" class="form-control" accept=".jpg, .jpeg, .png" id="fCartaIdentita"/>					
						<label for="fCartaIdentita" class="custom-file-upload form-control">
						    <i class="fa fa-cloud-upload"></i> Inserisci la carta di identit&#224;
						</label>
					</div>
					
				</div>
					
					<div class="form-group">
						<input name="submit" type="submit" value="Registrati" class="btn float-right login_btn">
					</div>
				</form>
			</div>
			<div class="card-footer">
				<div class="d-flex justify-content-center links">
					Hai gi&#224; un account?<a href="<%=path %>/login">Accedi</a>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
function toggle(){
	var req=false;
	var tog = document.getElementById('rivenditore-form');
	if(document.getElementById('rivenditore-check').checked){
		tog.style.display = 'block';
		req=true;
	}else{
		tog.style.display = 'none';
		req=false;
	}
	document.getElementById('data').required=req;
	document.getElementById('citta').required=req;
	document.getElementById('codiceFiscale').required=req;
	document.getElementById('ragioneSociale').required=req;
	document.getElementById('provinciaSedeLegale').required=req;
	document.getElementById('cittaSedeLegale').required=req;
	document.getElementById('viaSedeLegale').required=req;
	document.getElementById('capSedeLegale').required=req;
	document.getElementById('nCivicoSedeLegale').required=req;
	document.getElementById('nPartitaIva').required=req;
	document.getElementById('fPartitaIVA').required=req;
	document.getElementById('fCartaIdentita').required=req;
}
</script>
<%@include file="./include/footer.html" %>
<%@include file="./include/script.html" %>
</body>
</html>