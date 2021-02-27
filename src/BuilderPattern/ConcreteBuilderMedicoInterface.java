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
		this.doc += "<div class=\"header\">\r\n"
				+ "  <div class=\"cta\">\r\n"
				+ "      <a href=\"Home.jsp\" class=\"button\"> Home</a>\r\n"
				+ "    </div>\r\n"
				+ "  	<div class=\"nome\">\r\n"
				+ "		<h1> Clinica Becuba</h1>\r\n"
				+ "		</div>\r\n"
				+ "    </div> <div class=\"Calendario\"> <h1 class=\"big-text\">Prenotazioni del giorno:</h1> <ul>";

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
		this.doc += "<div class=\"AggiornaEsito\"> <form action=\"UpdateTampone\" method=\"post\"> <input type=\"text\" name=\"idprenot\" /> <select name=\"esito\" >\r\n"
				+ "				<option selected disabled> Seleziona: </option>\r\n"
				+ "				<option value=\"ela\">Elaborazione </option>\r\n"
				+ "				<option value=\"pos\">Positivo </option>\r\n"
				+ "				<option value=\"neg\">Negativo </option>\r\n"
				+ "			</select>\r\n"
				+ "	<input type=\"submit\" value=\"Invia\" />\r\n"
				+ "	</form>\r\n"
				+ "	</div><ul>";
		try {
		   	PreparedStatement p = con.prepareStatement("SELECT ID, CF, ESITO FROM PRENOTAZIONE WHERE ESITO IS NULL OR ESITO = \"ela\";");
		    ResultSet rs = p.executeQuery();
		    while(rs.next()){
		        this.doc += ("<li> <span class=\"id\">" + rs.getString("ID") +"</span>");
		        this.doc += ("<span class=\"cf\">" + rs.getString("CF") +"</span>");
		        this.doc += ("<span class=\"cf\">" + rs.getString("ESITO") +"</span></li>");
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