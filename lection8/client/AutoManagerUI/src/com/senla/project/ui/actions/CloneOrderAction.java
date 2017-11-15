package com.senla.project.ui.actions;

import com.senla.project.ui.api.IAction;
import static com.senla.project.utils.PrintUtil.*;
import com.senla.project.exceptions.NoSuchDataException;
import org.apache.logging.log4j.*;
import static com.senla.project.ui.utils.GeneralScanner.*;
import com.senla.project.facade.Facade;
import com.senla.project.model.Order;

public class CloneOrderAction implements IAction {
	public static final String ORDER_ID = "Enter order id to clone";
	public static final Logger LOG = LogManager.getLogger(CloneOrderAction.class);

	@Override
	public void execute() throws ReflectiveOperationException {
		
		printMessage(ORDER_ID);
		
		try{
			Order order = Facade.getInstance().getDirectOrder(nextInt());
			Order clonedOrder = order.clone();
            clonedOrder.setId(Facade.getInstance().getNextOrderId());
            Facade.getInstance().addOrder(clonedOrder);
 			}
		catch (NoSuchDataException e) {
			printMessage(e.getMessage());
		} catch (CloneNotSupportedException e) {
			printMessage(e.getMessage());
			LOG.error(e.getMessage());
		}
		}
}
