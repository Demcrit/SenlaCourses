package com.senla.project.facade;

import java.util.Date;
import java.util.List;
import com.senla.project.exceptions.NoSuchDataException;
import com.senla.project.model.Mechanic;
import com.senla.project.model.Order;
import com.senla.project.model.Workplace;
import com.senla.project.model.enums.OrderStatus;
import com.senla.project.services.*;

public class Facade implements IFacade {

	private static IFacade instance;
	private Facade() {}
	public static IFacade getInstance() {
		if (instance==null) {
			instance = new Facade();
		}
		return instance;
	}

	private MechanicService mechanicService = new MechanicService();
	private WorkplaceService workplaceService = new WorkplaceService();
	private OrderService orderService = new OrderService();

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
}
