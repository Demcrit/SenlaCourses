package com.senla.project.facade;

import java.sql.SQLException;
import java.util.List;
import com.senla.project.annotaions.ConfigProperty;
import com.senla.project.annotations.worker.Worker;
import com.senla.project.exceptions.NoSuchDataException;
import com.senla.project.injector.Inject;
import com.senla.project.interfaces.IMechanicService;
import com.senla.project.interfaces.IOrderService;
import com.senla.project.interfaces.IWorkplaceService;
import com.senla.project.model.Mechanic;
import com.senla.project.model.Order;
import com.senla.project.model.Workplace;
import com.senla.project.model.enums.OrderStatus;

public class Facade implements IFacade {

	private static IFacade instance;
	private IMechanicService mechanicService;
	private IWorkplaceService workplaceService;
	private IOrderService orderService;

	@ConfigProperty(configName = "prop.properties", propertyName = "system.path", type = String.class)
	private String path;

	private Facade() throws ReflectiveOperationException {
		Worker.getInstance().proccesing(this);
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

	public void addMechanic(String fullName) {
		mechanicService.addMechanic(fullName);

	}

	public void deleteMechanic(int mechanicId) {
		mechanicService.deleteMechanic(mechanicId);

	}

	public Mechanic findFreeMechanic() throws NoSuchDataException {
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

	public void deleteOrder(int orderId) throws SQLException {
		orderService.deleteOrder(orderId);
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

	public void deleteWorkplace(int workplaceId) {
		workplaceService.deleteWorkplace(workplaceId);

	}

	public Workplace findFreeWorkPlace() throws NoSuchDataException {
		return workplaceService.findFreeWorkPlace();
	}

	@Override
	public Mechanic getMechanic(int id) throws NoSuchDataException {
		return mechanicService.getMechanic(id);
	}

	public boolean importAll() throws NoSuchDataException {
		return mechanicService.importAll();
	}

	public boolean exportAll() {
		return mechanicService.exportAll();
	}

}
