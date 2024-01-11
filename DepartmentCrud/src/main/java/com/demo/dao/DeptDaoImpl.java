package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Department;

public class DeptDaoImpl implements DeptDao {
	static Connection conn;
	static PreparedStatement seldept,insdept,getdept,uptdept,deldept;
	static {
		try {
			conn=DBUtil.getMyConnection();
			seldept = conn.prepareStatement("select * from departments");
			insdept = conn.prepareStatement("insert into departments values(?,?,?)");
			getdept = conn.prepareStatement("select * from departments where Id = ?");
			uptdept = conn.prepareStatement("update departments set Name = ?, Location=? where Id=?");
			deldept = conn.prepareStatement("delete from departments where Id = ?");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<Department> getAllDepartments() {
		List<Department> dlist = new ArrayList<Department>();
		try {
			ResultSet rs = seldept.executeQuery();
			while(rs.next()) {
				Department d = new Department(rs.getInt(1),rs.getString(2),rs.getString(3));
				dlist.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dlist;
		
	}
	@Override
	public void Adddept(Department d) {
		try {
			insdept.setInt(1, d.getId());
			insdept.setString(2,d.getName());
			insdept.setString(3,d.getLocation());
			insdept.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public Department getDepartment(int deptid) {
		try {
			getdept.setInt(1, deptid);
			ResultSet rs = getdept.executeQuery();
			if(rs.next())
				return new Department(rs.getInt(1),rs.getString(2),rs.getString(3));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void UpdateDept(Department d) {
		try {
			uptdept.setInt(3, d.getId());
			uptdept.setString(1,d.getName());
			uptdept.setString(2,d.getLocation());
			uptdept.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void deleteDept(int deptid) {
		try {
			deldept.setInt(1, deptid);
			deldept.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
