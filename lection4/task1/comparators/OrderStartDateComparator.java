package com.senla.project.comparators;

import java.util.Comparator;

import com.senla.project.model.Order;

public class OrderStartDateComparator implements Comparator<Order>{
	
	public int compare (Order o1,Order o2){
	return (o1.getTask().getStartDate().before(o1.getTask().getStartDate())) ? -1 : 1;
	}

}
