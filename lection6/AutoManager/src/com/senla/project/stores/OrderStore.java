package com.senla.project.stores;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.senla.project.model.Order;
import com.senla.project.model.Workplace;
import com.senla.project.model.enums.OrderStatus;
import com.senla.project.comparators.OrderIdComparator;
import com.senla.project.comparators.OrderStartDateComparator;
import com.senla.project.exceptions.NoSuchDataException;

public class OrderStore {
	private List<Order> orders;
	private int nextId;

	/*public OrderStore() {
		if (!orders.isEmpty()) {
			List<Order> sortedList = new ArrayList<>(orders);
			Collections.sort(sortedList, new OrderIdComparator());
			nextId = (sortedList.get(0).getId()) + 1;
		} else {
			nextId = 1;
		}
	}
*/
	public List<Order> getOrders() {
		return orders;
	}

	public int getNextId() {
		return nextId;
	}

	public void addOrder(Order order) {
		order.setId(nextId);
		nextId++;
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

	public List<Workplace> getFreePlacesInDate(Date date) {
		WorkplaceStore wrk = new WorkplaceStore();
		List<Workplace> list = new ArrayList<>();

		for (Workplace workPlace : wrk.getWorkplaces()) {
			if (workPlace.getOrder() == null) {
				list.add(workPlace);
			} else if (workPlace.getOrder().getTask().getEndDate().before(date)
					&& workPlace.getOrder().getTask().getStartDate().after(date)) {
				list.add(workPlace);
			}
		}
		return list;
	}
}
