package model.indirizzoConsegna;

public class IndirizzoConsegnaBean {

	private int idIndirizzoConsegna;
	private String nome;
	private String cognome;
	private String nTelefono;
	private String via;
	private String numeroCivico;
	private String citta;
	private String provincia;
	private String cap;
	private String descrizione;
	private int idUtente;
		
	public IndirizzoConsegnaBean() {
		this.idUtente = -1;
	}

	public int getIdIndirizzoConsegna() {
		return idIndirizzoConsegna;
	}

	public void setIdIndirizzoConsegna(int idIndirizzoConsegna) {
		this.idIndirizzoConsegna = idIndirizzoConsegna;
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

	public String getNumeroTelefono() {
		return nTelefono;
	}

	public void setNumeroTelefono(String nTelefono) {
		this.nTelefono = nTelefono;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getNumeroCivico() {
		return numeroCivico;
	}

	public void setNumeroCivico(String numeroCivico) {
		this.numeroCivico = numeroCivico;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}
}
