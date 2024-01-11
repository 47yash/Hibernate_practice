package com.demo.servlet;

import java.io.IOException;

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
 * Servlet implementation class DeleteDepartment
 */
@WebServlet("/deletedept")
public class DeleteDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int deptid = Integer.parseInt(request.getParameter("did"));
		DeptService dservice = new DeptServiceImpl();
		dservice.deleteDepartment(deptid);
		RequestDispatcher rd = request.getRequestDispatcher("departments");
		rd.forward(request, response);		
	}

}
