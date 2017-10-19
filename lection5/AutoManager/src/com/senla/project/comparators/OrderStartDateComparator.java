package com.senla.project.comparators;

import java.util.Comparator;

import com.senla.project.model.Order;
import com.senla.project.utils.ComparatorSafetyUtil;

public class OrderStartDateComparator implements Comparator<Order> {

	public int compare (Order o1,Order o2){
		int check = ComparatorSafetyUtil.checkNull(o1, o2);
		if (check == 2) {
		return (o1.getTask().getStartDate().before(o1.getTask().getStartDate())) ? -1 : 1;
	}
return check;
}
}