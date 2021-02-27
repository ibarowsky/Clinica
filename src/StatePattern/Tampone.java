package StatePattern;

public class Tampone {
  private Stato state;
  private String id;
  
  public Tampone() {
	  this.state = new EsitoInElab();
  }

  public void setState(Stato state) {
      this.state=state;
  }

  public void setId(String id) {
	  this.id = id;
  }
  
  public Stato currentState() {
	  return this.state;
  }
  
  public String getId() {
	  return this.id;
  }
}