package com.cognizant.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.dao.EmployeeDao;
import com.cognizant.dao.EmployeeDaoImpl;
import com.cognizant.model.Employee;

/**
 * Servlet implementation class EmployeeController
 */
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmployeeDao dao = new EmployeeDaoImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Read the request Param

		String action = request.getParameter("action");
		System.out.println("Action: " + action);

		if (action.equals("insert")) {
			// Preocess The Request
			insert(request, response);
		} else if (action.equals("update")) {
			// Preocess The Request
			update(request, response);
		} else if (action.equals("delete")) {
			// Preocess The Request
			delete(request, response);
		} else if (action.equals("getAll")) {
			// Preocess The Request
			getAll(request, response);
		} else {
			// Preocess The Request
		}

	}

	private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Invoking DAO
		List<Employee> list = dao.getAll();
		System.out.println(list);
		// Dispatch the request to show.jsp
		RequestDispatcher rd = request.getRequestDispatcher("show.jsp");
		// Add the data/Attribute to the request
		request.setAttribute("list", list);
		// Forward the request
		rd.forward(request, response);

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String res = dao.delete(new Employee(id));
		RequestDispatcher rd = request.getRequestDispatcher("insert.jsp");
		if (res.equals("SUCCESS")) {
			request.setAttribute("msg", "Record Deleted Successfully");
		} else {
			request.setAttribute("msg", "Record Deletion Fail");
		}
		rd.forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		double salary = Double.parseDouble(request.getParameter("salary"));
		String res = dao.update(new Employee(id, name, salary));
		RequestDispatcher rd = request.getRequestDispatcher("insert.jsp");
		if (res.equals("SUCCESS")) {
			request.setAttribute("msg", "Record Updateed Successfully");
		} else {
			request.setAttribute("msg", "Record Updation Fail");
		}
		rd.forward(request, response);
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		double salary = Double.parseDouble(request.getParameter("salary"));
		String res = dao.create(new Employee(id, name, salary));
		RequestDispatcher rd = request.getRequestDispatcher("insert.jsp");
		if (res.equals("SUCCESS")) {
			request.setAttribute("msg", "Record Inserted Successfully");
		} else {
			request.setAttribute("msg", "Record Insertion Fail");
		}
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
