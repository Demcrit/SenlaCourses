package com.senla.project.ui.actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.*;
import com.senla.project.ui.api.IAction;
import static com.senla.project.utils.PrintUtil.*;
import com.senla.project.facade.*;
import com.senla.project.model.*;
import com.senla.project.model.enums.OrderStatus;
import static com.senla.project.ui.utils.GeneralScanner.*;
import com.senla.project.exceptions.NoSuchDataException;

public class CancelOrderAction implements IAction {

	private static final String ORDER_ID = "Order Id to cancel:";
	
	@Override
	public void execute() {
		
		printMessage(ORDER_ID);
		try {
			Order order = Facade.getFACADE().getDirectOrder(nextInt());
			order.setOrderstatus(OrderStatus.CANCELED);
		} catch (NoSuchDataException e) {
			Logger logger = (Logger) LogManager.getLogger(CancelOrderAction.class);
			logger.error(e.getMessage());
			printMessage(e.getMessage());
		}
	}
		
	}
