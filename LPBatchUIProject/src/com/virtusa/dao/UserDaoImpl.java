package com.virtusa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.virtusa.entities.User;
import com.virtusa.helper.FactoryLpDAO;
import com.virtusa.integrate.ConnectionManager;
import com.virtusa.model.UserModel;


public class UserDaoImpl implements UserDAO {

	public static final Logger log = Logger.getLogger(UserDaoImpl.class.getName());


	
	@Override
	public boolean userAuth(String userId,String password) throws SQLException, ClassNotFoundException {
		
		
			Connection connection=ConnectionManager.openConnection();
			boolean result=false;
			PreparedStatement statement = connection.prepareStatement("select lp_id,lp_password from lplogin where( lp_id=? and lp_password=?)");
			statement.setString(1, userId);
			statement.setString(2, password);
             
         
			
		    ResultSet resultSet=statement.executeQuery();
		 
             if(resultSet.next()) {
            	 
            	    result=true;
        		    log.info("User Logged in");
            	 
             }else {
            	 
            	 result=false;
     		    log.info("User Login Failed");

             }
		    
             ConnectionManager.closeConnection();
			 return result;
				

}		
}

