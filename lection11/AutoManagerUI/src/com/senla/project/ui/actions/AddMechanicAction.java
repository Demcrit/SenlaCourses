package com.senla.project.ui.actions;

import com.senla.project.model.Mechanic;
import com.senla.project.server.Request;
import com.senla.project.server.Worker;
import com.senla.project.server.Response;
import com.senla.project.ui.api.IAction;
import com.senla.project.ui.utils.*;
import com.senla.project.utils.PrintUtil;

public class AddMechanicAction implements IAction {

	private final static String AM = "addMechanic";

	@Override
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
