package model.entry;

import java.sql.SQLException;
import java.util.Collection;

public interface EntryDAO {
	
	public void doSave(EntryBean voce) throws SQLException;

	public Collection<EntryBean> doRetrieveByOrderKey(int idOrdine) throws SQLException;

}
