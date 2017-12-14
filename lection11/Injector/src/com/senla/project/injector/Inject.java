package com.senla.project.injector;

import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.*;

public class Inject {
	private static final Logger LOG = LogManager.getLogger(Inject.class);
	private static Map<String, Object> classList = new HashMap<String, Object>();

	public static Object getClassInstance(Class<?> cl) {
		Object obj = null;
		if (classList.containsKey(cl.getName())) {

			obj = classList.get(cl.getName());
		} else {
			String implClassName = PropRead.getClassName(cl.getName());
			try {
				Class<?> implClass = Class.forName(implClassName);
				obj = implClass.newInstance();
				classList.put(cl.getName(), obj);
			} catch (Exception e) {
				LOG.error(e.getMessage());
			}
		}
		return obj;
	}
}
