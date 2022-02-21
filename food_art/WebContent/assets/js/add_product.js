$("#image-picker").change(function(event) {
    readURL(this);
  });
  
  function readURL(input) {
    if (input.files && input.files[0]) {
      var reader = new FileReader();
  
      reader.onload = function(e) {
        $('#image-preview').attr('src', e.target.result);
      }
  
      reader.readAsDataURL(input.files[0]);
    }
  }

  const titolo = document.getElementById('productName');
  const prezzo = document.getElementById('price');
  const descrizione = document.getElementById('exampleFormControlTextarea1');
  const immagine = document.getElementById('image-picker')
  const submit = document.getElementById('productSub');
  
  submit.addEventListener('click', e =>{
    e.preventDefault();
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
  const titoloValue = titolo.value.trim();
  const prezzoValue = prezzo.value.trim();
  const descrizioneValue = descrizione.value.trim();
  const immagineValue = immagine.value.trim();
  var boolTitolo, boolPrezzo, boolDescrizione, boolImmagine;

  if(titoloValue===''){
    boolTitolo = false;
    setError(titolo, '*Titolo necessario');
  } else if(titoloValue.length>45){
    boolTitolo = false;
    setError(titolo, '*Lunghezza massima 45 caratteri');
  } else {
    boolTitolo = true;
    setSuccess(titolo);
  }

  if(prezzoValue===''){
    boolPrezzo = false;
    setError(prezzo, '*Prezzo necessario');
  } else if(!prezzoValue.match(/[0-9]/g)){
    boolPrezzo = false;
    setError(prezzo, '*Il prezzo può contenere solo un numero*');
  } else {
    boolPrezzo = true;
    setSuccess(prezzo);
  }

  if(descrizioneValue===''){
    boolDescrizione = false;
    setError(descrizione, '*Descrizione necessaria*');
  } else if(descrizioneValue.length>8000){
    boolDescrizione = false;
    setError(descrizione, '*Lunghezza massima raggiunta*');
  } else{
    boolDescrizione = true;
    setSuccess(descrizione);
  }

  if(immagineValue===''){
    boolImmagine = false;
    setError(immagine, '*Immagine necessaria*');
  } else {
    boolImmagine = true;
    setSuccess(immagine);
  }

  if(boolTitolo && boolPrezzo && boolDescrizione && boolImmagine){
    return true;
  }
}