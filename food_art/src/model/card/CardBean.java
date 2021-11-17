package model.card;

import java.sql.Date;

public class CardBean {

	private String nCarta;
	private String intestatario;
	private Date dataScadenza;
	private String cvv;
	private int idUtente;
	
	public CardBean() {
		this.nCarta = "0000000000000000";
	}

	public String getNumeroCarta(int n) {
		return nCarta.substring(nCarta.length()-n, nCarta.length());
	}
	
	public String getNumeroCarta() {
		return nCarta;
	}

	public void setNumeroCarta(String nCarta) {
		this.nCarta = nCarta;
	}

	public String getIntestatario() {
		return intestatario;
	}

	public void setIntestatario(String intestatario) {
		this.intestatario = intestatario;
	}

	public Date getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public int getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}
}
