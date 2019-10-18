package com.virtusa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.virtusa.entities.TrainingCalendar;
import com.virtusa.entities.Lp;

import com.virtusa.integrate.ConnectionManager;
import com.virtusa.model.UserModel;

public class LpDAOImpl implements LpDAO {

	@Override
	public  List<Lp> lpProfileView(String userId) throws ClassNotFoundException, SQLException {
		
		Connection connection = ConnectionManager.openConnection();

		PreparedStatement statement = connection.prepareStatement("select lp_id,first_name,last_name,phone_number,email,role,city,state,country from lp_details where lp_id=?");
		
		statement.setString(1, userId);

		ResultSet resultSet = statement.executeQuery();
		Lp lp = new Lp();
       List<Lp>lpList=new ArrayList<Lp>();
		while (resultSet.next()) {

			lp.setLpId(resultSet.getString("lp_id"));
			lp.setFirstName(resultSet.getString("first_name"));
			lp.setLastName(resultSet.getString("last_name"));
			lp.setEmail(resultSet.getString("email"));
			lp.setPhoneNumber(resultSet.getString("phone_number"));
			lp.setRole(resultSet.getString("role"));
			lp.setCity(resultSet.getString("city"));
			lp.setState(resultSet.getString("state"));
			lp.setCountry(resultSet.getString("country"));
			lpList.add(lp);
		}
		ConnectionManager.closeConnection();
		return lpList;

	}

	@Override
	public boolean storeLpDetails(Lp lp) throws ClassNotFoundException, SQLException {

		boolean result = false;
		Connection connection;

		connection = ConnectionManager.openConnection();
		PreparedStatement statement;

		statement = connection.prepareStatement(
				"UPDATE lp_details SET first_name=?,last_name=?,phone_number=?,email=?,role=?,city=?,state=?,country=? where lp_id=?");

		statement.setString(1, lp.getFirstName());
		statement.setString(2, lp.getLastName());
		statement.setString(3, lp.getPhoneNumber());
		statement.setString(4, lp.getEmail());
		statement.setString(5, lp.getRole());
		statement.setString(6, lp.getCity());
		statement.setString(7, lp.getState());
		statement.setString(8, lp.getCountry());
		statement.setString(9, lp.getLpId());
		System.out.println(statement);

		int row = statement.executeUpdate();

		ConnectionManager.closeConnection();
		if (row > 0)

			result = true;
		else
			return false;

		return result;

	}

	@Override
	public List<TrainingCalendar> viewTrainingCalendar() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		boolean result = false;
		Connection connection;

		connection = ConnectionManager.openConnection();
		Statement statement = connection.createStatement();

		ResultSet resultSet = statement.executeQuery("select batch_id,date,course from training_calendar");

		List<TrainingCalendar> calendarList = new ArrayList<TrainingCalendar>();
		while (resultSet.next()) {
			TrainingCalendar trainingCalendar = new TrainingCalendar();
			trainingCalendar.setBatchId(resultSet.getString("batch_id"));
			trainingCalendar.setDate(resultSet.getString("date"));
			trainingCalendar.setTopic(resultSet.getString("course"));
			calendarList.add(trainingCalendar);

		}

		ConnectionManager.closeConnection();
		return calendarList;

	}

}
