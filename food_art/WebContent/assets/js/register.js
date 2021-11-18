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
const previewContainer = document.getElementById("image-preview");
const previewImage = previewContainer.querySelector(".image-preview-image");
const previewDefaultText = previewContainer.querySelector(".image-preview-default-text");
inpFile.addEventListener("change", function(){
	const file = this.files[0];
	if(file){
		const reader = new FileReader();
		previewDefaultText.style.display = "none";
		previewImage.style.display = "block";
		reader.addEventListener("load", function(){
			previewImage.setAttribute("src", this.result);
		});
		reader.readAsDataURL(file);
	} else {
		previewDefaultText.style.display = null;
		previewImage.style.display = null;
		previewImage.setAttribute("src", "");
	}
});