package com.senla.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.senla.facade.Facade;

public class MechanicSortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PARAM = "sort";
	private static final Logger LOG = LogManager.getLogger(MechanicSortServlet.class);

	public MechanicSortServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sortParam = request.getParameter(PARAM);
		if (sortParam == "all") {
			try {
				Facade.getInstance().getAll();
			} catch (ReflectiveOperationException e) {
				LOG.info(e);
			}
		} else if (sortParam == "work") {
			try {
				Facade.getInstance().sortMechanicsByWork();
			} catch (ReflectiveOperationException e) {
				LOG.info(e);
			}
		} else if (sortParam == "name") {
			try {
				Facade.getInstance().sortMechanicsByName();
			} catch (ReflectiveOperationException e) {
				LOG.info(e);
			}

		}

	}
}