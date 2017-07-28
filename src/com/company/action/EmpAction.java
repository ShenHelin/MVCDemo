package com.company.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.company.dao.pojo.Emp;
import com.company.service.factory.ServiceFactory;
import com.company.service.iservice.IEmpService;
import com.opensymphony.xwork2.ModelDriven;

public class EmpAction implements ModelDriven<Emp>, RequestAware {

	// 1-使用ModleDriven实现基于POJO类的自动取值

	private Emp emp = new Emp();// 必须有一个实例化之后的POJO对象作为属性

	@Override
	public Emp getModel() {
		return emp;
	}

	private String option;// 执行类型：findById还是update

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	// 2-处理
	private IEmpService empService;

	public EmpAction() {
		empService = ServiceFactory.getEmpInstance();
	}

	// 2.1 优化Servlet API解耦，使用RequestAware接口
	private Map<String, Object> request;

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public String save() {
		return empService.save(emp);
	}

	public String update() {
		return empService.update(emp);
	}

	public String delete() {
		return empService.delete(emp);
	}

	public String findAll() {
		String msg = "error";
		List<Emp> emps = empService.findAll();
		if (emps != null && emps.size() > 0) {
			// 将emps存入到request中，用来转发
			request.put("empListFromServer", emps);
			msg = "success";
		}
		return msg;
	}

	public String findById() {
		String msg = "error";
		Emp p = empService.findById(emp.getEmpno());
		if (p != null) {
			if ("update".equals(option)) {
				request.put("empFromServer", p);
				msg = "updatesuccess";
			} else {
				List<Emp> emps = new ArrayList<Emp>();
				emps.add(p);
				request.put("empListFromServer", emps);
				msg = "success";
			}
		}
		return msg;
	}

	public String findByName() {
		String msg = "error";
		List<Emp> emps = empService.findByName(emp.getEname());
		if (emps != null && emps.size() > 0) {
			// 将emps存入到request中，用来转发
			request.put("empListFromServer", emps);
			msg = "success";
		}
		return msg;
	}

}
