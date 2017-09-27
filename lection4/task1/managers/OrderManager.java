package com.senla.project.managers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.senla.project.model.Order;
import com.senla.project.interfaces.OrderService;
import com.senla.project.model.enums.OrderStatus;
import com.senla.project.model.Garage;
import com.senla.project.model.WorkPlace;
import com.senla.project.comparators.OrderStartDateComparator;
import com.senla.project.exceptions.NoSuchDataException;


public class OrderManager implements OrderService {

	private int countId;
	private List<Order> orders;
	
	public int getCountId() {
		return countId;
	}
	public List<Order> getOrders() {
		return orders;
	}
	
	public void addOrder(Order order){
		order.setId(countId);
		countId++;
		orders.add(order);
		
	}
	
	public void deleteOrder(Order order) {
		orders.remove(order);
	}
	
	public void moveOrder(Order order, int days){
		
		List<Order> list = returnOrdersSortedByComparator(new OrderStartDateComparator());
		Calendar cal = Calendar.getInstance();
		boolean flag = false;

		for (Order orderItem : list) {

			// Find delayed order and set new complete date
			if (orderItem.equals(order)) {
				flag = true;
				cal.setTime(orderItem.getTask().getEndDate());
				cal.add(Calendar.DAY_OF_MONTH, days);
				orderItem.getTask().setEndDate(cal.getTime());
				continue;
			}
			if (flag) {
				// rewrite start date to forwarded date
				cal.setTime(orderItem.getTask().getStartDate());
				cal.add(Calendar.DAY_OF_MONTH, days);
				orderItem.getTask().setStartDate(cal.getTime());

				// rewrite complete date to forwarded date
				cal.setTime(orderItem.getTask().getEndDate());
				cal.add(Calendar.DAY_OF_MONTH, days);
				orderItem.getTask().setEndDate(cal.getTime());
			}
		}
		orders = list;
	}
	
	public List<Order> returnOrdersSortedByComparator(Comparator<Order> comparator) {

		List<Order> list = new ArrayList<>(orders);
		Collections.sort(list, comparator);
		return list;

	}
	
	public Order showOrder(int orderId) throws NoSuchDataException {
		for (Order order:orders) {
			if (order.getId()==orderId){
				return order;
			}
		}
	throw new NoSuchDataException();
	}
	
	public List<Order> getOrderByStatus(List<Order> orders, OrderStatus status) {

		List<Order> statusOrders = new ArrayList<>();

		for (Order order : orders) {
			if (order.getOrderstatus() == status) {
				statusOrders.add(order);
			}
		}
		return statusOrders;
	}
	
	public List<Order> getAllOrders(OrderStatus orderStatus) {

		List<Order> list = new ArrayList<>();

		for (Order order : orders) {
			if (order.getOrderstatus() == orderStatus) {
				list.add(order);
			}
		}
		return list;
	}
	
	public List<WorkPlace> getFreePlacesInDate(Date date, List<Garage> garages) {

		List<WorkPlace> list = new ArrayList<>();

		for (Garage garage : garages) {
			for (WorkPlace workPlace : garage.getWorkplace()) {

				if (workPlace.getOrder() == null) {
					list.add(workPlace);
				} else if (workPlace.getOrder().getTask().getEndDate().before(date)
						&& workPlace.getOrder().getTask().getStartDate().after(date)) {
					list.add(workPlace);
				}
			}
		}
		return list;
	}
}
