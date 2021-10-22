package model.metodoPagamento;

import java.sql.SQLException;
import java.util.Collection;

import model.indirizzoConsegna.IndirizzoConsegnaBean;

public interface MetodoPagamentoDAO {
	
	/**
	 * Controlla se una carta � esistente
	 * @param nCarta
	 * @return true se una carta esiste, false altrimenti
	 * @throws SQLException
	 */
	boolean cartaEsistente(String nCarta) throws SQLException;
	
	/**
	 * Controlla se � possibile effettuare un pagamento
	 * @param nCarta e spesa
	 * @return true se � possibile effetture il pagamento, false altrimenti
	 * @throws SQLException
	 */
	boolean pagamentoPossibile(String nCarta, float spesa) throws SQLException;
	
	/**
	 * Effettua un pagamento
	 * @param nCarta e spesa
	 * @return
	 * @throws SQLException
	 */
	void effettuaPagamento(String nCarta, float spesa) throws SQLException;
	
	/**
	 * Restituisce una collezione di carte collegate a un determinato utente
	 * @param idUser
	 * @return Collection<IndirizzoConsegnaBean>
	 * @throws SQLException
	 */
	Collection<MetodoPagamentoBean> getMetodoPagamentoByIdUser (int idUser) throws SQLException;

}
