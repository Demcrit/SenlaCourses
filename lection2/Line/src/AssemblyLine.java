public class AssemblyLine implements IAssemblyLine {
    private ILineStep housing;
    private ILineStep lenses;
    private ILineStep archers;
    
    public AssemblyLine(ILineStep housing, ILineStep lenses, ILineStep archers) {
        this.housing = housing;
        this.lenses = lenses;
        this.archers = archers;
    }
	public IProduct assembleProduct(IProduct spectacles) {
    		
		
		spectacles.installHousing(housing.buildProductPart());
		spectacles.installLenses(lenses.buildProductPart());
		spectacles.installArches(archers.buildProductPart());
			return spectacles;
  }
 	}
  



