package com.senla.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.senla.exceptions.NoSuchDataException;
import com.senla.facade.Facade;

public class FindFreeMechanicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LogManager.getLogger(OrderServlet.class);
       
    public FindFreeMechanicServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		try {
			Facade.getInstance().findFreeMechanic();
		} catch (NoSuchDataException e) {
			LOG.error(e);
		}
	}

}
