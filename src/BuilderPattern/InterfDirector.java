package BuilderPattern;

public class InterfDirector {
	private BuilderLogin interfacciaUtente;

	public void setUserInterface(BuilderLogin Interfaccia){
		this.interfacciaUtente = Interfaccia;
	}
	
	public void buildInterface(){
		interfacciaUtente.buildInterface();
		interfacciaUtente.interfacesElements();
	}
	
	public Interface getInterface(){
		return interfacciaUtente.getInterface();
	}
}
