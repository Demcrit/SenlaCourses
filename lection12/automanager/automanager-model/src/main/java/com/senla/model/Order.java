package com.senla.model;

import java.io.Serializable;

import com.senla.model.enums.OrderStatus;

public class Order implements Cloneable, Serializable {

	private static final long serialVersionUID = -5834603427039888853L;
	private int id;
	private Mechanic mechanic;
	private Workplace workplace;
	private Task task;
	private OrderStatus orderstatus = OrderStatus.PERFORMED;

	public Order(Mechanic mechanic, Workplace workplace, Task task) {
		this.mechanic = mechanic;
		this.workplace = workplace;
		this.task = task;
	}

	public Order() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Mechanic getMechanic() {
		return mechanic;
	}

	public void setMechanic(Mechanic mechanic) {
		this.mechanic = mechanic;
	}

	public Workplace getWorkplace() {
		return workplace;
	}

	public void setWorkplace(Workplace workplace) {
		this.workplace = workplace;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public OrderStatus getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(OrderStatus orderstatus) {
		this.orderstatus = orderstatus;
	}

	public Order clone() throws CloneNotSupportedException {
		return (Order) super.clone();
	}

	@Override
	public String toString() {
		String str = String.format("Number: ", "Mechanic: ", "Workplace: ", "Task: ", "OrderStatus: ", this.id,
				this.mechanic, this.workplace, this.task, this.orderstatus);
		return str;
	}

}
