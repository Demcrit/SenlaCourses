package com.senla.dao.realization;


import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import com.senla.dao.api.IOrderDao;
import com.senla.model.Order;
import com.senla.model.enums.OrderStatus;
import com.senla.model.enums.Sorting;

public class OrderDao extends AbstractDao<Order> implements IOrderDao {
	
	public OrderDao()
	{
		super(Order.class);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getAll(Session session, OrderStatus orderStatus) {
		return session.createCriteria(returnClass()).add(Restrictions.eq("orderStatus", orderStatus.toString())).list();
	}

	@Override
	public List<Order> sortOrdersByCompleteDateAction(Session session,Sorting sort) {
		return getAll(session,sort);
	}

	@Override
	public List<Order> sortOrdersByPriceAction(Session session,Sorting sort) {
		return getAll(session,sort);
	}

	@Override
	public List<Order> sortOrdersByRequestDateAction(Session session,Sorting sort) {
		return getAll(session,sort);
	}

	@Override
	public List<Order> sortOrdersByStartDateAction(Session session,Sorting sort) {
		return getAll(session,sort);
	}

}
