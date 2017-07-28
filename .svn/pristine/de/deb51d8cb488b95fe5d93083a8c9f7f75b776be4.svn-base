package com.company.mvc.service.test;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.company.service.factory.ServiceFactory;
import com.company.service.iservice.IReportService;

public class ServiceReportImplTest {
	private IReportService reportService;

	@Before
	public void setUp() throws Exception {
		reportService = ServiceFactory.getReportInstance();
	}

	@Test
	public void testGetReportByDeptno() {
		System.out.println(reportService.getReportByDeptno());
	}

}
