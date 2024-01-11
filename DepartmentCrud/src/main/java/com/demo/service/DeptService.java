package com.demo.service;

import java.util.List;

import com.demo.beans.Department;

public interface DeptService {

	List<Department> getAllDept();

	void AddDepartment(Department d);

	Department getDept(int deptid);

	void ModifyDept(Department d);

	void deleteDepartment(int deptid);

}
