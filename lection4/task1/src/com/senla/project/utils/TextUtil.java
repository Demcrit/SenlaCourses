package com.senla.project.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import com.danco.training.TextFileWorker;
import static com.senla.project.utils.ParseUtil.*;

public class TextUtil {

	private String FILE_PATH;
	private String[] arrayFromList;
	private TextFileWorker fileWorker;

	public TextUtil(String path) {
		FILE_PATH = path;
	}

	public void writeToFile(List list) {
		arrayFromList = arrayToList(list);
		Path filePath = Paths.get(FILE_PATH);
		try {
			Files.createFile(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		fileWorker = new TextFileWorker(FILE_PATH);
		fileWorker.writeToFile(arrayFromList);
	}

	public void readFromFile() {
		fileWorker = new TextFileWorker(FILE_PATH);
		Object[] readedValues = fileWorker.readFromFile();
		for (int i = 0; i < arrayFromList.length; i++) {
			if (!readedValues[i].equals(arrayFromList[i])) {
				throw new RuntimeException("Error. Not equal values: " + readedValues[i] + " and " + arrayFromList[i]);
			}
		}
		for (Object object : readedValues) {
			PrintUtil.printObject(object);
		}
	}
}
