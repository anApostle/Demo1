package com.deo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.deo.model.Employee;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {

	private static final String GET_EMPS_BY_DESGS = "SELECT EMPNO, ENAME, JOB, SAL, DEPTNO FROM EMP WHERE JOB IN(?,?,?)ORDER BY JOB";

	@Autowired
	private DataSource ds;

	@Override
	public List<Employee> getEmployeeByDesgs(String desg1, String desg2, String desg3) throws Exception {

		System.out.println("EmployeeDAOImpl.getEmployeeByDesgs()::ds class name ::" + ds.getClass());
		List<Employee> list = null;
		// get pooled jdbc con object
		try (Connection con = ds.getConnection()) {
			// create PreparedStatement obj
			PreparedStatement pstmt = con.prepareStatement(GET_EMPS_BY_DESGS);
			pstmt.setString(1, desg1);
			pstmt.setString(2, desg2);
			pstmt.setString(3, desg3);
			// execute the query
			try (ResultSet rs = pstmt.executeQuery()) {
				// initialize the List variable
				list = new ArrayList<>();
				while (rs.next()) {
					// copy each record of ResultSet into Employee obj
					Employee e = new Employee();
					e.setEno(rs.getInt(1));
					e.setEname(rs.getString(2));
					e.setSalary(rs.getDouble(4));
					e.setDeptno(rs.getInt(5));
					e.setDesg(rs.getString(3));
					// add Employee object to List Collection
					list.add(e);
				} // while loop ended
			} // try 2 with resources ended
		}//try 1 with resources ended
		catch (Exception e) {
			e.printStackTrace();
			throw e;//exception propagation
		}//catch block ended

		return list;
	}//method ended

}//class ended
