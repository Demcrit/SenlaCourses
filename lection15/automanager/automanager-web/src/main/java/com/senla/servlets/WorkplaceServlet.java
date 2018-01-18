package com.senla.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.senla.facade.Facade;
import com.senla.model.Workplace;

public class WorkplaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LogManager.getLogger(WorkplaceServlet.class);
	
	public WorkplaceServlet() {
        super();
           }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try{
		Workplace workplace = new Workplace();
		Facade.getInstance().addWorkplace(workplace);
	}
	catch (ReflectiveOperationException e) {
		LOG.info(e);
	}
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		try {
			Facade.getInstance().deleteWorkplace(id);
		} catch (ReflectiveOperationException e) {
			LOG.info(e);
		}

	}
}
