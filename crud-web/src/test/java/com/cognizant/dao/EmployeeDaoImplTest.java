package com.cognizant.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.cognizant.model.Employee;

public class EmployeeDaoImplTest {

	@Test
	public void testCreate() {
		EmployeeDao dao = new EmployeeDaoImpl();
		String res = dao.create(new Employee(500, "test", 500.12));

		assertNotNull(res);
		assertEquals("SUCCESS", res);

	}

	@Test
	public void testUpdate() {
		EmployeeDao dao = new EmployeeDaoImpl();
		String res = dao.update(new Employee(500, "test", 500.12));

		assertNotNull(res);
		assertEquals("SUCCESS", res);

	}

	@Test
	public void testDelete() {
		EmployeeDao dao = new EmployeeDaoImpl();
		String res = dao.delete(new Employee(500, "test", 500.12));

		assertNotNull(res);
		assertEquals("SUCCESS", res);

	}

	@Test
	public void testGatAll(){
		EmployeeDao dao= new EmployeeDaoImpl();
		List<Employee> list = dao.getAll();
			
		assertNotNull(list);
		
	}
}
