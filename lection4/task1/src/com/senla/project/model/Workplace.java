package com.senla.project.model;

public class Workplace {
	private int number;
	private Order order;

	public int getId() {
		return number;
	}

	public void setId(int number) {
		this.number = number;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		String str = String.format("Worplace: %d %o", this.number, this.order);
		return str;
	}

}
