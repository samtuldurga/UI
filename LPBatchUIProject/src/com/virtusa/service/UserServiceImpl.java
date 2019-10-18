package com.virtusa.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.virtusa.dao.UserDAO;
import com.virtusa.entities.User;

import com.virtusa.helper.FactoryLpDAO;
import com.virtusa.helper.FactoryUserDAO;
import com.virtusa.model.UserModel;

public class UserServiceImpl implements UserService {

	UserDAO userDAO = null;

	public UserServiceImpl() {

		this.userDAO = FactoryUserDAO.createUseDAO();

	}

	@Override
	public boolean userAuthenticationService(UserModel userModel) {

		boolean userValid = false;
		
			try {
				userValid = userDAO.userAuth(userModel.getUserId(), userModel.getPassword());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		return userValid;

	}

}
