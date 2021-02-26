package createInterfaces;

import BuilderPattern.BuilderLogin;
import BuilderPattern.ConcreteBuilderUserInterface;
import BuilderPattern.InterfDirector;
import BuilderPattern.Interface;

public class UserInterface {
	public static String BuildUserInterface(String fc) {
		InterfDirector director = new InterfDirector();
		BuilderLogin buildLogin = new ConcreteBuilderUserInterface(fc); 		
		director.setUserInterface(buildLogin);
	    director.buildInterface();
	    Interface interf = director.getInterface();
	    return interf.getElements();
	}
}
