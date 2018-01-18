package com.senla.dao.api;

import java.util.List;

import org.hibernate.Session;

import com.senla.model.Order;
import com.senla.model.enums.OrderStatus;


public interface IOrderDao extends IBaseDao<Order> {
	
	List<Order> getAll(Session session, OrderStatus orderStatus);

	List<Order> sortOrdersByCompleteDateAction(Session session);

	List<Order> sortOrdersByPriceAction(Session session);

	List<Order> sortOrdersByRequestDateAction(Session session);

	List<Order> sortOrdersByStartDateAction(Session session);

	}
