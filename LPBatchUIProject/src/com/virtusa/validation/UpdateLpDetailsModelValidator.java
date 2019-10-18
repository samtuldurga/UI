package com.virtusa.validation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.virtusa.helper.FactoryLpDAO;
import com.virtusa.helper.FactoryLpService;
import com.virtusa.model.CalendarModel;
import com.virtusa.model.LpModel;
import com.virtusa.model.UpdateLpDetailsModel;
import com.virtusa.service.LpService;
import com.virtusa.service.UserService;

public class UpdateLpDetailsModelValidator {
	
	
public boolean validString(String val) {
		
		boolean result=false;
		char chars[]=val.toCharArray();
		List<Character> alphabets=new ArrayList<>();
		for(int i=97;i<=122;i++) {
			alphabets.add((char)i);
		}
		
		for(char ch:chars) {
			if(alphabets.contains(ch)) {
				result=true;
			}else {
				return false;
			}
		}
		return result;
	}


public boolean validNumber(String phoneNumber) {
		boolean result=false;
		String data=String.valueOf(phoneNumber);
		if(data.matches(".*[0-9]")) {
			result=true;
		}
		return result;
	}
	


	public boolean validEmail(String email) {
		boolean result=false;
		if(email.matches("^(.+)@(.+)$")) {
			result=true;
		}
		return result;
	}

	public boolean emailExist(String email) {
		boolean result=false;
		LpService lpService=FactoryLpService.createLpService();
		List<LpModel> lpModelList=lpService.retrieveLpDetails(email);
		for(LpModel lpModel:lpModelList) {
			
			if(lpModel.getContactDetails().contentEquals(email)) {
				return true;
				
			}
		}
		return result;
	}

}
