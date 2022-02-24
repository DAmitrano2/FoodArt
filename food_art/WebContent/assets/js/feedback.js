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

$('document').ready(()=>{
	$('button[type="button"]').click(()=>{
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