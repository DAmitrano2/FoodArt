package model.utente;

public class UtenteBean {

	private int idUtente;
	private String nome;
	private String cognome;
	private String email;
	private String password;
	private boolean amministratore;
	private boolean rivenditore;
	private boolean bloccato;
	
	public UtenteBean() {
		this.idUtente = -1;
	}
	
	public int getIdUtente() {
		return idUtente;
	}


	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isAmministratore() {
		return amministratore;
	}


	public void setAmministratore(boolean amministratore) {
		this.amministratore = amministratore;
	}


	public boolean isRivenditore() {
		return rivenditore;
	}


	public void setRivenditore(boolean rivenditore) {
		this.rivenditore = rivenditore;
	}

	public boolean isBloccato() {
		return bloccato;
	}


	public void setBloccato(boolean bloccato) {
		this.rivenditore = bloccato;
	}

}
