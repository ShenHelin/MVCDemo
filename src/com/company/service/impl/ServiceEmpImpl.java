package com.company.service.impl;

import java.util.List;

import com.company.dao.factory.DaoFactory;
import com.company.dao.idao.IEmpDao;
import com.company.dao.pojo.Emp;
import com.company.service.iservice.IEmpService;

public class ServiceEmpImpl implements IEmpService {

	private IEmpDao empDao;

	public ServiceEmpImpl() {
		empDao = DaoFactory.getEmpInstance();
	}

	@Override
	public String save(Emp t) {
		// 1-���ɷ���ֵ����msg
		String msg = "error";
		// 2-����dao�㷽����service����������쳣
		try {
			// 3-ִ��save��ǰ�᣺���ݿ���û�и�����¼
			Emp p = empDao.findById(t.getEmpno());
			if (p == null) {
				empDao.save(t);
				msg = "success";// Struts2�����������Ҫ��
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String update(Emp t) {
		String msg = "error";
		try {
			Emp p = empDao.findById(t.getEmpno());
			if (p != null) {
				empDao.update(t);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String delete(Emp t) {
		String msg = "error";
		try {
			Emp p = empDao.findById(t.getEmpno());
			if (p != null) {
				empDao.delete(t);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<Emp> findAll() {
		List<Emp> empList = null;
		try {
			empList = empDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empList;
	}

	@Override
	public Emp findById(Integer k) {
		Emp emp = null;
		try {
			emp = empDao.findById(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public List<Emp> findByName(String ename) {
		List<Emp> empList = null;
		try {
			empList = empDao.findByName(ename);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empList;
	}

}
