package com.company.service.impl;

import java.util.List;

import com.company.dao.factory.DaoFactory;
import com.company.dao.idao.IReportDao;
import com.company.dao.pojo.report.Report;
import com.company.service.iservice.IReportService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ServiceReportImpl implements IReportService {

	private IReportDao reportDao;
	public ServiceReportImpl() {
		reportDao = DaoFactory.getReportInstance();
	}
	@Override
	public String getReportByDeptno() {
		String jsonResult = null;
		try {
			List<Report> reportList = reportDao.getReportByDeptno();
			//目标：通过GSON将该集合变成json格式的字符串，所谓结果return
			Gson gson = new Gson();
			jsonResult = gson.toJson(reportList, new TypeToken<List<Report>>(){}.getType());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonResult;
	}

}
