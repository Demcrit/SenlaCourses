package com.senla.project.services;

import java.util.Date;
import java.util.List;

import com.senla.project.exceptions.NoSuchDataException;
import com.senla.project.interfaces.IOrderService;
import com.senla.project.model.Order;
import com.senla.project.model.Workplace;
import com.senla.project.model.enums.OrderStatus;
import com.senla.project.stores.OrderStore;

public class OrderService implements IOrderService {

	private OrderStore orderStore = new OrderStore();

	@Override
	public void addOrder(Order order) {
		synchronized (orderStore) {
			orderStore.addOrder(order);
		}
	}

	@Override
	public void deleteOrder(Order order) {
		synchronized (orderStore) {
			orderStore.deleteOrder(order);
		}
	}

	@Override
	public void moveOrder(Order order, int days) {
		orderStore.moveOrder(order, days);

	}

	@Override
	public List<Order> getOrders() {
		synchronized (orderStore) {
			return orderStore.getOrders();
		}
	}

	@Override
	public List<Order> getOrdersByStatus(OrderStatus orderStatus) {
		return orderStore.getOrderByStatus(orderStatus);
	}

	public Order getDirectOrder(int orderNumber) throws NoSuchDataException {
		synchronized (orderStore) {
			return orderStore.getDirectOrder(orderNumber);
		}
	}

	public List<Workplace> getFreePlacesInDate(Date date) {
		return orderStore.getFreePlacesInDate(date);
	}

	public int getNextOrdeId() {
		return orderStore.getNextId();
	}

	public List<Order> getOrder() {
		return orderStore.getOrders();
	}

	public void setOrder(List<Order> orders) {
		orderStore.setOrders(orders);
	}

}
