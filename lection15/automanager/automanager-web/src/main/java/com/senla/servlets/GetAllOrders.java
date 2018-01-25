package com.senla.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.senla.facade.Facade;
import com.senla.model.Order;
import static com.senla.util.JsonMapper.*;

public class GetAllOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetAllOrders() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		List<Order> orders = Facade.getInstance().getOrders(null);
		response.getWriter().print(prepareJson(orders));
			}
}