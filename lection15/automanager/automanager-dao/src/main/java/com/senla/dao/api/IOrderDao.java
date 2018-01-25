package com.senla.dao.api;

import java.util.List;

import org.hibernate.Session;

import com.senla.model.Order;
import com.senla.model.enums.OrderStatus;
import com.senla.model.enums.Sorting;


public interface IOrderDao extends IBaseDao<Order> {
	
	List<Order> getAll(Session session, OrderStatus orderStatus);

	List<Order> sortOrdersByCompleteDateAction(Session session,Sorting sort);

	List<Order> sortOrdersByPriceAction(Session session,Sorting sort);

	List<Order> sortOrdersByRequestDateAction(Session session,Sorting sort);

	List<Order> sortOrdersByStartDateAction(Session session, Sorting sort);

	}
