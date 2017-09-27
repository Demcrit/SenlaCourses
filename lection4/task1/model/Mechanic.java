package com.senla.project.model;

public class Mechanic {
private int id;
private String fullName;
private Order currenOrder;

public Mechanic (int id,String fullName,Order currentOrder){
	this.id = id;
	this.fullName = fullName;
	this.currenOrder = currentOrder;
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
	return "Mechanic [id=" + id + ", fullName=" + fullName + ", currenOrder=" + currenOrder + "]";
}



}
