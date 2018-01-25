package com.senla.facade;

import java.sql.SQLException;
import java.util.List;

import com.senla.injector.Inject;
import com.senla.interfaces.IMechanicService;
import com.senla.interfaces.IOrderService;
import com.senla.interfaces.IWorkplaceService;
import com.senla.annotations.worker.Worker;
import com.senla.exceptions.NoSuchDataException;
import com.senla.model.Mechanic;
import com.senla.model.Order;
import com.senla.model.Workplace;
import com.senla.model.enums.OrderStatus;
import com.senla.model.enums.Sorting;
import com.senla.services.MechanicService;

public class Facade implements IFacade {

	private static IFacade instance;
	private IMechanicService mechanicService = new MechanicService();
	private IWorkplaceService workplaceService;
	private IOrderService orderService;

	private Facade() {
		Worker.getInstance().proccesing(this);
		// mechanicService = (IMechanicService)
		// Inject.getClassInstance(IMechanicService.class);
		orderService = (IOrderService) Inject.getClassInstance(IOrderService.class);
		workplaceService = (IWorkplaceService) Inject.getClassInstance(IWorkplaceService.class);

	}

	public static IFacade getInstance() {
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

	public List<Mechanic> sortMechanicsByName(Sorting sort) {
		return mechanicService.sortMechanicsByName(sort);
	}

	public List<Mechanic> sortMechanicsByWork(Sorting sort) {
		return mechanicService.sortMechanicsByWork(sort);
	}

	public List<Mechanic> getAll(Sorting sort) {
		return mechanicService.getAll(sort);
	}

	public void addOrder(Order order) throws SQLException {
		orderService.addOrder(order);

	}

	public void deleteOrder(int orderId) throws SQLException {
		orderService.deleteOrder(orderId);
	}

	public List<Order> getOrders(Sorting sort) {
		return orderService.getOrders(sort);
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

	public List<Order> sortOrdersByCompleteDateAction(Sorting sort) {
		return orderService.sortOrdersByCompleteDateAction(sort);
	}

	public List<Order> sortOrdersByPriceAction(Sorting sort) {
		return orderService.sortOrdersByPriceAction(sort);
	}

	public List<Order> sortOrdersByRequestDateAction(Sorting sort) {
		return orderService.sortOrdersByRequestDateAction(sort);
	}

	public List<Order> sortOrdersByStartDateAction(Sorting sort) {
		return orderService.sortOrdersByStartDateAction(sort);
	}

	@Override
	public Mechanic cloneMechanic(int id) {
		return mechanicService.cloneMechanic(id);

	}

	@Override
	public Order cloneOrder(int id) {
		return orderService.cloneOrder(id);
	}

}
