package com.senla.servlets;

import java.io.IOException;
import java.util.List;
import static com.senla.util.JsonMapper.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.senla.facade.Facade;
import com.senla.model.Mechanic;
import com.senla.model.enums.Sorting;

public class MechanicSortingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MechanicSortingServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Sorting type = this.getSortingType(request.getParameter("sorting"));
		List<Mechanic> mechanics = Facade.getInstance().getAll(type);
		response.getWriter().print(prepareJson(mechanics));
	}

	private Sorting getSortingType(String search) {
		Sorting sort = null;
		for (Sorting temp : Sorting.values()) {
			if (temp.getType().equals(search)) {
				sort = temp;
			}

		}
		return sort;
	}
}