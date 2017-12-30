package com.senla.ui.actions;

import com.senla.facade.Facade;
import com.senla.model.Order;
import com.senla.ui.api.IAction;

import java.util.List;

public class GetAllOrdersAction implements IAction {

	public void execute() throws ReflectiveOperationException {
		printList(Facade.getInstance().getOrders());
	}

	private void printList(List<Order> object) {
		for (Object item : object) {
			System.out.println(item.toString());

		}

	}
}