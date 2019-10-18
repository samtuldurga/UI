package com.virtusa.lpservlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import com.virtusa.helper.FactoryLpService;
import com.virtusa.model.LpModel;
import com.virtusa.model.UpdateLpDetailsModel;
import com.virtusa.model.UserModel;
import com.virtusa.service.LpService;
import com.virtusa.service.LpServiceImpl;
import com.virtusa.validation.UpdateLpDetailsModelValidator;

/**
 * Servlet implementation class LpServlet
 */
@WebServlet("/lpprofileviewservlet")
public class LpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
	LpService lpService;

    public LpServlet() {
        super();
        // TODO Auto-generated constructor stub
		this.lpService = FactoryLpService.createLpService();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 HttpSession session = request.getSession();
		    String username = (String) session.getAttribute("username");
		    System.out.println(username);
		   String action=request.getParameter("action");
			if(action.contentEquals("view")) {
		    
		 
		
		List<LpModel> lpModelList = lpService.retrieveLpDetails(username);
		System.out.println(lpModelList);
		request.setAttribute("lpModelList", lpModelList);
	     RequestDispatcher dispatcher=
					request.getRequestDispatcher("ViewLpProfile.jsp");
			dispatcher.forward(request,response);
			
			}
			if(action.contentEquals("loadform")) {
				
				RequestDispatcher dispatcher=request.getRequestDispatcher("UpdateProfileForm.jsp");
				dispatcher.forward(request, response);
				
			    
			}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession();
		    String userid = (String) session.getAttribute("username");
		  String action=request.getParameter("action");
	        if(action.contentEquals("updateProfile")) {
	        	
	        	String firstName=request.getParameter("firstName");
	        	String lastName=request.getParameter("lastName");
	        	String email=request.getParameter("email");
	        	String phoneNumber=request.getParameter("phoneNumber");
	        	String role=request.getParameter("role");
	        	String state=request.getParameter("state");
	        	String country=request.getParameter("country");
	        	String city=request.getParameter("city");

	        	UpdateLpDetailsModel detailsModel=new UpdateLpDetailsModel();
	        	detailsModel.setFirstName(firstName);
	        	detailsModel.setLastName(lastName);
	        	detailsModel.setEmail(email);
	        	detailsModel.setPhoneNumber(phoneNumber);
	        	detailsModel.setRole(role);
	        	detailsModel.setCity(city);
	        	detailsModel.setState(state);
	        	detailsModel.setCountry(country);
	        	detailsModel.setUserId(userid);
	        	
	        	UpdateLpDetailsModelValidator validator=new UpdateLpDetailsModelValidator();
	        
	        	boolean validFirstName=validator.validString(firstName);
	        	boolean validLastName=validator.validString(lastName);
	        	boolean validEmail=validator.validEmail(email);
	        	boolean validPhoneNumber=validator.validString(phoneNumber);
	        	boolean emailExist=validator.emailExist(email);
	    		
	          
	        	if(!validFirstName || !validLastName || !validEmail || !validPhoneNumber || emailExist) {
	        		
	        		  
	                  if(!validFirstName) {
	              		request.setAttribute("firstnameerror", "First Name not valid");
	                  }
	                  if(!validLastName) {
	              		request.setAttribute("lastnameerror",  "Last Name not valid");
	                  }
	                  if(!validEmail) {
	              		request.setAttribute("emailerror",  "Email not valid");

	                  }
	                  if(!validPhoneNumber) {
	              		request.setAttribute("phonenumbererror",  "Phone Numbernot valid");

	                  }
	                  if(emailExist) {
	                		request.setAttribute("emailexisterror",  "Email already exist");

	                  }
	                  RequestDispatcher dispatcher=request.getRequestDispatcher("UpdateProfileForm.jsp");
	                  dispatcher.forward(request, response);
	                 
	        	}
	        	
	        	else {
	           
	        	try {
					boolean result = lpService.storeLpService(detailsModel);
					request.setAttribute("result", result);
					if(result==true) {
						
						RequestDispatcher dispatcher1=request.getRequestDispatcher("detailsUpdated.jsp");
						dispatcher1.forward(request, response);
						}
					else {
						
						RequestDispatcher dispatcher=request.getRequestDispatcher("detailsNotUpdated.jsp");
						dispatcher.forward(request, response);}
						
					}
					
				catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	

	        }
	        }
	        	
	

	}}


