package com.senla.facade;

import java.sql.SQLException;
import java.util.List;
import com.senla.exceptions.NoSuchDataException;
import com.senla.model.Mechanic;
import com.senla.model.Order;
import com.senla.model.Workplace;
import com.senla.model.enums.OrderStatus;
import com.senla.model.enums.Sorting;

public interface IFacade {
	void addMechanic(String fullName);

	void deleteMechanic(int mechanicId);

	public Mechanic findFreeMechanic() throws NoSuchDataException;

	public List<Mechanic> sortMechanicsByName(Sorting sort);

	public List<Mechanic> sortMechanicsByWork(Sorting sort);

	public List<Mechanic> getAll(Sorting sort);

	public void addOrder(Order order) throws SQLException;

	public void deleteOrder(int orderId) throws SQLException;

	public List<Order> getOrders(Sorting sort);

	public List<Order> getOrdersByStatus(OrderStatus orderStatus);

	public Order getDirectOrder(int orderNumber) throws NoSuchDataException;

	public void addWorkplace(Workplace workplace);

	public void deleteWorkplace(int workplaceId);

	public Workplace findFreeWorkPlace() throws NoSuchDataException;
	
	public Mechanic getMechanic(int id) throws NoSuchDataException;
	
	public boolean importAll() throws NoSuchDataException;
	
	public boolean exportAll();
	
	public List<Order> sortOrdersByCompleteDateAction(Sorting sort);
	
	public List<Order> sortOrdersByPriceAction(Sorting sort);
	
	public List<Order> sortOrdersByRequestDateAction(Sorting sort);
	
	public List<Order> sortOrdersByStartDateAction(Sorting sort);
	
	public Mechanic cloneMechanic(int id);
	
	public Order cloneOrder(int id);
}
