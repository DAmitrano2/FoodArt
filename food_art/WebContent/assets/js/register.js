var boolRivenditore = document.getElementById('rivenditore-check');
function toggle(){
	var tog = document.getElementById('rivenditore-form');
	if(boolRivenditore.checked){
		tog.style.display = 'block';
	}else{
		tog.style.display = 'none';
	}
}

const fPartitaIVA = document.getElementById('fPartitaIVA');
var boolPartitaIVA;
fPartitaIVA.addEventListener('change', (event) => {
  if(event.target.files[0] != undefined){
		boolPartitaIVA = true;
	}else {
		boolPartitaIVA = false;
	}
});

const fCartaIdentita = document.getElementById('fCartaIdentita');
var boolCartaIdentita;
fCartaIdentita.addEventListener('change', (event) => {
  if(event.target.files[0] != undefined){
		boolCartaIdentita = true;
	}else {
		boolCartaIdentita = false;
	}
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

const form = document.getElementById('form');
const nome = document.getElementById('nome');
const cognome = document.getElementById('cognome');
const email = document.getElementById('email');
const password = document.getElementById('password');
const data = document.getElementById('data');
const citta = document.getElementById('citta');
const provincia = document.getElementById('provincia');
const codiceFiscale = document.getElementById('codiceFiscale');
const ragioneSociale = document.getElementById('ragioneSociale');
const provinciaSedeLegale = document.getElementById('provinciaSedeLegale');
const cittaSedeLegale = document.getElementById('cittaSedeLegale');
const viaSedeLegale = document.getElementById('viaSedeLegale');
const capSedeLegale = document.getElementById('capSedeLegale');
const nCivicoSedeLegale = document.getElementById('nCivicoSedeLegale');
const nPartitaIVA = document.getElementById('nPartitaIVA');

form.addEventListener('submit', e => {
		if(!validateInputs()){
				e.preventDefault();
		}
});

const setError = (element, message) => {
    var errorDisplay = document.querySelector('#'+element.id+' + .div-error>.error');
		
		if(errorDisplay === null){
			errorDisplay = document.querySelector('#'+element.id+' + .div-error>.success');
		}
		
		errorDisplay.innerText = message;
    element.classList.add('error');
    element.classList.remove('success');
};

const setSuccess = element => {
    var errorDisplay = document.querySelector('#'+element.id+' + .div-error>.error')
		
    errorDisplay.innerText = '';
    element.classList.add('success');
    element.classList.remove('error');
};

const setErrorR = (element, message) => {
    var errorDisplay = document.querySelector('#'+element.id+'-error');
		
		errorDisplay.innerText = message;
    element.classList.add('error');
    element.classList.remove('success');
};

const setSuccessR = element => {
   	var errorDisplay = document.querySelector('#'+element.id+'-error');

    errorDisplay.innerText = '';
    element.classList.add('success');
    element.classList.remove('error');
};

const isValidEmail = email => {
    const re = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    return re.test(String(email).toLowerCase());
};

/** Farlo funzionare */
function isMaggiorenne(dateString) {
	var today = new Date();
	var birthDate = new Date(dateString);
	var age = today.getFullYear() - birthDate.getFullYear();
	var m = today.getMonth() - birthDate.getMonth();
	var d = today.getDay() - birthDate.getDay();
	if (age > 18 || (age == 18 && (m > 0 || (m == 0 && d >= 0 )))) {
		return true;
	}
	return false;
}

const validateInputs = () => {
		const nomeValue = nome.value.trim();
		const cognomeValue = cognome.value.trim();
		const emailValue = email.value.trim();
		const passwordValue = password.value.trim();
		const dataValue = data.value.trim();
		const cittaValue = citta.value.trim();
		const provinciaValue = provincia.value.trim();
		const codiceFiscaleValue = codiceFiscale.value.trim();
		const ragioneSocialeValue = ragioneSociale.value.trim();
		const provinciaSedeLegaleValue = provinciaSedeLegale.value.trim();
		const cittaSedeLegaleValue = cittaSedeLegale.value.trim();
		const viaSedeLegaleValue = viaSedeLegale.value.trim();
		const capSedeLegaleValue = capSedeLegale.value.trim();
		const nCivicoSedeLegaleValue = nCivicoSedeLegale.value.trim();
		const nPartitaIvaValue = nPartitaIVA.value.trim();
		var boolNome, boolCognome, boolEmail, boolPassword, boolData, boolCitta, boolProvincia, boolCodiceFiscale;
		var boolRagioneSociale, boolProvinciaSedeLegale, boolCittaSedeLegale, boolViaSedeLegale, boolCapSedeLegale;
		var boolNCivicoSedeLegale, boolNPartitaIva;
		
    if(nomeValue === '') {
				boolNome = false;
        setError(nome, '*Nome necessario');
    } else if(nomeValue.length > 25) {
				boolNome = false;
        setError(nome, '*Nome di lunghezza massima 25 caratteri');
    } else {
				boolNome = true;
        setSuccess(nome);
    }
		
		if(cognomeValue === '') {
        boolCognome = false;
				setError(cognome, '*Cognome necessario');
    } else if(cognomeValue.length > 25) {
				boolCognome = false;
        setError(cognome, '*Cognome di lunghezza massima 25 caratteri');
    } else {
				boolCognome = true;
        setSuccess(cognome);
    }

    if(emailValue === '') {
				boolEmail = false;
        setError(email, '*E-mail necessaria');
    } else if (!isValidEmail(emailValue)) {
				boolEmail = false;
        setError(email, '*Fornire un indirizzo email valido');
    } else {
				boolEmail = true;
        setSuccess(email);
    }

    if(passwordValue === '') {
				boolPassword = false;
        setError(password, '*Password necessaria');
    } else if (passwordValue.length < 8 ) {
				boolPassword = false;
        setError(password, '*La password deve contenere almeno 8 caratteri')
    } else if (passwordValue.length > 16 ) {
				boolPassword = false;
        setError(password, '*La password deve contenere massimo 25 caratteri')
    } else if (!passwordValue.match(/[a-z]/g)) {
				boolPassword = false;
        setError(password, '*La password deve contenere almeno una lettera minuscola');
    }	else if (!passwordValue.match(/[A-Z]/g)) {
				boolPassword = false;
        setError(password, '*La password deve contenere almeno una lettera maiuscola');
    }	else if (!passwordValue.match(/[0-9]/g)) {
				boolPassword = false;
        setError(password, '*La password deve contenere almeno un numero');
    }	else if (!passwordValue.match(/[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]/g)) {
				boolPassword = false;
        setError(password, '*La password deve contenere almeno un carattere speciale');
    } else {
				boolPassword = true;
        setSuccess(password);
    }
		
		if(boolRivenditore.checked){
				if(dataValue === '') {
						boolData = false;
	        	setErrorR(data, '*Data di nascita necessaria');
		    } else if (!isMaggiorenne(dataValue)) {
						console.log(isMaggiorenne(dataValue));
						boolData = false;
		        setErrorR(data, '*Devi essere maggiorenne');
		    } else {
						boolData = true;
		        setSuccessR(data);
		    }
				
				if(cittaValue === '') {
						boolCitta = false; 
  	     		setErrorR(citta, '*Città necessaria');
		    } else if (cittaValue.length > 45 ) {
						boolCitta = false;
		        setErrorR(citta, '*La città deve avere massimo 45 caratteri')
		    } else {
						boolCitta = true;
		        setSuccessR(citta);
		    }
				
				if(provinciaValue === '') {
						boolProvincia = false;
        		setErrorR(provincia, '*Provincia necessaria');
		    } else if ((provinciaValue.length > 2) || (provinciaValue.length < 2)) {
						boolProvincia = false;
		        setErrorR(provincia, '*La provincia sede legale deve essere di 2 caratteri')
		    } else {
						boolProvincia = true;
		        setSuccessR(provincia);
		    }

				if(codiceFiscaleValue === '') {
						boolCodiceFiscale = false;
        		setErrorR(codiceFiscale, '*Codice fiscale necessario');
		    } else if (codiceFiscaleValue.length > 16 ) {
						boolCodiceFiscale = false;
		        setErrorR(codiceFiscale, '*Il codice fiscale è lungo 16 caratteri')
		    } else {
						boolCodiceFiscale = true;
		        setSuccessR(codiceFiscale);
		    }

				if(ragioneSocialeValue === '') {
						boolRagioneSociale = false;
  	      	setErrorR(ragioneSociale, '*Ragione sociale necessaria');
		    } else if (ragioneSocialeValue.length > 45 ) {
						boolRagioneSociale = false;
		        setErrorR(ragioneSociale, '*La ragione sociale può avere massimo 45 caratteri')
		    } else {
						boolRagioneSociale = true;
		        setSuccessR(ragioneSociale);
		    }

				if(provinciaSedeLegaleValue === '') {
						boolProvinciaSedeLegale = false;
	        	setErrorR(provinciaSedeLegale, '*Provincia sede legale necessaria');
		    } else if ((provinciaSedeLegaleValue.length > 2) || (provinciaSedeLegaleValue.length < 2)) {
						boolProvinciaSedeLegale = false;
		        setErrorR(provinciaSedeLegale, '*La provincia sede legale deve essere di 2 caratteri')
		    } else {
						boolProvinciaSedeLegale = true;
		        setSuccessR(provinciaSedeLegale);
		    }

				if(cittaSedeLegaleValue === '') {
						boolCittaSedeLegale = false;
        		setErrorR(cittaSedeLegale, '*Citta sede legale necessaria');
		    } else if (cittaSedeLegaleValue.length > 45 ) {
						boolCittaSedeLegale = false;
		        setErrorR(cittaSedeLegale, '*La citta sede legale deve avere massimo 45 caratteri')
		    } else {
						boolCittaSedeLegale = true;
		        setSuccessR(cittaSedeLegale);
		    }
				
				if(viaSedeLegaleValue === '') {
						boolViaSedeLegale = false;
        		setErrorR(viaSedeLegale, '*Via sede legale necessario');
		    } else if (viaSedeLegaleValue.length > 25 ) {
						boolViaSedeLegale = false;
						setErrorR(viaSedeLegale, '*La via sede legale deve avere massimo 25 caratteri')
		    } else {
						boolViaSedeLegale = true;
		        setSuccessR(viaSedeLegale);
		    }

				if(capSedeLegaleValue === '') {
						boolCapSedeLegale = false;
        		setErrorR(capSedeLegale, '*Cap sede legale necessario');
		    } else if ((capSedeLegaleValue.length > 5) || (capSedeLegaleValue.length < 5)) {
						boolCapSedeLegale = false;
		        setErrorR(capSedeLegale, '*Il cap della sede legale deve essere di 5 caratteri')
		    } else {
						boolCapSedeLegale = true;
		        setSuccessR(capSedeLegale);
		    }

				if(nCivicoSedeLegaleValue === '') {
						boolNCivicoSedeLegale = false;
	        	setErrorR(nCivicoSedeLegale, '*Numero civico sede legale necessario');
		    } else if (nCivicoSedeLegaleValue.length > 7) {
						boolNCivicoSedeLegale = false;
		        setErrorR(nCivicoSedeLegale, '*Il numero civico della sede legale deve avere massimo caratteri')
		    } else {
						boolNCivicoSedeLegale = true;
		        setSuccessR(nCivicoSedeLegale);
		    }

				if(nPartitaIvaValue === '') {
						boolNPartitaIva = false;
        		setErrorR(nPartitaIVA, '*Numero di parita iva necessario');
		    } else if ((nPartitaIvaValue.length > 11) || (nPartitaIvaValue.length < 11)) {
						boolNPartitaIva = false;
		        setErrorR(nPartitaIVA, '*Numero di parita iva deve essere di 11 caratteri')
		    } else {
						boolNPartitaIva = true;
		        setSuccessR(nPartitaIVA);
		    }

				if(!boolPartitaIVA){
						setErrorR(fPartitaIVA, '*File della partita iva necessario');
				}else {
						setSuccessR(fPartitaIVA);
				}
				
				if(!boolCartaIdentita){
						setErrorR(fCartaIdentita, '*File della carta di identità necessario');
				}else {
						setSuccessR(fCartaIdentita);
				}
			
				if(boolNome && boolCognome && boolEmail && boolPassword && boolData && boolCitta && boolProvincia && boolCodiceFiscale && boolRagioneSociale && boolProvinciaSedeLegale && boolCittaSedeLegale && boolViaSedeLegale && boolCapSedeLegale && boolNCivicoSedeLegale && boolNPartitaIva && boolPartitaIVA && boolCartaIdentita){
					return true;
				}
		}
		if(boolNome && boolCognome && boolEmail && boolPassword){
			return true;
		}
};