package com.senla.project.serialize;

import java.io.Serializable;
import java.util.List;
import com.senla.project.model.*;

public class Storage implements Serializable {

	private static final long serialVersionUID = -1504872599845758921L;
	private List<Mechanic> mechanics;
	private List<Order> orders;
	private List<Workplace> workplaces;

	public List<Mechanic> getMechanics() {
		return mechanics;
	}

	public void setMechanics(List<Mechanic> mechanics) {
		this.mechanics = mechanics;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Workplace> getWorkplaces() {
		return workplaces;
	}

	public void setWorkplaces(List<Workplace> workplaces) {
		this.workplaces = workplaces;
	}

}
