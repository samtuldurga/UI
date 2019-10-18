package com.virtusa.dao;

import java.sql.SQLException;
import java.util.List;

import com.virtusa.entities.TrainingCalendar;
import com.virtusa.entities.Lp;

public interface LpDAO{
	
	
   
	
	List<TrainingCalendar> viewTrainingCalendar() throws ClassNotFoundException, SQLException;

	boolean storeLpDetails(Lp lp) throws ClassNotFoundException, SQLException;
	List<Lp> lpProfileView(String userId) throws ClassNotFoundException, SQLException;

	
}
