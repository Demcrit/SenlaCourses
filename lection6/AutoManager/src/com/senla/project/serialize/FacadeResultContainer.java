package com.senla.project.serialize;

import java.util.List;

import com.senla.project.model.Mechanic;
import com.senla.project.model.Order;

public class FacadeResultContainer {
	private List<Mechanic> resultMechanics;
	private List<Order> resultOrders;
	
	public FacadeResultContainer(List<Mechanic> resultMechanics, List<Order> resultOrders) {
		this.resultMechanics = resultMechanics;
		this.resultOrders = resultOrders;
			}

	public List<Mechanic> getResultMechanics() {
		return resultMechanics;
	}

	public void setResultMechanics(List<Mechanic> resultMechanics) {
		this.resultMechanics = resultMechanics;
	}

	public List<Order> getResultOrders() {
		return resultOrders;
	}

	public void setResultOrders(List<Order> resultOrders) {
		this.resultOrders = resultOrders;
	}

	}
