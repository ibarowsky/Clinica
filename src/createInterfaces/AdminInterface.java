package createInterfaces;

import BuilderPattern.BuilderLogin;
import BuilderPattern.ConcreteBuilderAdminInterface;
import BuilderPattern.InterfDirector;
import BuilderPattern.Interface;

public class AdminInterface {
	public static String BuildMedInterface() {
		InterfDirector director = new InterfDirector();
		BuilderLogin buildLogin = new ConcreteBuilderAdminInterface(); 		
		director.setUserInterface(buildLogin);
	    director.buildInterface();
	    Interface interf = director.getInterface();
	    return interf.getElements();
	}
}
