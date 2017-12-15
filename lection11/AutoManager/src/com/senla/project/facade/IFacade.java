package com.senla.project.facade;

import java.sql.SQLException;
import java.util.List;
import com.senla.project.exceptions.NoSuchDataException;
import com.senla.project.model.Mechanic;
import com.senla.project.model.Order;
import com.senla.project.model.Workplace;
import com.senla.project.model.enums.OrderStatus;

public interface IFacade {
	void addMechanic(String fullName);

	void deleteMechanic(int mechanicId);

	public Mechanic findFreeMechanic() throws NoSuchDataException;

	public List<Mechanic> sortMechanicsByName();

	public List<Mechanic> sortMechanicsByWork();

	public List<Mechanic> getAll();

	public void addOrder(Order order);

	public void deleteOrder(int orderId) throws SQLException;

	public List<Order> getOrders();

	public List<Order> getOrdersByStatus(OrderStatus orderStatus);

	public Order getDirectOrder(int orderNumber) throws NoSuchDataException;

	public void addWorkplace(Workplace workplace);

	public void deleteWorkplace(int workplaceId);

	public Workplace findFreeWorkPlace() throws NoSuchDataException;
	
	public Mechanic getMechanic(int id) throws NoSuchDataException;
	
	public boolean importAll() throws NoSuchDataException;
	
	public boolean exportAll();
	
}
