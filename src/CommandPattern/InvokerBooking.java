package CommandPattern;
	
	public class InvokerBooking {
	Command command;
	String cf;
	
	public InvokerBooking(Command command){
	  this.command = command;
	}
	
	public void list(){
	  command.readDate();
	}
}
