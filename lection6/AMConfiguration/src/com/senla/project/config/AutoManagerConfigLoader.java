package com.senla.project.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AutoManagerConfigLoader {

	private static AutoManagerConfigStorage properties = null;

	public static void loadPropertiesPath(String propertiesPath) {

		Properties property = new Properties();
		try (FileInputStream fis = new FileInputStream(propertiesPath)) {

			property.load(fis);

		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}

		boolean addRemoveWorkpalces = Boolean.valueOf(property.getProperty("addRemoveWorkpalces"));
		boolean delayOrders = Boolean.valueOf(property.getProperty("delayOrders"));
		boolean removeOrder = Boolean.valueOf(property.getProperty("removeOrder"));

		properties = new AutoManagerConfigStorage(property.getProperty("dbPath"), property.getProperty("dbCSVPath"), addRemoveWorkpalces, removeOrder,
				delayOrders);
	}

	public static AutoManagerConfigStorage getProperties() {
		return AutoManagerConfigLoader.properties;
	}
}
