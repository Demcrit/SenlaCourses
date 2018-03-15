package com.senla.controller;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.nimbusds.jose.JOSEException;
import com.senla.service.TokenStorage;
import com.senla.service.UserStorage;

public class FilterLogin implements Filter {
	private FilterConfig filterConfig;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse rs = (HttpServletResponse) response;
		String token = req.getHeader("token");
		TokenStorage tokenSt = WebApplicationContextUtils
				.getRequiredWebApplicationContext(filterConfig.getServletContext()).getBean(TokenStorage.class);
		UserStorage userSt = WebApplicationContextUtils
				.getRequiredWebApplicationContext(filterConfig.getServletContext()).getBean(UserStorage.class);
		Long id = null;
		try {
			id = tokenSt.getUserIdByToken(token);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (JOSEException e) {
			e.printStackTrace();
		}
		if (id != null) {
			userSt.setId(id);
			chain.doFilter(request, response);
		}
		rs.setStatus(404);
	}

	@Override
	public void destroy() {
		this.filterConfig = null;

	}

}
