package com.senla.project.interfaces;

import java.util.List;

import com.senla.project.exceptions.NoSuchDataException;
import com.senla.project.model.Order;
import com.senla.project.model.enums.OrderStatus;

public interface OrderService {
	
	void addOrder(Order order);
	void deleteOrder(Order order);
	void moveOrder (Order order, int days);
	Order showOrder(int id) throws NoSuchDataException;
	List <Order> getOrders();
	List <Order> getAllOrders(OrderStatus orderStatus);
	
	

}
