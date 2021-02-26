package BuilderPattern;
import com.DB;
import java.sql.ResultSet;
import java.util.Calendar;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class ConcreteBuilderMedicoInterface extends BuilderLogin{
	private String doc;

	private void makeCalendar(Connection con) {
		Calendar calendar = Calendar.getInstance();
		Date startDate = new Date(calendar.getTime().getTime());	// Ottieni il giorno del sistema
		this.doc += "<div class=\"Calendario\"> <h1 class=\"big-text\">Calendario Prenotazioni:</h1> <ul>";

	    try {
	    	PreparedStatement p = con.prepareStatement("SELECT NOME, COGNOME, ORA FROM PRENOTAZIONE PR JOIN PERSONA P ON PR.CF = P.CF WHERE DATA = ? ORDER BY ORA;");
		    p.setDate(1,startDate);
		    ResultSet rs = p.executeQuery();
		    while(rs.next()){
		        this.doc += ("<li> <span class=\"nome\">" + rs.getString("NOME") +"</span>");
		        this.doc += ("<span class=\"cognome\">" + rs.getString("COGNOME") +"</span>");
		        this.doc += ("<span class=\"ora\">" + rs.getTime("ORA") +"</span> </li>");
		    }
	    } catch(Exception e) {
	    	e.printStackTrace();
	    }

	    this.doc += "</div></ul>";
	}

	private void makeUpdateTamponi(Connection con) {
		this.doc += "<div class=\"UpdateTamponi\"> <h1 class=\"big-text\">Aggiorna Prenotazioni:</h1> <ul>";
		try {
		   	PreparedStatement p = con.prepareStatement("SELECT ID, CF FROM PRENOTAZIONE WHERE ESITO IS NULL OR ESITO = \"ela\";");
		    ResultSet rs = p.executeQuery();
		    while(rs.next()){
		        this.doc += ("<li> <span class=\"nome\">" + rs.getString("ID") +"</span>");
		        this.doc += ("<span class=\"cognome\">" + rs.getString("CF") +"</span></li>");
		    }
		} catch(Exception e) {
			   e.printStackTrace();
		}

		this.doc += "</div></ul>";
	}

	@Override
	public void interfacesElements(){
		Connection con=DB.getConnection();
		makeCalendar(con);
		makeUpdateTamponi(con);
		userInt.setElements(this.doc);
	}
}
