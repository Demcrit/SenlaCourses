package com.senla.project.model;

public class WorkPlace {
private int id;
private Order order;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Order getOrder() {
	return order;
}
public void setOrder(Order order) {
	this.order = order;
}
@Override
public String toString() {
	return "WorkPlace [id=" + id + ", order=" + order + "]";
}


}
