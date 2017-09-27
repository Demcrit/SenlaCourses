package com.senla.project.model;

import com.senla.project.model.enums.OrderStatus;

public class Order {
	
	private int id;
	private Mechanic mechanic;
	private WorkPlace workplace;
	private Task task;
	private OrderStatus orderstatus = OrderStatus.PERFORMED;
	
	public Order (Mechanic mechanic,WorkPlace workplace,Task task){
		this.mechanic = mechanic;
		this.workplace = workplace;
		this.task = task;
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

	public WorkPlace getWorkplace() {
		return workplace;
	}

	public void setWorkplace(WorkPlace workplace) {
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

	@Override
	public String toString() {
		return "Order [id=" + id + ", mechanic=" + mechanic + ", workplace=" + workplace + ", task=" + task
				+ ", orderstatus=" + orderstatus + "]";
	}
	
	
	

}
