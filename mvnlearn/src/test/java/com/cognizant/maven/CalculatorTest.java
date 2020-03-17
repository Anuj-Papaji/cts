package com.cognizant.maven;
import com.cognizant.maven.Calculator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class CalculatorTest {
	
	private static Calculator calc = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		calc = new Calculator();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdd() {
		int a=5;
		int b=6;
		int expected = a+b;
		int actual = calc.add(a, b);
		assertEquals(expected, actual);
	}

	@Test
	public void testSub() {
		int a=5;
		
		int b=6;
		int expected = a-b;
		int actual = calc.sub(a, b);
		assertEquals(expected, actual);
	}

	@Test
	public void testMul() {
		int a=5;
		int b=6;
		int expected = a*b;
		int actual = calc.mul(a, b);
		assertEquals(expected, actual);
	}

	@Test
	public void testDiv() {
		int a=5;
		int b=6;
		int expected = a/b;
		int actual = calc.div(a, b);
		assertEquals(expected, actual);
	}

}
