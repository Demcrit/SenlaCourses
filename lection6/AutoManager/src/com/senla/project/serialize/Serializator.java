package com.senla.project.serialize;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.*;

import com.senla.project.model.Mechanic;
import com.senla.project.model.Order;

public class Serializator {
	private Logger LOG = Logger.getLogger(Serializator.class.getSimpleName());

	private static final String IO_ERROR = "IO Error";
	private static final String NO_DB_FILE = "DB File did not find";

	private String dbPath;

	public Serializator(String dbPath) throws FileNotFoundException {

		this.dbPath = dbPath;

		if (!(new File(dbPath)).exists()) {
			LOG.fatal(NO_DB_FILE);
			throw new FileNotFoundException();
		}
	}

	public FacadeResultContainer getLists() {

		try (FileInputStream fileInputStream = new FileInputStream(dbPath);
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

			List<Mechanic> mechanics = (List<Mechanic>) objectInputStream.readObject();
			List<Order> orders = (List<Order>) objectInputStream.readObject();
			return new FacadeResultContainer(mechanics, orders);

		} catch (EOFException e) {
			return new FacadeResultContainer(new ArrayList<>(), new ArrayList<>());
		} catch (IOException e) {
			LOG.error("IO Exception throwed in getLists");
		} catch (ClassNotFoundException e) {
			LOG.fatal("Serialization fail");
		}
		return new FacadeResultContainer(new ArrayList<>(), new ArrayList<>());
	}

	public void saveToFile(FacadeResultContainer container) {

		FacadeResultContainer containerToWrite = (FacadeResultContainer) container;

		try (FileOutputStream fileOutputStream = new FileOutputStream(dbPath);
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);) {

			objectOutputStream.writeObject(containerToWrite.getResultMechanics());
			objectOutputStream.writeObject(containerToWrite.getResultOrders());

		} catch (FileNotFoundException e) {
			LOG.fatal(NO_DB_FILE);
		} catch (IOException e) {
			LOG.error(IO_ERROR);
		}
	}
}
