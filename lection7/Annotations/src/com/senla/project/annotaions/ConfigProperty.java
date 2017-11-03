package com.senla.project.annotaions;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ConfigProperty {
	public String configName();

	public String propertyName();

	Class<?> type() default Object.class;
}
