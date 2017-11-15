package com.senla.project.ui.actions;

import com.senla.project.exceptions.NoSuchDataException;
import com.senla.project.facade.Facade;
import com.senla.project.model.Order;
import com.senla.project.model.enums.OrderStatus;
import com.senla.project.ui.api.IAction;
import static com.senla.project.utils.PrintUtil.*;
import static com.senla.project.ui.utils.GeneralScanner.*;

public class ReadyOrderAction implements IAction {

	private static final String ORDER_ID = "Order id to make ready:";
	
	@Override
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
