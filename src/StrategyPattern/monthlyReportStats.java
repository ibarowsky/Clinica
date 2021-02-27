package StrategyPattern;
import com.DB;
import java.sql.Date;
import java.util.Calendar;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class monthlyReportStats extends StrategyStats {

	@Override
	public void makeStats() {
		inizializeData();
		PDFCreator.createPDF(this);
	}

	private void inizializeData() {
		this.status = "Monthly";
		Calendar calendar = Calendar.getInstance();
		endDate = new Date(calendar.getTime().getTime());	// Ottieni il giorno del sistema
		calendar.add(Calendar.DAY_OF_MONTH, -31);
		startDate = new Date(calendar.getTime().getTime());
		Connection con = DB.getConnection();
		try {
			PreparedStatement p = con.prepareStatement("SELECT COUNT(*) AS POSITIVI FROM PRENOTAZIONE WHERE DATA > ? AND DATA <= ? AND ESITO = \"pos\" GROUP BY ESITO;");
			p.setDate(1, startDate);
			p.setDate(2, endDate);
			ResultSet rs = p.executeQuery();
			if(rs.next()) {
				npos = rs.getInt("POSITIVI");
			}
			/*---------------------------------------------*/
			p = con.prepareStatement("SELECT COUNT(*) AS NEGATIVI FROM PRENOTAZIONE WHERE DATA > ? AND DATA <= ?  AND ESITO = \"neg\" GROUP BY ESITO;");
			p.setDate(1, startDate);
			p.setDate(2, endDate);
			rs = p.executeQuery();
			if(rs.next()) {
				nneg = rs.getInt("NEGATIVI");
			}
			
			p = con.prepareStatement("SELECT NOME FROM PERSONA P JOIN ADMIN A ON P.CF = A.CF;");
        	rs = p.executeQuery();
        	if(rs.next()) {
        		adminName = rs.getString("NOME");
        	}
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Tra il " + startDate + " e il " + endDate + " ci sono stati " + npos + " positivi e " + nneg + " negativi su " + (npos + nneg) + " tamponi.");
	}
}