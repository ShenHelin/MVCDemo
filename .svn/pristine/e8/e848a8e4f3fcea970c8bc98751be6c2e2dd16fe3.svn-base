package com.company.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.company.dao.pojo.Product;
import com.company.service.factory.ServiceFactory;
import com.company.service.iservice.IProductService;
import com.opensymphony.xwork2.ModelDriven;

public class ProductAction implements ModelDriven<Product>, RequestAware {

	// 1-使用ModleDriven实现基于POJO类的自动取值

	private Product product = new Product();// 必须有一个实例化之后的POJO对象作为属性

	@Override
	public Product getModel() {
		return product;
	}

	private String option;// 执行类型：findById还是update

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	// 2-处理
	private IProductService productService;

	public ProductAction() {
		productService = ServiceFactory.getProductInstance();
	}

	// 2.1 优化Servlet API解耦，使用RequestAware接口
	private Map<String, Object> request;

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public String save() {
		return productService.save(product);
	}

	public String update() {
		return productService.update(product);
	}

	public String delete() {
		return productService.delete(product);
	}

	public String findAll() {
		String msg = "error";
		List<Product> products = productService.findAll();
		if (products != null && products.size() > 0) {
			// 将products存入到request中，用来转发
			request.put("productListFromServer", products);
			msg = "success";
		}
		return msg;
	}

	public String findById() {
		String msg = "error";
		Product p = productService.findById(product.getPid());
		if (p != null) {
			if ("update".equals(option)) {
				request.put("productFromServer", p);
				msg = "updatesuccess";
			} else {
				List<Product> products = new ArrayList<Product>();
				products.add(p);
				request.put("productListFromServer", products);
				msg = "success";
			}
		}
		return msg;
	}

	public String findByName() {
		String msg = "error";
		List<Product> products = productService.findByName(product.getPname());
		if (products != null && products.size() > 0) {
			// 将products存入到request中，用来转发
			request.put("productListFromServer", products);
			msg = "success";
		}
		return msg;
	}

}
