package com.senla.annotations.worker;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.apache.log4j.*;

public class PropUtil {
    private final static Logger LOG = LogManager.getLogger(PropUtil.class);
	private Map<String, Properties> map = new HashMap<String, Properties>();

	public String getProperties(String path, String key) {
		String result = null;
		try {

			if (map.get(path) == null) {
				Properties properties = new Properties();
				properties.load(new FileInputStream(new File(path)));
				map.put(path, properties);
				result = map.get(path).getProperty(key);
			} else {
				result = map.get(path).getProperty(key);
			}
		} catch (IOException e) {
			LOG.error(e);
		}
		return result;
	}
}
