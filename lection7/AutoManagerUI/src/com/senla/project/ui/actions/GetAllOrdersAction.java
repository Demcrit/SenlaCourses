package com.senla.project.ui.actions;

import com.senla.project.facade.Facade;
import com.senla.project.model.Order;
import com.senla.project.ui.api.IAction;
import java.util.List;

public class GetAllOrdersAction implements IAction {

	@Override
	public void execute() {
		printList(Facade.getInstance().getOrders());
	}

	private void printList(List<Order> object) {
		for (Object item : object) {
			System.out.println(item.toString());

		}

	}
}