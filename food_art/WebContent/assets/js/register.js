function toggle(){
	var req=false;
	var tog = document.getElementById('rivenditore-form');
	if(document.getElementById('rivenditore-check').checked){
		tog.style.display = 'block';
		req=true;
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
	}else{
		tog.style.display = 'none';
		req=false;
	}
}

const fPartitaIVA = document.getElementById('fPartitaIVA');
fPartitaIVA.addEventListener('change', (event) => {
  console.log(event.target.files[0]);
});

const fCartaIdentita = document.getElementById('fCartaIdentita');
fCartaIdentita.addEventListener('change', (event) => {
  console.log(event.target.files[0]);
});

const inpFile = document.getElementById("fProfilo");
const previewContainer = document.getElementById("preview-image-box");
const previewDefault = previewContainer.querySelector(".preview-default");
inpFile.addEventListener("change", function(){
	const file = this.files[0];
	if(file){
		const reader = new FileReader();
		previewDefault.style.display = "none";
		reader.addEventListener("load", function(){
			previewContainer.style.backgroundImage = "url('"+this.result+"')";
		});
		reader.readAsDataURL(file);
	} else {
		previewDefault.style.display = null;
		previewContainer.style.backgroundImage = null;
	}
});