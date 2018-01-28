package com.senla.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senla.facade.Facade;

public class OrderCloneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OrderCloneServlet() {
		super();
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		@SuppressWarnings("unused")
		PrintWriter writer = response.getWriter();
		response.setContentType("application/json;charset=utf-8");
		Integer id = Integer.parseInt(request.getParameter("id"));
		Facade.getInstance().cloneOrder(id);
	}

}
