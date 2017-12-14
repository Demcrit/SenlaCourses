package com.senla.project.model;

import java.util.Date;

public class Task {
	private int id;
	private String commonTask;
	private Date orderDate;
	private Date startDate;
	private Date endDate;
	private double price;
	
	public Task(int id,String commonTask,Date orderDate,Date startDate,Date endDate,double price){
		this.id = id;
		this.commonTask = commonTask;
		this.orderDate = orderDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
			}
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
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
		String str = String.format("CommonTask: ","OrderDate: ","StartDate: ","EndDate: ","Price: ", this.commonTask,
				this.orderDate,this.startDate,this.endDate,this.price);
		return str;
	}
	
	
	}
