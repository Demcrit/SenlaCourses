package com.senla.ui.actions;

import com.senla.model.Mechanic;
import com.senla.server.Request;
import com.senla.server.Worker;
import com.senla.server.Response;
import com.senla.utils.PrintUtil;
import com.senla.ui.api.IAction;
import com.senla.ui.utils.*;

public class AddMechanicAction implements IAction {

	private final static String AM = "addMechanic";

	public void execute() throws ReflectiveOperationException {
		Mechanic mechanic = InputUtil.inputMechanic();
		Request msg = new Request(AM, new Object[] { mechanic });
		Response resp = Worker.getInstance().sendMsg(msg);
		if (resp.isOk()) {
			PrintUtil.printMessage("Mechanic was added");
		} else {
			PrintUtil.printMessage("Mechanic was not added,error");
		}
	}
}
