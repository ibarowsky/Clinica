package StatePattern;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.DB;

public abstract class Stato {
	public abstract void manageState(Tampone tamp, String esito);
	
	protected void updateTampone(String id, String esito) {
		Connection con = DB.getConnection();
    	try{		    	
	    	PreparedStatement p = con.prepareStatement("UPDATE PRENOTAZIONE SET ESITO = ? WHERE ID = ?;");
		    p.setString(1, esito);
		    p.setString(2, id);
		    p.executeUpdate();
		    System.out.println("Update Eseguito.");
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	}
}