package model.address;

import java.sql.SQLException;
import java.util.Collection;


public interface AddressDAO {

	public void doSave(AddressBean indirizzo) throws SQLException;
	
	public Collection<AddressBean> getIndirizzoByIdUser (int idUser) throws SQLException;
	
	public AddressBean doRetriveByKey(int code) throws SQLException;
	
	public boolean doDelete(int code) throws SQLException;

}
