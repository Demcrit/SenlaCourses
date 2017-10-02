package com.senla.project.realization;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.senla.project.model.Mechanic;
import static com.senla.project.utils.PrintUtil.*;
import com.senla.project.realization.Facade;
import com.danco.training.*;

public class Runner {

	public static void main(String[] args) throws IOException {
		Facade fd = new Facade();
		
		Mechanic mechanic1 = new Mechanic("Sergey Zabashnyj", null);
		Mechanic mechanic2 = new Mechanic("King Lich", null);
		Mechanic mechanic3 = new Mechanic("Ivan Petrov", null);

		fd.addMechanic(mechanic1);
		fd.addMechanic(mechanic2);
		fd.addMechanic(mechanic3);
        
		String[] arr = new String[fd.getAll().size()];{
			for (int i = 0; i < fd.getAll().size(); i++) {
				arr[i] = String.valueOf(fd.getAll().get(i));
			}

			final String TEST_FILE = "C:/Users/Demcrit/workspace/AutoManager/Mechanics.txt";
			final String[] testValues = arr;

			Path filePath = Paths.get(TEST_FILE);
			try {
				Files.createFile(filePath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				TextFileWorker fileWorker = new TextFileWorker(TEST_FILE);
				fileWorker.writeToFile(testValues);
				Object[] readedValues = fileWorker.readFromFile();

				for (int i = 0; i < testValues.length; i++) {

					if (!readedValues[i].equals(testValues[i])) {
						throw new RuntimeException("Error. Not equal values: " + readedValues[i] + " and " + testValues[i]);
					}
				}

				for (Object object : readedValues) {
					printObject(object);
				}
			} finally {
				//Files.deleteIfExists(filePath);
			}	
			
	}

}
}
