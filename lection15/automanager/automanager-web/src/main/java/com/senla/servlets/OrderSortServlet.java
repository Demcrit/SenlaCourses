package com.senla.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.senla.facade.Facade;

public class OrderSortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PARAM = "sort";
	private static final Logger LOG = LogManager.getLogger(OrderSortServlet.class);

	public OrderSortServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sortParam = request.getParameter(PARAM);
		if (sortParam == "all") {
			try {
				Facade.getInstance().getOrders();
			} catch (ReflectiveOperationException e) {
				LOG.info(e);
			}
		} else if (sortParam == "price") {
			try {
				Facade.getInstance().sortOrdersByPriceAction();
			} catch (ReflectiveOperationException e) {
				LOG.info(e);
			}
		} else if (sortParam == "stdate") {
			try {
				Facade.getInstance().sortOrdersByStartDateAction();
			} catch (ReflectiveOperationException e) {
				LOG.info(e);
			}
		}
		else if (sortParam == "enddate") {
			try {
				Facade.getInstance().sortOrdersByCompleteDateAction();
			} catch (ReflectiveOperationException e) {
				LOG.info(e);
			}
		}
		else if (sortParam == "reqdate") {
			try {
				Facade.getInstance().sortOrdersByRequestDateAction();
			} catch (ReflectiveOperationException e) {
				LOG.info(e);
			}
		}

	}

}
