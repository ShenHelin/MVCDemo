package com.company.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.company.dao.idao.IReportDao;
import com.company.dao.pojo.report.Report;
import com.company.dao.util.OracleSessionFactory;

public class DaoReportImpl implements IReportDao {

	@Override
	public List<Report> getReportByDeptno() throws Exception {
		Connection con = OracleSessionFactory.getInstance().getSession();
		String sql = "select deptno,max(sal) maxsal,min(sal) minsal,floor(avg(sal)) avgsal,sum(sal) sumsal,count(*) counter from emp group by deptno";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Report> reportList = new ArrayList<Report>();
		while (rs.next()) {
			Report report = new Report(rs.getInt(1), rs.getDouble(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5),
					rs.getInt(6));
			reportList.add(report);
		}
		return reportList;
	}

}
