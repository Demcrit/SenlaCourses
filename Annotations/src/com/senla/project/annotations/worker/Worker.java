package com.senla.project.annotations.worker;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import com.senla.project.annotaions.ConfigProperty;
public class Worker {
	private static final String PATH = "prop.properties";

	
	public void proccesing(Object object) {
		Class<? extends Object> cl = object.getClass();
		Values values = new Values();
		for (Field field : cl.getDeclaredFields()) {
			if (field.isAnnotationPresent((Class<? extends Annotation>) ConfigProperty.class)) {
				String configName;
				String propertyName;
				Class<?> type;

				if (field.getAnnotation(ConfigProperty.class).configName().equals("")) {
					configName = PATH;
				} else {
					configName = field.getAnnotation(ConfigProperty.class).configName();
				}

				if (field.getAnnotation(ConfigProperty.class).propertyName().equals("")) {
					propertyName = cl.getSimpleName() + "." + field.getName();

				} else {
					propertyName = field.getAnnotation(ConfigProperty.class).propertyName();
				}

				if (field.getAnnotation(ConfigProperty.class).type().equals(Object.class)) {
					type = String.class;
				} else {
					type = field.getAnnotation(ConfigProperty.class).type();
				}

				Object newValue = values.getValue(configName, propertyName, type);

				field.setAccessible(true);
				try {
					field.set(object, newValue);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} finally {
					field.setAccessible(false);
				}

			}
		}

	}

	
}