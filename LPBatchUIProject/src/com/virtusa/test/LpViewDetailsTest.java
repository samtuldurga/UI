package com.virtusa.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.virtusa.dao.LpDAO;
import com.virtusa.dao.LpDAOImpl;
import com.virtusa.entities.Lp;

public class LpViewDetailsTest {


	@Test
	public void viewLp_possitive() {
		Lp lp = new Lp();
		LpDAO lpDAO = new LpDAOImpl();

		try {
			String userId = lp.getLpId();
			List<Lp> lps = lpDAO.lpProfileView(userId);
			assertNotNull(lps);

		} catch (ClassNotFoundException | SQLException e) {
			assertTrue(false);
		}

	}
}
