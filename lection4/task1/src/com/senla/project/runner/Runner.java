package com.senla.project.runner;

import java.io.IOException;
import com.senla.project.facade.Facade;
import com.senla.project.model.Mechanic;
import static com.senla.project.utils.PrintUtil.*;
import com.senla.project.utils.TextUtil;

public class Runner {
	private static Facade fd = new Facade();
	private static TextUtil txtMechanics = new TextUtil("Mechanics.txt");

	public static void main(String[] args) throws IOException {

		Mechanic mechanic1 = new Mechanic("Sergey Zabashnyj", null);
		Mechanic mechanic2 = new Mechanic("King Lich", null);
		Mechanic mechanic3 = new Mechanic("Ivan Petrov", null);
		fd.addMechanic(mechanic1);
		fd.addMechanic(mechanic2);
		fd.addMechanic(mechanic3);
		printObject(fd.sortMechanicsByWork());
		
		txtMechanics.writeToFile(fd.getAll());
		
		txtMechanics.readFromFile();
		

	}
}