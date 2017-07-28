package com.company.mvc.dao.test;


import org.junit.Test;

import com.company.dao.util.OracleSessionFactory;

public class OracleSessionFactoryTest {

	@Test
	public void testGetSession() throws Exception {
		System.out.println("con:"+OracleSessionFactory.getInstance().getSession());
	}

}
