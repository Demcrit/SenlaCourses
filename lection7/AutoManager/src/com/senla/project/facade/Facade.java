package com.senla.project.facade;

import java.util.Date;
import java.util.List;

import com.senla.project.annotaions.ConfigProperty;
import com.senla.project.annotations.worker.Worker;
import com.senla.project.config.holder.Holder;
import com.senla.project.exceptions.NoSuchDataException;
import com.senla.project.injector.Inject;
import com.senla.project.interfaces.IMechanicService;
import com.senla.project.interfaces.IOrderService;
import com.senla.project.interfaces.IWorkplaceService;
import com.senla.project.model.Mechanic;
import com.senla.project.model.Order;
import com.senla.project.model.Workplace;
import com.senla.project.model.enums.OrderStatus;
import com.senla.project.serialize.SerializatorUtl;
import com.senla.project.serialize.Storage;

public class Facade implements IFacade {

	private static IFacade instance;
	private IMechanicService mechanicService;
	private IWorkplaceService workplaceService;
	private IOrderService orderService;

	private Facade() throws ReflectiveOperationException {
		Configuration c = null;
		Worker.getInstance().proccesing(c);
		mechanicService = (IMechanicService) Inject.getClassInstance(IMechanicService.class);
		orderService = (IOrderService) Inject.getClassInstance(IOrderService.class);
		workplaceService = (IWorkplaceService) Inject.getClassInstance(IWorkplaceService.class);

	}

	public static IFacade getInstance() throws ReflectiveOperationException {
		if (instance == null) {
			instance = new Facade();
		}
		return instance;
	}

	public void addMechanic(Mechanic mechanic) {
		mechanicService.addMechanic(mechanic);

	}

	public void deleteMechanic(Mechanic mechanic) {
		mechanicService.deleteMechanic(mechanic);

	}

	public Mechanic findFreeMechanic() {
		return mechanicService.findFreeMechanic();
	}

	public List<Mechanic> sortMechanicsByName() {
		return mechanicService.sortMechanicsByName();
	}

	public List<Mechanic> sortMechanicsByWork() {
		return mechanicService.sortMechanicsByWork();
	}

	public List<Mechanic> getAll() {
		return mechanicService.getAll();
	}

	public void addOrder(Order order) {
		orderService.addOrder(order);

	}

	public void deleteOrder(Order order) {
		orderService.deleteOrder(order);
	}

	public void moveOrder(Order order, int days) {
		orderService.moveOrder(order, days);

	}

	public List<Order> getOrders() {
		return orderService.getOrders();
	}

	public List<Order> getOrdersByStatus(OrderStatus orderStatus) {
		return orderService.getOrdersByStatus(orderStatus);
	}

	public Order getDirectOrder(int orderNumber) throws NoSuchDataException {
		return orderService.getDirectOrder(orderNumber);
	}

	public void addWorkplace(Workplace workplace) {
		workplaceService.addWorkplace(workplace);

	}

	public void deleteWorkplace(Workplace workplace) {
		workplaceService.deleteWorkplace(workplace);

	}

	public Workplace findFreeWorkPlace() throws NoSuchDataException {
		return workplaceService.findFreeWorkPlace();
	}

	@Override
	public List<Workplace> getFreePlacesInDate(Date date) {
		return orderService.getFreePlacesInDate(date);
	}

	@Override
	public Mechanic getMechanic(int id) throws NoSuchDataException {
		return mechanicService.getMechanic(id);
	}

	@Override
	public int getNextOrderId() {
		return orderService.getNextOrdeId();
	}

	public boolean importAll() throws NoSuchDataException {
		return mechanicService.importAll();
	}

	public boolean exportAll() {
		return mechanicService.exportAll();
	}

	public void serialize() {
		String path = Holder.getInstance().getDBPath();
		Storage store = new Storage();
		store.setMechanics(mechanicService.getMechanics());
		store.setOrders(orderService.getOrders());
		store.setWorkplaces(workplaceService.getWorkplaces());
		SerializatorUtl.writeObject(store, path);
	}

	public void deserialize() {
		String path = Holder.getInstance().getDBPath();
		Storage store = (Storage) SerializatorUtl.readObject(path);
		if (store == null) {
			return;
		}
		mechanicService.setMechanics(store.getMechanics());
		orderService.setOrder(store.getOrders());
		workplaceService.setWorkplaces(store.getWorkplaces());
	}

	public class Configuration {
		@ConfigProperty(configName = "prop.properties", propertyName = "class.name", type = String.class)
		private String s;
		@ConfigProperty(configName = "prop.properties", propertyName = "class.value", type = Integer.class)
		private int a;
		@ConfigProperty(configName = "prop.properties", propertyName = "class.check", type = Boolean.class)
		private boolean check;

	}

}
