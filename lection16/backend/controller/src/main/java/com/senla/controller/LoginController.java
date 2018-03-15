package com.senla.controller;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nimbusds.jose.JOSEException;
import com.senla.model.User;
import com.senla.service.TokenStorage;
import com.senla.service.UserService;

@Controller
public class LoginController {

	@Autowired
	UserService userService;
	@Autowired
	private TokenStorage tokenStorage;

	public LoginController() {
	}

	@RequestMapping(value = { "/login" }, method = { RequestMethod.POST })
	public void login(HttpServletResponse response, @RequestBody User user) throws JOSEException {
		Long id = userService.checkUser(user);
		if (id != null) {
			String token = tokenStorage.createToken(id);
			response.addHeader("token", token);
		} else {
			response.setStatus(401);
		}
	}
}
