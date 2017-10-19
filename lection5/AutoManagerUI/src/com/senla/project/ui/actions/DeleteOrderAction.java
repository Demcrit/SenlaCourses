package com.senla.project.ui.actions;

import com.senla.project.ui.api.IAction;
import static com.senla.project.ui.utils.GeneralScanner.*;
import static com.senla.project.utils.PrintUtil.*;
import com.senla.project.exceptions.NoSuchDataException;
import com.senla.project.model.enums.*;
import com.senla.project.facade.Facade;
import com.senla.project.model.Order;

public class DeleteOrderAction implements IAction {

	private final String ORDER_ID = "Enter order id to delete";

	@Override
	public void execute() {
		printMessage(ORDER_ID);
		try {
			Order order = Facade.getInstance().getDirectOrder(nextInt());
			order.setOrderstatus(OrderStatus.DELETED);
		} catch (NoSuchDataException e) {
			printMessage(e.getMessage());
		}
	}

}
