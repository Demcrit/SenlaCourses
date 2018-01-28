package com.senla.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.senla.facade.Facade;
import com.senla.model.Workplace;

public class WorkplaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
	public WorkplaceServlet() {
        super();
           }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Workplace workplace = new Workplace();
		Facade.getInstance().addWorkplace(workplace);
		}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
			Facade.getInstance().deleteWorkplace(id);
	
	}
}
