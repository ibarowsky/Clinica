package BuilderPattern;

public class ConcreteBuilderAdminInterface extends BuilderLogin{
	
	@Override
	public void interfacesElements(){
		userInt.setElements("<div class=\"header\">\r\n"
				+ "  <div class=\"cta\">\r\n"
				+ "      <a href=\"Home.jsp\" class=\"button\"> Home</a>\r\n"
				+ "    </div>\r\n"
				+ "  	<div class=\"nome\">\r\n"
				+ "		<h1> Clinica Becuba</h1>\r\n"
				+ "		</div>\r\n"
				+ "    </div> <div class = \"modifyMed\"> <h1>Aggiungi o rimuovi un medico:</h1> <form action=\"RegisterControllerMed\" method=\"post\"> <input type=\"text\" name=\"fc\" /> <select name=\"status\" > <option selected disabled> Seleziona: </option> <option value=\"add\">Aggiungi </option> <option value=\"del\">Rimuovi </option> </select> <input type=\"text\" name=\"password\" /> <input type=\"submit\" value=\"Invia\" /> </form> </div>  <div class = \"report\"> <form action=\"Reports\" method=\"post\"> <fieldset> <h1>Ottieni Report</h1> <select name=\"status\" > <option value=\"monthly\" selected=\"selected\">Mensile </option> <option value=\"weekly\">Settimanale </option> <option value=\"daily\">Giornaliero </option> </select> </fieldset> <input type=\"submit\" value=\"submit\" /> </form> </div>");
	}
}