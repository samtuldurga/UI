package com.virtusa.helper;

import com.virtusa.service.UserService;
import com.virtusa.service.UserServiceImpl;

public class FactoryUserService {

	public static UserService createUserService() {

		UserService userService = new UserServiceImpl();
		return userService;

	}

}