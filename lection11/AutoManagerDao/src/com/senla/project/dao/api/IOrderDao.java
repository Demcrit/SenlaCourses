package com.senla.project.dao.api;

import java.sql.Connection;
import java.util.List;
import com.senla.project.model.Order;
import com.senla.project.model.enums.OrderStatus;


public interface IOrderDao {
	List<Order> getAll(Connection connection, OrderStatus orderStatus);

	List<Order> sortOrdersByCompleteDateAction(Connection connection);

	List<Order> sortOrdersByPriceAction(Connection connection);

	List<Order> sortOrdersByRequestDateAction(Connection connection);

	List<Order> sortOrdersByStartDateAction(Connection connection);

	}
