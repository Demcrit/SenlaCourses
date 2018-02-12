package com.senla.controller;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.senla.model.UserCreds;
import com.senla.service.UserCredsService;
import com.senla.service.UserStorage;

@Controller
public class UserCredsController {

	@Autowired
	private UserCredsService userCredsService;
	@Autowired
	private UserStorage userStorage;

	@RequestMapping(value = { "api/profile" }, method = { RequestMethod.GET })

	@ResponseBody
	private UserCreds getUserCreds(HttpServletResponse response) {

		UserCreds userCreds = userCredsService.getUserCreds(userStorage.getId());
		if (userCreds != null) {
			return userCreds;
		}
		response.setStatus(404);
		return new UserCreds();
	}

}
