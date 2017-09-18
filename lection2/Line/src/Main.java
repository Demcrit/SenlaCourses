public class Main {
public static void main(String[] args) {
                ILineStep HousingStep = new HousingStep();
		ILineStep LensesStep = new LensesStep();
		ILineStep ArchesStep = new ArchesStep();
	        AssemblyLine spect = new AssemblyLine();
	        System.out.println("Assembly Complete!");
	
        	Spectacles spectacles = (Spectacles)spect.assembleProduct(new Spectacles() );
	        System.out.println("Take your new spectacles: " + spectacles);
	    
	}
}
