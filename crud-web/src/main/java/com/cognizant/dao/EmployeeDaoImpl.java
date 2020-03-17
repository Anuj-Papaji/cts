package com.cognizant.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.cognizant.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private static List<Employee> list = new ArrayList<>(

			Arrays.asList(new Employee(101, "Mr. A", 5000.0), new Employee(101, "Mr. B", 15000.0),
					new Employee(101, "Mr. C", 25000.0), new Employee(101, "Mr. D", 35000.0),
					new Employee(101, "Mr. E", 45000.0), new Employee(101, "Mr. F", 55000.0),
					new Employee(101, "Mr. G", 65000.0), new Employee(101, "Mr. H", 75000.0),
					new Employee(101, "Mr. I", 85000.0), new Employee(101, "Mr. J", 95000.0))

	);

	public String create(Employee e) {
		if (list.add(e))
			return "SUCCESS";
		else
			return "FAIL";
	}

	public String update(Employee e) {
		Employee temp = null;
		for (Employee emp : list) {
			if (emp.getId() == e.getId()) {
				temp = emp;
			}
		}
		if (list.remove(temp) && list.add(e))
			return "SUCCESS";
		else
			return "FAIL";
	}

	public String delete(Employee e) {
		Employee temp = null;
		for (Employee emp : list) {
			if (emp.getId() == e.getId()) {
				temp = emp;
			}
		}
		if (list.remove(temp))
			return "SUCCESS";
		else
			return "FAIL";
	}

	public List<Employee> getAll() {
		return list;
	}

	public Employee getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
