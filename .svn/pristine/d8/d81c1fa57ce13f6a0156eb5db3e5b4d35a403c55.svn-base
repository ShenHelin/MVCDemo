package com.company.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.company.dao.idao.IEmpDao;
import com.company.dao.pojo.Emp;
import com.company.dao.util.OracleSessionFactory;

public class DaoEmpImpl implements IEmpDao {

	@Override
	public void save(Emp t) throws Exception {
		// 1-获得数据库连接 OracleSessionFactory.getInstance()
		Connection con = OracleSessionFactory.getInstance().getSession();
		// 2-编写SQL语句，执行插入数据的功能
		String sql = "insert into emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) values(?,?,?,nvl(?,0),to_date(?,'yyyy-MM-dd'),?,nvl(?,0),?)";
		// 3-封装SQL语句为JDBC对象---PreparedStatement
		PreparedStatement ps = con.prepareStatement(sql);
		// 4-完善SQL语句（给SQL语句赋予参数值）
		ps.setInt(1, t.getEmpno());
		ps.setInt(4, t.getMgr());
		ps.setInt(8, t.getDeptno());

		ps.setString(2, t.getEname());
		ps.setString(3, t.getJob());
		ps.setString(5, t.getHiredate());

		ps.setDouble(6, t.getSal());
		ps.setDouble(7, t.getComm());
		// 5-执行SQL语句
		ps.executeUpdate();
		// 6-关闭所有资源 调用OracleSessionFactory.getInstance()中的工具方法
		OracleSessionFactory.getInstance().close(null, ps, con);
	}

	@Override
	public void update(Emp t) throws Exception {
		Connection con = OracleSessionFactory.getInstance().getSession();
		String sql = "update emp set ename=?,job=?,mgr=nvl(?,0),hiredate=to_date(?,'yyyy-MM-dd'),sal=?,comm=nvl(?,0),deptno=? where empno=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(8, t.getEmpno());
		ps.setInt(3, t.getMgr());
		ps.setInt(7, t.getDeptno());

		ps.setString(1, t.getEname());
		ps.setString(2, t.getJob());
		ps.setString(4, t.getHiredate());

		ps.setDouble(5, t.getSal());
		ps.setDouble(6, t.getComm());

		ps.executeUpdate();
		OracleSessionFactory.getInstance().close(null, ps, con);

	}

	@Override
	public void delete(Emp t) throws Exception {
		Connection con = OracleSessionFactory.getInstance().getSession();
		String sql = "delete from emp where empno=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, t.getEmpno());
		ps.executeUpdate();
		OracleSessionFactory.getInstance().close(null, ps, con);
	}

	@Override
	public List<Emp> findAll() throws Exception {
		// 1-获得连接
		Connection con = OracleSessionFactory.getInstance().getSession();
		// 2-封装并执行SQL语句，获得结果集ResultSet
		String sql = "select empno,ename,job,to_char(hiredate,'yyyy-MM-dd'),nvl(mgr,0),sal,nvl(comm,0),deptno from emp";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		// 3-遍历ResultSet结果集，形成对象集合
		List<Emp> empList = new ArrayList<Emp>();
		while (rs.next()) {
			Emp p = new Emp(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
					rs.getDouble(6), rs.getDouble(7), rs.getInt(8));
			empList.add(p);
		}
		// 4-关闭资源，返回对象集合
		return empList;
	}

	@Override
	public Emp findById(Integer k) throws Exception {
		Connection con = OracleSessionFactory.getInstance().getSession();
		// 声明精确查询的sql语句
		String sql = "select empno,ename,job,to_char(hiredate,'yyyy-MM-dd'),nvl(mgr,0),sal,nvl(comm,0),deptno from emp where empno=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, k);
		ResultSet rs = ps.executeQuery();
		Emp p = null;
		if (rs.next()) {
			p = new Emp(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
					rs.getDouble(6), rs.getDouble(7), rs.getInt(8));
		}
		return p;
	}

	@Override
	public List<Emp> findByName(String ename) throws Exception {
		Connection con = OracleSessionFactory.getInstance().getSession();
		// 声明模糊查询的sql语句
		String sql = "select empno,ename,job,to_char(hiredate,'yyyy-MM-dd'),nvl(mgr,0),sal,nvl(comm,0),deptno from emp where ename like ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "%" + ename + "%");
		ResultSet rs = ps.executeQuery();
		List<Emp> empList = new ArrayList<Emp>();
		while (rs.next()) {
			Emp p = new Emp(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
					rs.getDouble(6), rs.getDouble(7), rs.getInt(8));
			empList.add(p);
		}
		return empList;
	}
}
