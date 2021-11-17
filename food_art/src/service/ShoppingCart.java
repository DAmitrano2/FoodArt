package service;

import java.util.ArrayList;

import model.product.ProductBean;

public class ShoppingCart {

	public ShoppingCart() {
		cart = new ArrayList<ProductItem>();
	}
	
	public boolean addProductItem(ProductItem prod)  {
		int quantitaBean = prod.getProduct().getQuantitaDisponibile();
		for(ProductItem product : cart) {
			if(prod.getIdProdotto()==product.getIdProdotto()) {
				if( product.getQuantita()>quantitaBean ) {
					return false;
				}
				product.setQuantita( product.getQuantita()+1 );
				return true;
			}
		}
		
		if( prod.getQuantita()<=quantitaBean ) {
			cart.add(prod);
		} else {
			return false;
		}
		
		return true;
	}
	
	public void removeProductItem(int id) {
		for(int i=0; i<cart.size(); i++ ) {
			if( id == cart.get(i).getIdProdotto() ) {
				cart.remove(i);
				return;
			}
		}
	}
	

	public boolean addQuantityProductItem(ProductItem prod, int quantita) {
		int quantitaMax = prod.getProduct().getQuantitaDisponibile();
		for(ProductItem product : cart) {
			if(prod.getIdProdotto()==product.getIdProdotto()) {
				if( quantita>quantitaMax ) {
					return false;
				}
				product.setQuantita( quantita );
				return true;
			}
		}
		
		if( quantita<=quantitaMax ) {
			prod.setQuantita(quantita);
			cart.add(prod);
		} else {
			return false;
		}
		
		return true;
	}
	
	/**
	 * Calcola il prezzo totale
	 * @return prezzo totale
	 */
	public float getPrezzoTotale() {
		
		//Inizializzazione
		float tot=0;
		float prezzo=0;
		ProductBean bean = null;
		
		for(ProductItem p:cart) {
			//Assegnamento inizializzazione per ogni item
			bean = p.getProduct();
			prezzo = Float.parseFloat(p.getPrezzo().replace(",", "."));
			
			tot+=prezzo*p.getQuantita();
			
		}
			
		return tot;
	}
	
	/**
	 * Ritorna la quantità di elementi aggiunti al carrello
	 * @return
	 */
	public int getQuantita() {
		int quantita = 0;
		
		for(ProductItem product:cart) {
			quantita += product.getQuantita();
		}
		
		return quantita;
	}
	
	public ArrayList<ProductItem> getProducts() {
		return this.cart;
	}
	
	private ArrayList<ProductItem> cart;
}
