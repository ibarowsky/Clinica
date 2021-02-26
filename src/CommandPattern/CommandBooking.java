package CommandPattern;
import com.DB;
import java.util.Calendar;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;

	public class CommandBooking implements Command{
	private Reciver reciver;
	
	public CommandBooking(Reciver reciver) {
	    this.reciver = reciver;
	}
	
	private String CalcolaOrario(int Cont) {
		switch(Cont) {
			case 0:	return "08:00";
			case 1:	return "09:00";	
			case 2:	return "10:00";
			case 3:	return "11:00";
			case 4:	return "12:00";
			case 5:	return "14:00";
			case 6:	return "15:00";
			case 7:	return "16:00";
			case 8:	return "17:00";
			case 9:	return "18:00";
		}
		return null;
	}

  @Override
	public void readDate() {
	  /* Leggi dal database la prima data utile per una prenotazione 
	   * e mandala al reciver per scriverla nel database. 
	   * In un giorno non possono esserci più di 10 prenotazioni.
	   */
	  
	  	// Dichiarazione variabili
	   	Connection con=DB.getConnection();
	   	PreparedStatement p;
		Calendar calendar = Calendar.getInstance();
		Date startDate = new Date(calendar.getTime().getTime());	// Ottieni il giorno del sistema
		ResultSet rs;
		int Cont;
		String orario;
		// =======================
		
		try {
			while(true){
				p = con.prepareStatement("SELECT COUNT(*) AS CONTATORE FROM PRENOTAZIONE WHERE DATA = ? GROUP BY DATA;");	// Cerca quante prenotazioni ci sono in un giorno
				p.setDate(1,startDate);	// Inserisci la data nella query
				rs=p.executeQuery();	// Lancia la query
				if(rs.next()){	// Se restituisce un numero > 0
					Cont = rs.getInt("CONTATORE");	// Prendi quel numero
					System.out.println("Per il giorno " + startDate + " ci sono " + Cont + " prenotazioni.");
		    		if(Cont < 10){	// Se ci sono meno di 10 prenotazioni in quel giorno
		    			orario = CalcolaOrario(Cont);
		    			reciver.writePrenotazione(con, startDate, orario);	// Inserisci la prenotazione nel database
		    			break;
		    		}
		    		else { // Altrimenti prova il giorno dopo
		    			calendar.add(Calendar.DAY_OF_MONTH, +1);	// Incrementa il giorno
		    			startDate = new Date(calendar.getTime().getTime());	// Salvalo nella variabile
		    		}
			    }
				else {	// Se il giorno inseito ci sono 0 prenotazioni 
					System.out.println("Per il giorno " + startDate + " ci sono 0 prenotazioni.");
					orario = CalcolaOrario(0);
					reciver.writePrenotazione(con, startDate, orario);	// Inserisci la prenotazione nel database
	    			break;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
  	} 
}
