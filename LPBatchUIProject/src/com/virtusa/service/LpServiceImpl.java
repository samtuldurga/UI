package com.virtusa.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.virtusa.dao.LpDAO;
import com.virtusa.entities.TrainingCalendar;
import com.virtusa.entities.Lp;
import com.virtusa.helper.FactoryLpDAO;
import com.virtusa.model.CalendarModel;
import com.virtusa.model.LpModel;
import com.virtusa.model.UpdateLpDetailsModel;

public class LpServiceImpl implements LpService {

	LpDAO lpDao;

	public LpServiceImpl() {

		this.lpDao = FactoryLpDAO.createLpDAO();

	}

	@Override
	public List<LpModel> retrieveLpDetails(String userId) {
   
		List<LpModel> lpModelList=new ArrayList<>();
		
		try {
			List<Lp> lp = lpDao.lpProfileView(userId);
			for(Lp lp2:lp) {
				LpModel lpModel=new LpModel();
				lpModel.setFullName(lp2.getFirstName() + " " + lp2.getLastName());
				lpModel.setContactDetails("Email:" + lp2.getEmail() + " Phone Number:" + lp2.getPhoneNumber());
				lpModel.setRole(lp2.getRole()) ;
				lpModel.setAddress("City:" + lp2.getCity() + "State: " + lp2.getState() + "Country:" + lp2.getCountry());
				lpModel.setId("ID:"+lp2.getLpId());
				lpModelList.add(lpModel);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return lpModelList;
	}

	@Override
	public boolean storeLpService(UpdateLpDetailsModel updateModel) throws ClassNotFoundException, SQLException {

		Lp lp = new Lp();
		lp.setFirstName(updateModel.getFirstName());
		lp.setLastName(updateModel.getLastName());
		lp.setEmail(updateModel.getEmail());
		lp.setPhoneNumber(updateModel.getPhoneNumber());
		lp.setRole(updateModel.getRole());
		lp.setCity(updateModel.getCity());
		lp.setState(updateModel.getState());
		lp.setCountry(updateModel.getCountry());
		lp.setLpId(updateModel.getUserId());

		boolean stored = lpDao.storeLpDetails(lp);

		boolean result = false;
		if (stored)	
			
			result = true;
		else
			result = false;

		return result;
	}

	@Override
	public  List<CalendarModel> retrieveCalendar() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		 List<CalendarModel> calendarModelList=new ArrayList<>();
		
			  
			  List<TrainingCalendar> calendarList=lpDao.viewTrainingCalendar();
		
				
			  for(TrainingCalendar trainingCalendar:calendarList) {
				  CalendarModel calendarModel2=new CalendarModel();
				calendarModel2.setBatchId(trainingCalendar.getBatchId());
				calendarModel2.setDate(trainingCalendar.getDate());
				calendarModel2.setTopic(trainingCalendar.getTopic());
				calendarModelList.add(calendarModel2);
			  }

				return calendarModelList;
				
				
			
				
			
	
		
		
}
}
