package com.senla.project.model;

public class Mechanic {
private String fullName;
private Order currenOrder;

public Mechanic (String fullName,Order currentOrder){
	this.fullName = fullName;
	this.currenOrder = currentOrder;
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
	String str = String.format("Mechanic: %s %o", this.fullName,this.currenOrder);
	return str;
}



}
