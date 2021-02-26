package CommandPattern;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;

public class Reciver {
	String cf;
	public Reciver(String cf){
		this.cf = cf;
	}
	public void writePrenotazione(Connection con, Date Data, String orario) {  
		PreparedStatement p;
		
		try {
			p = con.prepareStatement("INSERT INTO PRENOTAZIONE(ID, CF, DATA, ORA, ESITO) VALUES (null, ?, ?, ?, null);");
	   		p.setString(1,cf);
	   		p.setDate(2,Data);
	   		p.setString(3, orario);
	   		p.executeUpdate();
		    System.out.println("Prenotazione effettuata.");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Prenotazione fallita.");
		}
		
	  }
}
