package com.demo.service;

import java.util.List;

import com.demo.beans.Department;
import com.demo.dao.DeptDao;
import com.demo.dao.DeptDaoImpl;

public class DeptServiceImpl implements DeptService {
	private DeptDao ddao;
		
	public DeptServiceImpl(){
		super();
		this.ddao = new DeptDaoImpl();
	}

	@Override
	public List<Department> getAllDept() {
		return ddao.getAllDepartments();
	}

	@Override
	public void AddDepartment(Department d) {
		ddao.Adddept(d);
		
	}

	@Override
	public Department getDept(int deptid) {
		return ddao.getDepartment(deptid);
	}

	@Override
	public void ModifyDept(Department d) {
		ddao.UpdateDept(d);
		
	}

	@Override
	public void deleteDepartment(int deptid) {
		ddao.deleteDept(deptid);
	}
}
