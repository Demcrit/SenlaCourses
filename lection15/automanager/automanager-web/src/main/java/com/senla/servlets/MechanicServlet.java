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
import com.senla.model.Mechanic;
import static com.senla.util.JsonMapper.*;

public class MechanicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String NULL = "{null}";
	private static final Logger LOG = LogManager.getLogger(MechanicServlet.class);

	public MechanicServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
	    Integer id = Integer.parseInt(request.getParameter("id"));
		try {
			Mechanic mechanic = Facade.getInstance().getMechanic((id));
			response.getWriter().print(prepareJson(mechanic));
		} catch (NoSuchDataException e) {
			LOG.info(e);
			response.getWriter().print(NULL);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			Facade.getInstance().addMechanic(request.getParameter("name"));
			}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		  Integer id = Integer.parseInt(request.getParameter("id"));
			Facade.getInstance().deleteMechanic(id);
		
	}
}
