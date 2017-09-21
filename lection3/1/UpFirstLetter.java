package lection3;

public class UpFirstLetter {

	public void upCase(){
		String[] mas = {"lol","fail","good","never","give","up"};
		for (String s : mas) {   
	System.out.print(s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase()+ " ");
			 }
		 	}
	
}
