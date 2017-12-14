package com.senla.project.interfaces;

import java.util.List;
import com.senla.project.exceptions.NoSuchDataException;
import com.senla.project.model.Order;
import com.senla.project.model.enums.OrderStatus;

public interface IOrderService {
	
	void addOrder(Order order);
	
	void deleteOrder(int orderId);
	
	List <Order> getOrders();
	
	List <Order> getOrdersByStatus(OrderStatus orderStatus);

	Order getDirectOrder(int orderNumber) throws NoSuchDataException;
	
}
