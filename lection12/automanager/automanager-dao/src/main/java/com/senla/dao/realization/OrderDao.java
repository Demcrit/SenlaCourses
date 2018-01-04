package com.senla.dao.realization;


import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import com.senla.dao.api.IOrderDao;
import com.senla.model.Order;
import com.senla.model.enums.OrderStatus;

public class OrderDao extends AbstractDao<Order> implements IOrderDao {
	
	public OrderDao()
	{
		super(Order.class);
	}

	private static final String START_DATE = "start_date";
	private static final String REQUEST_DATE = "request_date";
	private static final String PRICE = "price";
	private static final String COMPLETE_DATE = "complete_date";

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getAll(Session session, OrderStatus orderStatus) {
		return session.createCriteria(returnClass()).add(Restrictions.eq("orderStatus", orderStatus.toString())).list();
	}

	@Override
	public List<Order> sortOrdersByCompleteDateAction(Session session) {
		return getAll(session, COMPLETE_DATE);
	}

	@Override
	public List<Order> sortOrdersByPriceAction(Session session) {
		return getAll(session, PRICE);
	}

	@Override
	public List<Order> sortOrdersByRequestDateAction(Session session) {
		return getAll(session, REQUEST_DATE);
	}

	@Override
	public List<Order> sortOrdersByStartDateAction(Session session) {
		return getAll(session, START_DATE);
	}

}
