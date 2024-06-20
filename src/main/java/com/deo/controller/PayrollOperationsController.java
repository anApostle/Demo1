package com.deo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.deo.model.Employee;
import com.deo.service.IEmployeeMgmtService;

@Controller("payroll")
public class PayrollOperationsController {
	@Autowired
	private IEmployeeMgmtService service;
	
	public List<Employee> showEmployeesByDesigs(String desg1,String desg2,String desg3) throws Exception
	{
		System.out.println("PayrollOperationsController.showEmployeesByDesigs()");
		
		//use Service
		List<Employee> list = service.fetchEmployeeByDesg(desg1, desg2, desg3);
		return list;
	}
}
