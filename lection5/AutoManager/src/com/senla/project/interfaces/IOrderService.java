package com.senla.project.interfaces;

import java.util.List;

import com.senla.project.model.Order;
import com.senla.project.model.enums.OrderStatus;

public interface IOrderService {
	
	void addOrder(Order order);
	
	void deleteOrder(Order order);
	
	void moveOrder (Order order, int days);
	
	List <Order> getOrders();
	
	List <Order> getOrdersByStatus(OrderStatus orderStatus);
	
}
