package com.senla.project.injector;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import org.apache.logging.log4j.*;

public class PropRead {
	private static final Logger LOG = LogManager.getLogger(PropRead.class);
	private static final String PATH = "injector.properties";
	private static Map<Object, Object> properties;

	public static void init() {
		properties = new Properties();
		try (FileInputStream input = new FileInputStream(PATH)) {
			((Properties)properties).load(input);
		} catch (IOException e) {
			LOG.error(e.getMessage());
		}
	}
	
	public static String getClassName(String key) {
		if (properties == null) {
			init();
		}
		return (String) properties.get(key);
	}

}
