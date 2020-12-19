package model.amministratore;

public class AmministratoreBean {

	private int idUtente; //commento
	private String ruolo;
	
	public AmministratoreBean() {
		this.idUtente = -1;
	}

	public int getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
}
