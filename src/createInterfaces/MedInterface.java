package createInterfaces;

import BuilderPattern.BuilderLogin;
import BuilderPattern.ConcreteBuilderMedicoInterface;
import BuilderPattern.InterfDirector;
import BuilderPattern.Interface;

public class MedInterface {
	public static String BuildMedInterface() {
		InterfDirector director = new InterfDirector();
		BuilderLogin buildLogin = new ConcreteBuilderMedicoInterface(); 		
		director.setUserInterface(buildLogin);
	    director.buildInterface();
	    Interface interf = director.getInterface();
	    return interf.getElements();
	}
}