package com.virtusa.dao;

import java.sql.SQLException;

import com.virtusa.entities.User;
import com.virtusa.model.UserModel;


public interface UserDAO {
	public boolean userAuth(String userId,String password) throws SQLException, ClassNotFoundException;

	
}
