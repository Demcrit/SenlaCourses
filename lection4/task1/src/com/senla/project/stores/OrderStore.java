package com.senla.project.stores;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.senla.project.model.Order;
import com.senla.project.model.enums.OrderStatus;
import com.senla.project.comparators.OrderStartDateComparator;
import com.senla.project.exceptions.NoSuchDataException;

public class OrderStore {
	private List<Order> orders;

	public List<Order> getOrders() {
		return orders;
	}

	public void addOrder(Order order) {
		orders.add(order);

	}

	public void deleteOrder(Order order) {
		orders.remove(order);
	}

	public void moveOrder(Order order, int days) {

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

	public Order getDirectOrder(int orderNumber) throws NoSuchDataException {
		for (Order order : orders) {
			if (order.getId() == orderNumber) {
				return order;
			}
		}
		throw new NoSuchDataException();
	}

	public List<Order> getOrderByStatus(OrderStatus orderStatus) {

		List<Order> list = new ArrayList<>(orders);

		for (Order order : orders) {
			if (order.getOrderstatus() == orderStatus) {
				list.add(order);
			}
		}
		return list;
	}
}
