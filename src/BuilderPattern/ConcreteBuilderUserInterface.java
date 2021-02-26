package BuilderPattern;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.DB;

public class ConcreteBuilderUserInterface extends BuilderLogin{
	private String doc;
	private String fc;
	
	public ConcreteBuilderUserInterface(String fc) {
		this.fc = fc;
	}
	
	private void makeBookingButton() {
		this.doc += "<div class=\"header\"> <div class=\"cta\"> <a href=\"UserInterface.jsp\" class=\"button\"> Home</a> </div> <div class=\"nome\"> <h1> Clinica Becuba</h1> </div>  </div> <div class=\"booking\"> <h1>Prenota il tuo tampone:</h1> <form action=\"BookingSwab\" method=\"post\"> <input type=\"submit\" value=\"Prenota\"> </form> </div>";
	}
	
	private void makeBookingCalendar(Connection con) {
		this.doc += "<div class=\"Calendario\"> <h1 class=\"big-text\">Calendario Prenotazioni:</h1> <ul>";
		try {
			PreparedStatement p = con.prepareStatement("SELECT DATA, ORA, ESITO FROM PRENOTAZIONE WHERE CF = ?;");
		    p.setString(1,fc);
		    ResultSet rs = p.executeQuery();
		    while(rs.next()) {
		    	this.doc += ("<li> <span class=\"nome\">" + rs.getString("DATA") +"</span>");
		        this.doc += ("<span class=\"cognome\">" + rs.getString("ORA") +"</span>");
		        this.doc += ("<span class=\"ora\">" + rs.getString("ESITO") +"</span> </li>");
		    }
		} catch(Exception e) {
			e.printStackTrace();
		}
		this.doc += "</div></ul>";
	}
	
	@Override
	public void interfacesElements(){
		Connection con=DB.getConnection();
		makeBookingButton();
		makeBookingCalendar(con);
		userInt.setElements(doc);
	}
}
