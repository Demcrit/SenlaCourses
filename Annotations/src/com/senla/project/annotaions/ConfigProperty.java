package com.senla.project.annotaions;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ConfigProperty {
	public static final String NULL = " ";

	public String configName() default NULL;
	
	public String propertyName() default NULL;
	
	Class<?> type() default Object.class;
}
