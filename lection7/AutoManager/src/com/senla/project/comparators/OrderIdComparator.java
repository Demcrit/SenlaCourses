package com.senla.project.comparators;

import java.util.Comparator;

import com.senla.project.model.Order;

public class OrderIdComparator implements Comparator<Order> {

	@Override
	public int compare(Order o1, Order o2) {
		return (o1.getId() < o2.getId()) ? 1 : -1;
	}
	

}
