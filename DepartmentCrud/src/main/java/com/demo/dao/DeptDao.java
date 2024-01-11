package com.demo.dao;

import java.util.List;

import com.demo.beans.Department;

public interface DeptDao {

	List<Department> getAllDepartments();

	void Adddept(Department d);

	Department getDepartment(int deptid);

	void UpdateDept(Department d);

	void deleteDept(int deptid);

}
