public class Main {

	public static void main(String[] args) {
		Idcard idcard = new Idcard(2,true);
		System.out.println("We create new Object card " + idcard);
		Instruments ins = new Instruments(1,"Spoon");
		System.out.println("We create new Object instrument " + ins);
		Worker worker = new Worker("Serg","Milk",26,"Director",idcard,ins);
		System.out.println("Look at our new worker,Welcome "+"\n" + worker);
		
	}

}