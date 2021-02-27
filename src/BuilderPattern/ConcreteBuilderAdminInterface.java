package BuilderPattern;

public class ConcreteBuilderAdminInterface extends BuilderLogin{
	
	@Override
	public void interfacesElements(){
		userInt.setElements("<div class = \"modifyMed\"> <h1>Aggiungi o rimuovi un medico:</h1> <form action=\"RegisterControllerMed\" method=\"post\"> <input type=\"text\" name=\"fc\" /> <select name=\"status\" > <option selected disabled> Seleziona: </option> <option value=\"add\">Aggiungi </option> <option value=\"del\">Rimuovi </option> </select> <input type=\"password\" name=\"password\" /> <input type=\"submit\" value=\"Invia\" /> </form> </div> <form action=\"Reports\" method=\"post\"> <fieldset> <legend>Ottieni Report</legend> <select name=\"status\" > <option value=\"monthly\" selected=\"selected\">Mensile </option> <option value=\"weekly\">Settimanale </option> <option value=\"daily\">Giornaliero </option> </select> </fieldset> <input type=\"submit\" value=\"submit\" /> </form> <a href=\"/Users/fabio/eclipse-workspace/Clinica/WebContent/Reports.pdf\"  target=\"pdf-frame\" >Formulário de cadastro</a>");
	}
}