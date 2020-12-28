package model.indirizzoConsegna;

import java.sql.SQLException;
import java.util.Collection;


public interface IndirizzoConsegnaDAO {

	public void doSave(IndirizzoConsegnaBean indirizzo) throws SQLException;
	
	public Collection<IndirizzoConsegnaBean> getIndirizzoByIdUser (int idUser) throws SQLException;
	
	public IndirizzoConsegnaBean doRetriveByKey(int code) throws SQLException;
	
	public boolean doDelete(int code) throws SQLException;

}
