package BuilderPattern;

public abstract class BuilderLogin {
  protected Interface userInt;
  public Interface getInterface(){
    return userInt;
  }
  public void buildInterface(){
    userInt = new Interface();
  }
  public abstract void interfacesElements();
}
