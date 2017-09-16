public class Main {
public static void main(String[] args) {

	AssemblyLine spect = new AssemblyLine();
	System.out.println("Assembly Complete!");
	
	Spectacles spectacles = (Spectacles)spect.assembleProduct( new Spectacles() );
	System.out.println("Take your new spectacles: " + spectacles);
	    
	}
}