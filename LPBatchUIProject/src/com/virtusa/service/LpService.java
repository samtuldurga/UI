package com.virtusa.service;

import java.sql.SQLException;
import java.util.List;

import com.virtusa.model.CalendarModel;
import com.virtusa.model.LpModel;
import com.virtusa.model.UpdateLpDetailsModel;

public interface LpService {

	boolean storeLpService(UpdateLpDetailsModel updateLpDetailsView) throws ClassNotFoundException, SQLException;
	public List<CalendarModel> retrieveCalendar() throws ClassNotFoundException, SQLException;


	List<LpModel> retrieveLpDetails(String userId);
}
