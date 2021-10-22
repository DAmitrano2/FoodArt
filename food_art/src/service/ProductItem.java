package service;

import model.prodotto.ProdottoBean;

public class ProductItem {

	public ProductItem(ProdottoBean product) {
		this.product = product;
	}
	
	public int getIdProdotto() {
		return this.product.getIdProdotto();
	}
	
	public String getTitolo() {
		return this.product.getTitolo();
	}
	
	public String getPrezzo() {
		return this.product.getPrezzo();
	}
	
	public int getIdUtente() {
		return this.product.getIdUtente();
	}
	
	public String getUnitaMisura() {
		return this.product.getUnitaMisura();
	}
	
	public int getQuantitaMinima() {
		return this.product.getQuantitaMinima();
	}
	
	public int getQuantitaDisponibile() {
		return this.product.getQuantitaDisponibile();
	}
	
	public ProdottoBean getProduct() {
		return product;
	}
	public void setProduct(ProdottoBean product) {
		this.product = product;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public boolean equals(Object obj) {
		return product.equals(obj);
	}

	private ProdottoBean product;
	private int quantita = 1;
}