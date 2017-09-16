public class AssemblyLine implements IAssemblyLine {
		
	public IProduct assembleProduct(IProduct spectacles) {
    		
		ILineStep HousingStep = new HousingStep();
		spectacles.installHousing( HousingStep.buildProductPart() );
		ILineStep LensesStep = new LensesStep();
		spectacles.installLenses( LensesStep.buildProductPart() );
		ILineStep ArchesStep = new ArchesStep();
		spectacles.installArches( ArchesStep.buildProductPart() );
		
	return spectacles;
  }
 	}
  



