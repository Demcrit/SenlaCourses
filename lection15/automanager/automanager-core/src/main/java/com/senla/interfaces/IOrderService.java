package com.senla.interfaces;

import java.sql.SQLException;
import java.util.List;
import com.senla.exceptions.NoSuchDataException;
import com.senla.model.Order;
import com.senla.model.enums.OrderStatus;
import com.senla.model.enums.Sorting;

public interface IOrderService {
	
	void addOrder(Order order) throws SQLException;
	
	void deleteOrder(int orderId) throws SQLException;
	
	List <Order> getOrders(Sorting sort);
	
	List <Order> getOrdersByStatus(OrderStatus orderStatus);

	Order getDirectOrder(int orderNumber) throws NoSuchDataException;
	
	public List<Order> sortOrdersByCompleteDateAction(Sorting sort);
	
	public List<Order> sortOrdersByPriceAction(Sorting sort);
	
	public List<Order> sortOrdersByRequestDateAction(Sorting sort);
	
	public List<Order> sortOrdersByStartDateAction(Sorting sort);
	
	public Order cloneOrder(int id);
	
}
