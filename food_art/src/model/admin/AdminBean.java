package model.admin;

public class AdminBean {

	private int idUtente;
	private String ruolo;
	
	public AdminBean() {
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
