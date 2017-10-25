package com.senla.project.serialize;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.senla.project.services.IService;
import com.senla.project.services.MechanicService;
import com.senla.project.services.OrderService;
import com.senla.project.services.WorkplaceService;

public class SerializatorUtl {

	private static Logger LOG = LogManager.getLogger(SerializatorUtl.class);

	public static Boolean save(MechanicService ms, OrderService os, WorkplaceService ws, String path) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path))) {
			out.writeObject(ms);
			out.writeObject(os);
			out.writeObject(ws);
			return true;
		} catch (IOException e) {
			LOG.error(e);
			return false;
		}
	}

	public static List<IService> load(String path) {
		List<IService> managers = new ArrayList<IService>();
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))) {
			managers.add((MechanicService) in.readObject());
			managers.add((OrderService) in.readObject());
			managers.add((WorkplaceService) in.readObject());
			return managers;
		} catch (IOException | ClassNotFoundException | NullPointerException e) {
			LOG.error(e);
			return null;
		}
	}
}
