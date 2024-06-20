package com.deo.service;

import java.util.List;

import com.deo.model.Employee;

public interface IEmployeeMgmtService {

	public List<Employee> fetchEmployeeByDesg(String desg1,String desg2,String desg3) throws Exception;
}
