package com.senla.interfaces;

import java.sql.SQLException;
import java.util.List;
import com.senla.exceptions.NoSuchDataException;
import com.senla.model.Order;
import com.senla.model.enums.OrderStatus;

public interface IOrderService {
	
	void addOrder(Order order) throws SQLException;
	
	void deleteOrder(int orderId) throws SQLException;
	
	List <Order> getOrders();
	
	List <Order> getOrdersByStatus(OrderStatus orderStatus);

	Order getDirectOrder(int orderNumber) throws NoSuchDataException;
	
}
