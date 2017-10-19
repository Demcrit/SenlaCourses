package com.senla.project.model;

public class Workplace {
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
