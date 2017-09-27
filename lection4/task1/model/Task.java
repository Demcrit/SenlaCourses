package com.senla.project.model;

import java.util.Date;

public class Task {
	
	private String commonTask;
	private Date orderDate;
	private Date startDate;
	private Date endDate;
	private double price;
	
	public Task(String commonTask,Date orderDate,Date startDate,Date endDate,double price){
		this.commonTask = commonTask;
		this.orderDate = orderDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
			}
	
	public String getCommonTask() {
		return commonTask;
	}
	public void setCommonTask(String commonTask) {
		this.commonTask = commonTask;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date date) {
		this.endDate = date;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Task [commonTask=" + commonTask + ", orderDate=" + orderDate + ", startDate=" + startDate + ", endDate="
				+ endDate + ", price=" + price + "]";
	}
	
	
	}
