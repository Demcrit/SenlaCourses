package com.senla.annotations.worker;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.apache.log4j.*;

import com.senla.annotaions.ConfigProperty;

public class Worker {
	private static final String PATH = "prop.properties";
	private static Worker instance;
	private final static Logger LOG = LogManager.getLogger(Worker.class);

	private Worker() {

	}

	public static Worker getInstance() {

		if (instance == null) {
			instance = new Worker();
		}
		return instance;
	}

	public void proccesing(Object object) {
		
		Class<? extends Object> cl = object.getClass();
		Values values = new Values();
		for (Field field : cl.getDeclaredFields()) {
			if (field.isAnnotationPresent((Class<? extends Annotation>) ConfigProperty.class)) {
				String configName;
				String propertyName;
				Class<?> type;
				ConfigProperty config = field.getAnnotation(ConfigProperty.class);
				if (config.configName().equals("")) {
					configName = PATH;
				} else {
					configName = config.configName();
				}
				if (config.propertyName().equals("")) {
					propertyName = cl.getSimpleName() + "." + field.getName();
				} else {
					propertyName = config.propertyName();
				}
				if (config.type().equals(Object.class)) {
					type = String.class;
				} else {
					type = config.type();
				}

				Object newValue = values.getValue(configName, propertyName, type);
				Boolean oldValues = field.isAccessible();
				field.setAccessible(true);
				try {
					field.set(object, newValue);
				} catch (IllegalArgumentException e) {
					LOG.error(e);
				} catch (IllegalAccessException e) {
					LOG.error(e);
				} finally {
					field.setAccessible(false);
					field.setAccessible(oldValues);
				}

			}
		}

	}

}
