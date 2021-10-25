var address = 0;
var card = 0;
function setAddress(ad){
	address = ad;
}
function setCard(cd){
	card = cd;
}
function enter(){
	if(address != 0 && card != 0){
		window.location.href='complete_order?address='+address+'&card='+card;
	}else if(address == 0 && card != 0){
		alert("Seleziona l'indirizzo di consegna.");
	}else if(card == 0 && address != 0){
		alert("Seleziona la carta di credito.");
	}else {
		alert("Seleziona l'indirizzo di consegna e la carta di credito.");
	}
}