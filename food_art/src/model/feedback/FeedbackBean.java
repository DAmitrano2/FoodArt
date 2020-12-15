package model.feedback;

public class FeedbackBean {

	private int idFeedback;
	private String titolo;
	private String commento;
	private float valutazione;
	private int idCommentatore; //utente(anche rivanditore e amministratore)
	private int idProdotto;
	private int idRivenditore;
		
	public FeedbackBean() {
		this.idFeedback = -1;
	}

	public int getIdFeedback() {
		return idFeedback;
	}



	public void setIdFeedback(int idFeedback) {
		this.idFeedback = idFeedback;
	}



	public String getTitolo() {
		return titolo;
	}



	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}



	public String getCommento() {
		return commento;
	}



	public void setCommento(String commento) {
		this.commento = commento;
	}



	public float getValutazione() {
		return valutazione;
	}



	public void setValutazione(float valutazione) {
		this.valutazione = valutazione;
	}



	public int getIdCommentatore() {
		return idCommentatore;
	}



	public void setIdCommentatore(int idCommentatore) {
		this.idCommentatore = idCommentatore;
	}



	public int getIdProdotto() {
		return idProdotto;
	}



	public void setIdProdotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}



	public int getIdRivenditore() {
		return idRivenditore;
	}



	public void setIdRivenditore(int idRivenditore) {
		this.idRivenditore = idRivenditore;
	}
}
