package com.senla.ui.actions;

import org.apache.log4j.*;

import static com.senla.utils.PrintUtil.*;
import static com.senla.ui.utils.GeneralScanner.*;

import com.senla.facade.*;
import com.senla.model.*;
import com.senla.model.enums.OrderStatus;
import com.senla.ui.api.IAction;
import com.senla.exceptions.NoSuchDataException;

public class CancelOrderAction implements IAction {

	private static final String ORDER_ID = "Order Id to cancel:";
	
	public void execute() throws ReflectiveOperationException {
		
		printMessage(ORDER_ID);
		try {
			Order order = Facade.getInstance().getDirectOrder(nextInt());
			order.setOrderstatus(OrderStatus.CANCELED);
		} catch (NoSuchDataException e) {
			Logger logger = (Logger) LogManager.getLogger(CancelOrderAction.class);
			logger.error(e.getMessage());
			printMessage(e.getMessage());
		}
	}
		
	}
