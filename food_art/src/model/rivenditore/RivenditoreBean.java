package model.rivenditore;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;


public class RivenditoreBean {

	private int idUtente;
	private Date dataNascita;
	private String citta;
	private String provincia;
	private String sesso;
	private String codiceFiscale;
	private String numeroPartitaIva;
	private byte[] filePartitaIva;
	private byte[] fileDocumentoIdentita;
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

	public void setSesso(String string) {
		this.sesso = string;
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

	public byte[] getFilePartitaIva() {
		return filePartitaIva;
	}

	public void setFilePartitaIva(byte[] inputStream) {
		this.filePartitaIva = inputStream;
	}

	public byte[] getFileDocumentoIdentita() {
		return fileDocumentoIdentita;
	}

	public void setFileDocumentoIdentita(byte[] fileDocumentoIdentita) {
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

	public static final boolean matches(RivenditoreBean r) {
		if((!r.isMaggiorenne(r.getDataNascita()))
				|| (!r.getCitta().matches("^[A-Za-z ]{1,45}$"))
				|| (!r.getProvincia().matches("^[A-Z]{2,2}$"))
				|| (!r.getCodiceFiscale().matches("^[a-zA-Z]{6}[0-9]{2}[abcdehlmprstABCDEHLMPRST]{1}[0-9]{2}([a-zA-Z]{1}[0-9]{3})[a-zA-Z]{1}$"))
				|| ((r.getRagioneSociale().length()<1) || (r.getRagioneSociale().length() > 45))
				|| (!r.getProvinciaSedeLegale().matches("^[A-Z]{2,2}$"))
				|| (!r.getCittaSedeLegale().matches("^[A-Za-z ]{1,25}$"))
				|| (!r.getCapSedeLegale().matches("^[0-9]{5,5}$"))
				|| (!r.getViaSedeLegale().matches("^[A-Za-z ]{1,25}$"))
				|| (!r.getNumeroCivicoSedeLegale().matches("^[0-9]{1,25}$"))
				|| (!r.getNumeroPartitaIva().matches("^[0-9]{11,11}$"))
				) {
				
			return false;
				
		} else return true;
	}
	
	public boolean isMaggiorenne(java.sql.Date dataNascita) {
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"),Locale.ITALY);
		java.util.Date utilNow = calendar.getTime();
		java.sql.Date sqlNow = new java.sql.Date(utilNow.getTime());
		
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
	    int anno = Integer.parseInt(simpleDateFormat.format(sqlNow))-Integer.parseInt(simpleDateFormat.format(dataNascita));
	    
	    simpleDateFormat = new SimpleDateFormat("MM");
		int mese = Integer.parseInt(simpleDateFormat.format(sqlNow))-Integer.parseInt(simpleDateFormat.format(dataNascita));
		
		simpleDateFormat = new SimpleDateFormat("dd");
		int giorno = Integer.parseInt(simpleDateFormat.format(sqlNow))-Integer.parseInt(simpleDateFormat.format(dataNascita));
		
		if(anno>18 || (anno == 18 && (mese > 0 || (mese == 0 && giorno >= 0 )))) {
			return true;
		}
		return false;
	}
}
