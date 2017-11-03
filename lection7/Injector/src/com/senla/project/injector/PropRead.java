package com.senla.project.injector;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropRead {
	public static final String PATH = "injector.properties";
	public static Properties readFile() {
		Properties prop = new Properties();

		try (InputStream input = new FileInputStream(PATH)) {
			prop.load(input);
			return prop;
		} catch (IOException e) {
			System.err.print(e);
			return null;
		}
	}
}
