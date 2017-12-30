package com.senla.ui.actions;

import com.senla.exceptions.NoSuchDataException;
import com.senla.facade.Facade;
import com.senla.model.Order;
import com.senla.model.enums.OrderStatus;
import com.senla.ui.api.IAction;

import static com.senla.utils.PrintUtil.*;
import static com.senla.ui.utils.GeneralScanner.*;

public class ReadyOrderAction implements IAction {

	private static final String ORDER_ID = "Order id to make ready:";
	
	public void execute() throws ReflectiveOperationException {
		printMessage(ORDER_ID);
		try {
			Order order = Facade.getInstance().getDirectOrder(nextInt());
			order.setOrderstatus(OrderStatus.READY);
		} catch (NoSuchDataException e) {
			printMessage(e.getMessage());
		}	
		
	}

}
