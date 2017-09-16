public class Lenses implements IProductPart {
  private String name;
  public Lenses(String name) {
    this.name = name;
  } 
  
  public String toString() {
      return name;
  }
}