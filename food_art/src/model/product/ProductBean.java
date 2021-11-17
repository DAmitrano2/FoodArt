package model.prodotto;

public class ProdottoBean {

	private int idProdotto;
	private String titolo;
	private String descrizione;
	private String unitaMisura;
	private String prezzo;
	private int quantitaMinima;
	private int quantitaDisponibile;
	private String cittaProvenienza;
	private String provinciaProvenienza;
	private int idCategoria;
	private int idUtente;

	public ProdottoBean() {
		this.idProdotto = -1;
	}

	public int getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getUnitaMisura() {
		return unitaMisura;
	}

	public void setUnitaMisura(String unitaMisura) {
		this.unitaMisura = unitaMisura;
	}

	public String getPrezzo() {
		return prezzo.replace(".", ",");
	}

	public void setPrezzo(String prezzo) {
		this.prezzo = prezzo;
	}

	public int getQuantitaMinima() {
		return quantitaMinima;
	}

	public void setQuantitaMinima(int quantitaMinima) {
		this.quantitaMinima = quantitaMinima;
	}

	public int getQuantitaDisponibile() {
		return quantitaDisponibile;
	}

	public void setQuantitaDisponibile(int quantitaDisponibile) {
		this.quantitaDisponibile = quantitaDisponibile;
	}

	public String getCittaProvenienza() {
		return cittaProvenienza;
	}

	public void setCittaProvenienza(String cittaProvenienza) {
		this.cittaProvenienza = cittaProvenienza;
	}

	public String getProvinciaProvenienza() {
		return provinciaProvenienza;
	}

	public void setProvinciaProvenienza(String provinciaProvenienza) {
		this.provinciaProvenienza = provinciaProvenienza;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	public int getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}
}
