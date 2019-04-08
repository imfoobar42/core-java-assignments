package com.capgemini.demo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.capgemini.demo.MathApplication;
import com.capgemini.demo.service.CalculatorService;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTest {

	@Mock
	private CalculatorService service;

	@InjectMocks
	MathApplication application = new MathApplication(service);

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testPerformAdditionWithTwoPositiveIntegers() {
		when(service.addition(6, 4)).thenReturn(10);
		assertEquals(10, application.performAddition(6, 4));
	}
	@Test
	public void testPerformAdditionWithOnePositiveandOneNegativeInteger() {
		when(service.addition(6, -8)).thenReturn(-2);
		assertEquals(-2, application.performAddition(6, -8));
	}
	@Test
	public void testPerformAdditionWithTwoNegativeInteger() {
		when(service.addition(-6, -8)).thenReturn(-14);
		assertEquals(-14, application.performAddition(-6, -8));
	}
	
	@Test
	public void testPerformMultiplicationWithTwoPositiveInteger() {
		when(service.multiplication(6, 7)).thenReturn(42);
		assertEquals(42, application.performMultiplication(6, 7));
	}
	@Test
	public void testPerformMultiplicationWithTwoNegativeInteger() {
		when(service.multiplication(-6, -7)).thenReturn(42);
		assertEquals(42, application.performMultiplication(-6, -7));
	}
	@Test
	public void testPerformMultiplicationWithOnePositiveAndOneNegativeInteger() {
		when(service.multiplication(6, -7)).thenReturn(-42);
		assertEquals(-42, application.performMultiplication(6, -7));
	}
	@Test
	public void testPerformMultiplicationWithZero() {
		when(service.multiplication(13, 0)).thenReturn(0);
		assertEquals(0, application.performMultiplication(13, 0));
	}

	@Test
	public void testFindFactorialWithPositiveInteger() {
		when(service.factorial(5)).thenReturn(120L);
		assertEquals(120, application.factorial(5));
	}
	@Test
	public void testFindFactorialWithZero() {
		when(service.factorial(0)).thenReturn(1L);
		assertEquals(1, application.factorial(0));
	}
	
	@Test(expected = ArithmeticException.class)
	public void testPerformDivisionWithDivisorZero() {
		doThrow(new ArithmeticException("/ by zero")).when(service).division(10, 0);
		application.performDivision(10, 0);
	}
	@Test
	public void testDivisionWithInteger() {
		when(service.division(20,10)).thenReturn(2);
		assertEquals(2, application.performDivision(20,10));
	}	
	@Test
	public void testDivisionWithANegativeInteger() {
		when(service.division(20,-10)).thenReturn(-2);
		assertEquals(-2, application.performDivision(20,-10));
	}
	
	@Test
	public void testPerformSquareOfANegativeNumber() {
		when(service.square(-10)).thenReturn(100L);
			assertEquals(100, application.findSquare(-10));
		}
	@Test
	public void testPerformSquareOfANumber() {
		when(service.square(5)).thenReturn(25L);
			assertEquals(25, application.findSquare(5));
		}
	}
