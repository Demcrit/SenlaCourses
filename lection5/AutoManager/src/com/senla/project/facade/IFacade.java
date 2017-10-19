package com.senla.project.facade;

import java.util.Date;
import java.util.List;

import com.senla.project.exceptions.NoSuchDataException;
import com.senla.project.model.Mechanic;
import com.senla.project.model.Order;
import com.senla.project.model.Workplace;
import com.senla.project.model.enums.OrderStatus;

public interface IFacade {
	void addMechanic(Mechanic mechanic);

	void deleteMechanic(Mechanic mechanic);

	public Mechanic findFreeMechanic();

	public List<Mechanic> sortMechanicsByName();

	public List<Mechanic> sortMechanicsByWork();

	public List<Mechanic> getAll();

	public void addOrder(Order order);

	public void deleteOrder(Order order);

	public void moveOrder(Order order, int days);

	public List<Order> getOrders();

	public List<Order> getOrdersByStatus(OrderStatus orderStatus);

	public Order getDirectOrder(int orderNumber) throws NoSuchDataException;

	public void addWorkplace(Workplace workplace);

	public void deleteWorkplace(Workplace workplace);

	public Workplace findFreeWorkPlace() throws NoSuchDataException;
	
	public List<Workplace> getFreePlacesInDate(Date date);
	public Mechanic getMechanic(int id) throws NoSuchDataException;

}
