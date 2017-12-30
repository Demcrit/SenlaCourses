package com.senla.dao.api;

import java.sql.Connection;
import java.util.List;
import com.senla.model.Order;
import com.senla.model.enums.OrderStatus;


public interface IOrderDao extends IBaseDao<Order> {
	
	List<Order> getAll(Connection connection, OrderStatus orderStatus);

	List<Order> sortOrdersByCompleteDateAction(Connection connection);

	List<Order> sortOrdersByPriceAction(Connection connection);

	List<Order> sortOrdersByRequestDateAction(Connection connection);

	List<Order> sortOrdersByStartDateAction(Connection connection);

	}
