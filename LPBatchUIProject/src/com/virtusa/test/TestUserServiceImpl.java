package com.virtusa.test;

import org.junit.Test;

import com.virtusa.model.UserModel;
import com.virtusa.service.UserServiceImpl;

class TestUserServiceImpl {

	@Test
	void test() {

		UserServiceImpl userServiceImpl = new UserServiceImpl();
		UserModel userModel = new UserModel();
		boolean actual = userServiceImpl.userAuthenticationService(userModel);

	}

}
