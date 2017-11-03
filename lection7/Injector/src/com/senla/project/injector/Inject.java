package com.senla.project.injector;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Inject {
	private static Properties prop = PropRead.readFile();
	private static Map<String, Object> cache = new HashMap<String, Object>();

	public static void inject(Object obj) throws ReflectiveOperationException {
		Class<? extends Object> cl = obj.getClass();
		List<Field> fields = Arrays.asList(cl.getDeclaredFields());
		for (Field fld : fields) {
			fld.setAccessible(true);
			if (fld.isAnnotationPresent(Injector.class)) {
				String interfaceName = fld.getType().getName();
				Object checked = cache.get(interfaceName);
				if (checked == null) {
					String className = prop.getProperty(interfaceName);
					try {
						cache.put(interfaceName, Class.forName(className).newInstance());
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
						e.printStackTrace();
						System.err.print(e);
						throw e;
					}
				}
				try {
					fld.set(obj, cache.get(interfaceName));
				} catch (IllegalArgumentException | IllegalAccessException e) {
					System.err.print(e);
					throw e;
				}
			}
		}
	}
}
