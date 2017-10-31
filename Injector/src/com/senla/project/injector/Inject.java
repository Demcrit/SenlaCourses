package com.senla.project.injector;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Inject {

	public static final String PATH = "injector.properties";

	private static Properties prop = readFile();
	private static Map<String, Object> cache = new HashMap<String, Object>();

	public static void inject(Object obj) throws ReflectiveOperationException {
		if (prop == null) {
			System.exit(1);
		}
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
