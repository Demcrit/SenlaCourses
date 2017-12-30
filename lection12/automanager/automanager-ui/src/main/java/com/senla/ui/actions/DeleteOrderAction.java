package com.senla.ui.actions;

import static com.senla.utils.PrintUtil.*;
import static com.senla.ui.utils.GeneralScanner.*;

import com.senla.exceptions.NoSuchDataException;
import com.senla.model.enums.*;
import com.senla.ui.api.IAction;
import com.senla.facade.Facade;
import com.senla.model.Order;

public class DeleteOrderAction implements IAction {

	private final String ORDER_ID = "Enter order id to delete";

	public void execute() throws ReflectiveOperationException {
		printMessage(ORDER_ID);
		try {
			Order order = Facade.getInstance().getDirectOrder(nextInt());
			order.setOrderstatus(OrderStatus.DELETED);
		} catch (NoSuchDataException e) {
			printMessage(e.getMessage());
		}
	}

}
