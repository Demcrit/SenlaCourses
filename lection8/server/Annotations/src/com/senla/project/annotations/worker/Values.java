package com.senla.project.annotations.worker;
import org.apache.logging.log4j.*;

public class Values {
	
	private final static Logger LOG = LogManager.getLogger(Values.class);
	private PropUtil props;

	public Values() {
		props = new PropUtil();
	}

	public Object getValue(String configName, String propertyName, Class<?> type) {
		Object value = null;
		String propsValue = props.getProperties(configName, propertyName);
		try {
			if (type.equals(String.class)) {
				value = new String();
				value = propsValue;
			} else if (type.equals(Integer.class) || type.equals(int.class)) {
				value = Integer.valueOf(propsValue);
			} else if (type.equals(Double.class) || type.equals(double.class)) {
				value = Double.valueOf(propsValue);
			} else if (type.equals(Float.class) || type.equals(float.class)) {
				value = Float.valueOf(propsValue);
			} else if (type.equals(Byte.class) || type.equals(byte.class)) {
				value = Byte.valueOf(propsValue);
			}
		} catch (Exception e) {
			LOG.error(e);
		}
		return value;
	}
}
