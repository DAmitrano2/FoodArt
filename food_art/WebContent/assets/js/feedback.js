var data = document.querySelector('#rating-comment');
function oneStar() {
	data.setAttribute('data-value', 1);
	$('#rating-comment').html('<i class="fas fa-star" onclick="oneStar()"></i><i class="far fa-star" onclick="twoStar()"></i><i class="far fa-star" onclick="threeStar()"></i><i class="far fa-star" onclick="fourStar()"></i><i class="far fa-star" onclick="fiveStar()"></i>');
}
function twoStar() {
	data.setAttribute('data-value', 2);
	$('#rating-comment').html('<i class="fas fa-star" onclick="oneStar()"></i><i class="fas fa-star" onclick="twoStar()"></i><i class="far fa-star" onclick="threeStar()"></i><i class="far fa-star" onclick="fourStar()"></i><i class="far fa-star" onclick="fiveStar()"></i>');
}
function threeStar() {
	data.setAttribute('data-value', 3);
	$('#rating-comment').html('<i class="fas fa-star" onclick="oneStar()"></i><i class="fas fa-star" onclick="twoStar()"></i><i class="fas fa-star" onclick="threeStar()"></i><i class="far fa-star" onclick="fourStar()"></i><i class="far fa-star" onclick="fiveStar()"></i>');
}
function fourStar() {
	data.setAttribute('data-value', 4);
	$('#rating-comment').html('<i class="fas fa-star" onclick="oneStar()"></i><i class="fas fa-star" onclick="twoStar()"></i><i class="fas fa-star" onclick="threeStar()"></i><i class="fas fa-star" onclick="fourStar()"></i><i class="far fa-star" onclick="fiveStar()"></i>');
}	
function fiveStar() {
	data.setAttribute('data-value', 5);
	$('#rating-comment').html('<i class="fas fa-star" onclick="oneStar()"></i><i class="fas fa-star" onclick="twoStar()"></i><i class="fas fa-star" onclick="threeStar()"></i><i class="fas fa-star" onclick="fourStar()"></i><i class="fas fa-star" onclick="fiveStar()"></i>');
}
const stars = document.getElementById('rating-comment');
const titleReview = document.getElementById('title-comment');
const review = document.getElementById('textarea-comment');
const submitReview = document.getElementById('inviaFb');

submitReview.addEventListener('click', e =>{
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
	const starsValue = stars.getAttribute('data-value');
	const titleReviewValue = titleReview.value.trim();
	const reviewValue = review.value.trim();
	var boolStars, boolTitleReview, boolReview;

	if(starsValue!=''){
		boolStars = true;
		setSuccess(stars);
	} else {
		boolStars = false;
		setError(stars, '*Aggiungere una o più stelle');
	}

	if(titleReviewValue===''){
		boolTitleReview = false;
		setError(titleReview, '*Titolo richiesto*');
	} else if(titleReviewValue.length>50){
		boolTitleReview = false;
		setError(titleReview, '*Lunghezza massima raggiunta*');
	} else {
		boolTitleReview = true;
		setSuccess(titleReview);
	}

	if(reviewValue===''){
		boolReview = false;
		setError(review, '*Recensione necessaria*');
	} else if(reviewValue.length>8000){
		boolReview = false;
		setError(review, '*Lunghezza massima raggiunta*');
	} else {
		boolReview = true;
		setSuccess(review);
	}

	if(boolStars && boolTitleReview && boolReview){
		return true;
	}
}

$('document').ready(()=>{
	$('#inviaFb').click(()=>{
		var rating = $('#rating-comment').attr('data-value');
		var title = $('#title-comment').val();
		var comment = $('#textarea-comment').val();
		var idProd = $('#testimonial-id').attr('data-id-prod');
		var idUser = $('#testimonial-id').attr('data-id-user');
		if($('#rating-comment').attr('data-value')!=''){
			window.location.href='feedback?rating='+rating+'&title='+title+'&comment='+comment+'&idProd='+idProd+'&idUser='+idUser;
		}
	})
})