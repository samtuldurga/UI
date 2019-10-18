package com.virtusa.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import com.virtusa.dao.UserDAO;
import com.virtusa.dao.UserDaoImpl;

public class TestUserDaoImpl {


	@Test
	public void userLogin_positive() {
		UserDAO userDAO = new UserDaoImpl();
		try {
			boolean a = userDAO.userAuth("L001", "lp");
			assertEquals(true, a);
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}

	@Test
	public void userLogin_negative() {
		UserDAO userDAO = new UserDaoImpl();
		try {
			boolean a = userDAO.userAuth("1", "jk");
			assertEquals(false, a);
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}


}
