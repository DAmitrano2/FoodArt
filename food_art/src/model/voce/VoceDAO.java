package model.voce;

import java.sql.SQLException;
import java.util.Collection;

public interface VoceDAO {
	
	public void doSave(VoceBean voce) throws SQLException;

	public Collection<VoceBean> doRetrieveByOrderKey(int idOrdine) throws SQLException;

}
