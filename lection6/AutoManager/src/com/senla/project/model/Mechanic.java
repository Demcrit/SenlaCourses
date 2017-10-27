package com.senla.project.model;

import java.io.Serializable;

public class Mechanic implements Serializable {
	
	private static final long serialVersionUID = 2474702210933977527L;
	private int id;
	private String fullName;
	private Order currenOrder;

	public Mechanic(String fullName) {
		this.fullName = fullName;
	}

	
	public Mechanic(Integer id,String fullName) {
		this.id = id;
		this.fullName = fullName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Order getCurrenOrder() {
		return currenOrder;
	}

	public void setCurrenOrder(Order currenOrder) {
		this.currenOrder = currenOrder;
	}

	@Override
	public String toString() {
		String str = String.format("Mechanic: %s %o", this.fullName, this.currenOrder);
		return str;
	}

}
