package com.demo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.Department;
import com.demo.service.*;

/**
 * Servlet implementation class AddNewDepartment
 */
@WebServlet("/addnewdept")
public class AddNewDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int deptid = Integer.parseInt(request.getParameter("deptid"));
		String deptName = request.getParameter("deptname");
		String location = request.getParameter("location");
		Department d = new Department(deptid,deptName,location);
		DeptService dservice = new DeptServiceImpl();
		dservice.AddDepartment(d);
		RequestDispatcher rd = request.getRequestDispatcher("departments");
		rd.forward(request, response);
	}

}
