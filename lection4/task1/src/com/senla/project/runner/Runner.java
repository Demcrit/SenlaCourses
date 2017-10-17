package com.senla.project.runner;

import java.nio.file.FileAlreadyExistsException;
import com.senla.project.facade.Facade;
import com.senla.project.facade.IFacade;
import com.senla.project.model.Mechanic;
import static com.senla.project.utils.PrintUtil.*;
import com.senla.project.utils.TextUtil;

public class Runner {
	private static IFacade fd = new Facade();
	private static TextUtil txtMechanics = new TextUtil("Mechanics.txt");

	public static void main(String[] args) throws FileAlreadyExistsException {

		Mechanic mechanic1 = new Mechanic("Sergey Zabashnyj");
		Mechanic mechanic2 = new Mechanic("King Lich");
		Mechanic mechanic3 = new Mechanic("Ivan Petrov");
		fd.addMechanic(mechanic1);
		fd.addMechanic(mechanic2);
		fd.addMechanic(mechanic3);
		printObject(fd.sortMechanicsByWork());

		txtMechanics.writeToFile(fd.getAll());
		printMessage("Readed from file");
		txtMechanics.readFromFile("Mechanic.txt");
		
		
	}
}