const form = document.getElementById('form');
const nome = document.getElementById('nome');
const cognome = document.getElementById('cognome');
const via = document.getElementById('via');
const ncivico = document.getElementById('ncivico');
const citta = document.getElementById('citta');
const cap = document.getElementById('cap');
const provincia = document.getElementById('provincia');
const ntelefono = document.getElementById('ntelefono');
const btnsub = document.getElementById('addressSubmit');

addressSubmit.addEventListener('click', e =>{
    if(!validateInputs()){
        e.preventDefault();
    }
});

const setError = (element, message) =>{
    var errorDisplay = document.querySelector('#'+element.id+' + .div-error>.error');
    if(errorDisplay === null){
        errorDisplay = document.querySelector('#'+element.id+' + .div-error>.success');
    }
    errorDisplay.innerText = message;
    element.classList.add('error');
    element.classList.remove('success');
};

const setSuccess = element =>{
    var errorDisplay = document.querySelector('#'+element.id+' + .div-error>.error');
    errorDisplay.innerText = ' ';
    element.classList.add('success');
    element.classList.remove('error');
};

const setErrorR = (element, message) =>{
    var errorDisplay = document.querySelector('#'+element.id+'-error');
    errorDisplay.innerText = message;
    element.classList.add('error');
    element.classList.remove('success');
};

const setSuccessR = element =>{
    var errorDisplay = document.querySelector('#'+element.id+'-error');
    errorDisplay.innerText = ' ';
    element.classList.add('success');
    element.classList.remove('error');
};

const validateInputs = () =>{
    const nomeValue = nome.value.trim();
    const cognomeValue = cognome.value.trim();
    const viaValue = via.value.trim();
    const nCivicoValue = ncivico.value.trim();
    const cittaValue = citta.value.trim();
    const capValue = cap.value.trim();
    const provinciaValue = provincia.value.trim();
    const nTelefonoValue = ntelefono.value.trim();
    var boolNome, boolCognome, boolVia, boolNcivico, boolCitta, boolCap, boolProvincia, boolNtelefono;

    if(nomeValue===''){
        boolNome = false;
        setError(nome, '*Nome necessario*');
    } else if(nomeValue.lenght>25){
        boolNome = false;
        setError(nome, '*Lunghezza massima 25 caratteri');
    } else if(nomeValue.match(/[0-9]/g)){
        boolNome = false;
        setError(nome, '*Il nome non può contenere numeri*');
    } else {
        boolNome = true;
        setSuccess(nome);
    }

    if(cognomeValue===''){
        boolCognome = false;
        setError(cognome, '*Cognome necessario*');
    } else if(cognomeValue.lenght>25){
        boolCognome = false;
        setError(cognome, '*Lunghezza massima 25 caratteri');
    } else if(cognomeValue.match(/[0-9]/g)){
        boolNome = false;
        setError(cognome, '*Il cognome non può contenere numeri*');
    } else {
        boolCognome = true;
        setSuccess(cognome);
    }

    if(viaValue===''){
        boolVia = false;
        setError(via, '*Via necessaria*');
    } else if(viaValue.lenght>45){
        boolVia = false;
        setError(via, '*Lunghezza massima 45 caratteri*');
    } else if(viaValue.match(/[0-9]/g)){
        boolVia = false;
        setError(via, '*La via non può contenere numeri*');
    } else {
        boolVia = true;
        setSuccess(via);
    }

    if(nCivicoValue===''){
        boolNcivico = false;
        setError(ncivico, '*Numero civico necessario');
    } else if(!nCivicoValue.match(/[0-9]/g)){
        boolNcivico = false;
        setError(ncivico, '*Il numero civico può contenere solo numeri');
    } else {
        boolNcivico = true;
        setSuccess(ncivico);
    }

    if(cittaValue===''){
        boolCitta = false;
        setError(citta, '*Città necessaria*');
    } else if(cittaValue.lenght>45){
        boolCitta = false;
        setError(citta, '*Lunghezza massima 45 caratteri*');
    } else if(cittaValue.match(/[0-9]/g)){
        boolCitta = false;
        setError(citta, '*La città non può contenere numeri*');
    } else {
        boolCitta = true;
        setSuccess(citta);
    }

    if(capValue===''){
        boolCap = false;
        setError(cap, '*CAP necessario*');
    } else if((capValue.match(/[a-z]/g)) || (capValue.match(/[A-Z]/g))){
        boolCap = false;
        setError(cap, '*Il CAP deve contenere solo numeri*');
    } else if((capValue.length>5) || (capValue.length<5)){
        boolCap = false;
        setError(cap, '*La lunghezza del CAP è di 5 cifre*');
    } else {
        boolCap = true;
        setSuccess(cap);
    }

    if(provinciaValue===''){
        boolProvincia = false;
        setError(provincia, '*Provincia necessaria*');
    } else if((provinciaValue.length>2) || (provinciaValue.length<2)){
        boolProvincia = false;
        setError(provincia, '*La provincia deve essere in formato AA*');
    } else if(provinciaValue.match(/[0-9]/g)){
        boolProvincia = false;
        setError(provincia, '*La provincia deve contenere solo lettere*');
    } else if(provinciaValue.match(/[a-z]/g)){
        boolProvincia = false;
        setError(provincia, '*La provincia deve essere scritta in maiuscolo');
    } else {
        boolProvincia = true;
        setSuccess(provincia);
    }

    if(nTelefonoValue===''){
        boolNtelefono = false;
        setError(ntelefono, '*Numero di telefono necessario*');
    } else if((nTelefonoValue.match(/[a-z]/g)) || (nTelefonoValue.match(/[A-Z]/g))){
        boolNtelefono = false;
        setError(ntelefono, '*Il numero di telefono deve contenere solo numeri*');
    } else if((nTelefonoValue.length>11) || (nTelefonoValue.length<7)){
        boolNtelefono = false;
        setError(ntelefono, '*La lunghezza deve essere compresa tra 7 e 11 cifre*');
    } else {
        boolNtelefono = true;
        setSuccess(ntelefono);
    }

    if(boolNome && boolCognome && boolVia && boolNcivico && boolCitta && boolCap && boolProvincia && boolNtelefono){
        return true;
    }


};