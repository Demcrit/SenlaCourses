package com.senla.servlets;

import static com.senla.util.JsonMapper.prepareJson;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.senla.facade.Facade;
import com.senla.model.Mechanic;

public class GetAllMechanics extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetAllMechanics() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		List<Mechanic> mechanics = Facade.getInstance().getAll(null);
		response.getWriter().print(prepareJson(mechanics));
	}
}