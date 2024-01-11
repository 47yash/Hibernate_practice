package com.demo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.Department;
import com.demo.service.DeptService;
import com.demo.service.DeptServiceImpl;

/**
 * Servlet implementation class DisplayDepartment
 */
@WebServlet("/departments")
public class DisplayDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeptService dservice = new DeptServiceImpl();
		List<Department> dlist = dservice.getAllDept();
		request.setAttribute("list",dlist);
		RequestDispatcher rd = request.getRequestDispatcher("displaydept.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
