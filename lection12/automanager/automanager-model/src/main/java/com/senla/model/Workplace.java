package com.senla.model;

import java.io.Serializable;

public class Workplace implements Serializable {
	
	private static final long serialVersionUID = -7998844242514648208L;
	private int id;
	private Order order;

	public void WorkPlace(int id, Order order) {
		this.id = id;
		this.order = order;
	}

	public int getId() {
		return id;
	}

	public void setId(int number) {
		this.id = number;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		String str = String.format("Worplace: %d %o", this.id, this.order);
		return str;
	}

}
