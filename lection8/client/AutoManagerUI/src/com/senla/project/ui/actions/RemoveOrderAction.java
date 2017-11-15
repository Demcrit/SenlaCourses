package com.senla.project.ui.actions;

import com.senla.project.ui.api.IAction;
import static com.senla.project.utils.PrintUtil.*;

import com.senla.project.exceptions.NoSuchDataException;
import com.senla.project.facade.Facade;
import com.senla.project.model.Order;

import static com.senla.project.ui.utils.GeneralScanner.*;
public class RemoveOrderAction implements IAction {

	private static final String ORDER_ID = "Order ID to remove:";

	@Override
	public void execute() throws ReflectiveOperationException {
		printMessage(ORDER_ID);
		try {
			Order order = Facade.getInstance().getDirectOrder(nextInt());
			Facade.getInstance().deleteOrder(order);
			printMessage("Order successfull removed");
		} catch (NoSuchDataException e) {
			printMessage(e.getMessage());
		}
	}

}
