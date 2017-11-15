package com.senla.project.serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SerializatorUtl {

	private static final Logger LOG = LogManager.getLogger(SerializatorUtl.class);

	public static void writeObject(Object object, String filePath) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
			out.writeObject(object);
			out.flush();
		} catch (IOException e) {
			LOG.error(e.getStackTrace());
		}
	}

	public static Object readObject(String filePath) {
		Object object = null;
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
			object = in.readObject();
		} catch (IOException e) {
			LOG.error(e.getStackTrace());
			return null;
		} catch (ClassNotFoundException e) {
			LOG.error(e.getStackTrace());
			return null;
		}

		return object;
	}
}
