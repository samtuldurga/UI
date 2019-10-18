package com.virtusa.helper;
import org.apache.log4j.Logger;

import com.virtusa.dao.LpDAO;
import com.virtusa.dao.LpDAOImpl;

public final class FactoryLpDAO {
	public static final Logger log = Logger.getLogger(FactoryLpDAO.class.getName());

	public static LpDAO createLpDAO() {
		log.info("entered into factory class");
		LpDAO lpDAO = new LpDAOImpl();
		return lpDAO;

	}
}