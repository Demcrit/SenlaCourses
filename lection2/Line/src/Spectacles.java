public class Spectacles implements IProduct {  
  private IProductPart housing;  
  private IProductPart lenses;  
  private IProductPart arches;  

  public void installHousing(IProductPart housing) {
    this.housing = housing;
  }

  public void installLenses(IProductPart lenses) {
    this.lenses = lenses;
  }

  public void installArches(IProductPart arches) {
    this.arches = arches;
  }

@Override
public String toString() {
	return " " + "Body:" + this.housing+ " Lenses:" + this.lenses+" Arches:" + this.arches;
}
  
  

}
  