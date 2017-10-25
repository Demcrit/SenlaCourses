package com.senla.project.serialize;

import java.util.List;

import com.senla.project.config.holder.Holder;
import com.senla.project.services.IService;
import com.senla.project.services.MechanicService;
import com.senla.project.services.OrderService;
import com.senla.project.services.WorkplaceService;

public class Serializator {
	private static final String ERROR_LOADING_DB = null;
	private MechanicService mechanicService;
	private OrderService orderService;
	private WorkplaceService workplaceService;

	public String load() {
		List<IService> managers = SerializatorUtl.load(Holder.getInstance().getDBPath());
		if (managers == null) {
			return ERROR_LOADING_DB;
		}
		mechanicService = (MechanicService) managers.get(0);
		orderService = (OrderService) managers.get(1);
		workplaceService = (WorkplaceService) managers.get(2);
		return ERROR_LOADING_DB;
	}

	public Boolean save() {
		return SerializatorUtl.save(mechanicService, orderService, workplaceService, Holder.getInstance().getDBPath());
	}

}
