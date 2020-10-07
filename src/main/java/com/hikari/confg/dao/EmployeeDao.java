package com.hikari.confg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hikari.confg.model.Employee;
import com.hikari.confg.util.DataSourceStore;

public class EmployeeDao extends DataSourceStore {

	public Employee getEmployee(String id) {
		Employee emp = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection("ABM-EMP");
			pstmt = conn.prepareStatement("Select * from Employee where id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				emp = new Employee();
				emp.setId(rs.getString(1));
				emp.setName(rs.getString(2));
				emp.setDepartment(rs.getString(3));
				emp.setAge(rs.getInt(4));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				conn = null;
				pstmt.close();
				pstmt = null;
				rs.close();
				rs = null;
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		System.out.println(emp);
		return emp;
	}
}
