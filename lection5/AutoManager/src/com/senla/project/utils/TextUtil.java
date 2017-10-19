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

	public void writeToFile(List<?> list) {
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

	public String[] readFromFile(String file) {
		fileWorker = new TextFileWorker(FILE_PATH);
		String[] readedValues = fileWorker.readFromFile();
		return readedValues;
		}
	}

