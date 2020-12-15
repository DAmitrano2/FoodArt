package model.rivenditore;

import java.sql.Date;

public class RivenditoreBean {

	private int idUtente;
	private Date dataNascita;
	private String citta;
	private String provincia;
	private String sesso;
	private String codiceFiscale;
	private String numeroPartitaIva;
	private String filePartitaIva;
	private String fileDocumentoIdentita;
	private String ragioneSociale;
	private String provinciaSedeLegale;
	private String cittaSedeLegale;
	private String viaSedeLegale;
	private String numeroCivicoSedeLegale;
	private String capSedeLegale;
	
	public RivenditoreBean() {
		this.idUtente = -1;
	}
	
	public int getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
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

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getNumeroPartitaIva() {
		return numeroPartitaIva;
	}

	public void setNumeroPartitaIva(String numeroPartitaIva) {
		this.numeroPartitaIva = numeroPartitaIva;
	}

	public String getFilePartitaIva() {
		return filePartitaIva;
	}

	public void setFilePartitaIva(String filePartitaIva) {
		this.filePartitaIva = filePartitaIva;
	}

	public String getFileDocumentoIdentita() {
		return fileDocumentoIdentita;
	}

	public void setFileDocumentoIdentita(String fileDocumentoIdentita) {
		this.fileDocumentoIdentita = fileDocumentoIdentita;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public String getProvinciaSedeLegale() {
		return provinciaSedeLegale;
	}

	public void setProvinciaSedeLegale(String provinciaSedeLegale) {
		this.provinciaSedeLegale = provinciaSedeLegale;
	}

	public String getCittaSedeLegale() {
		return cittaSedeLegale;
	}

	public void setCittaSedeLegale(String cittaSedeLegale) {
		this.cittaSedeLegale = cittaSedeLegale;
	}

	public String getViaSedeLegale() {
		return viaSedeLegale;
	}

	public void setViaSedeLegale(String viaSedeLegale) {
		this.viaSedeLegale = viaSedeLegale;
	}

	public String getNumeroCivicoSedeLegale() {
		return numeroCivicoSedeLegale;
	}

	public void setNumeroCivicoSedeLegale(String numeroCivicoSedeLegale) {
		this.numeroCivicoSedeLegale = numeroCivicoSedeLegale;
	}

	public String getCapSedeLegale() {
		return capSedeLegale;
	}

	public void setCapSedeLegale(String capSedeLegale) {
		this.capSedeLegale = capSedeLegale;
	}


}
