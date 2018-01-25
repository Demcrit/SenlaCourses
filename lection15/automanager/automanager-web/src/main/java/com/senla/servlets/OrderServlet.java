package com.senla.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.senla.exceptions.NoSuchDataException;
import com.senla.facade.Facade;
import com.senla.model.Order;

import static com.senla.util.JsonMapper.*;

public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String NULL = "{null}";
	private static final Logger LOG = LogManager.getLogger(OrderServlet.class);
       
    public OrderServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		try {
			Order order = Facade.getInstance().getDirectOrder(id);
			response.getWriter().print(prepareJson(order));
		} catch (NoSuchDataException e) {
			LOG.info(e);
			response.getWriter().print(NULL);
	}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		try {
			Facade.getInstance().deleteOrder(id);;
		} catch (SQLException e) {
			LOG.info(e);
		}

	}

}
