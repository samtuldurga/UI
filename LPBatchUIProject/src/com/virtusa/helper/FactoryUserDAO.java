package com.virtusa.helper;

import com.virtusa.dao.UserDAO;
import com.virtusa.dao.UserDaoImpl;

public class FactoryUserDAO {

	public static UserDAO createUseDAO() {

		UserDAO userDAO = new UserDaoImpl();

		return userDAO;

	}
}
