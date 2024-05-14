package com.chiara.calculator;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorLogicTest {

	@Test
	void testAddition() {
		//System.out.println("This test ran");
		CalculatorLogic calculatorLogic = new CalculatorLogic();
		double result = calculatorLogic.calculate(7, 2, '+');
		Assertions.assertEquals(9, result);
		
	}
	

	@Test
	void testSubtraction() {
		//System.out.println("This test ran");
		CalculatorLogic calculatorLogic = new CalculatorLogic();
		double result = calculatorLogic.calculate(7, 2, '-');
		Assertions.assertEquals(5, result);
		
	}
	

	@Test
	void testMultiplication() {
		//System.out.println("This test ran");
		CalculatorLogic calculatorLogic = new CalculatorLogic();
		double result = calculatorLogic.calculate(7, 2, '*');
		Assertions.assertEquals(14, result);
		
	}
	

	@Test
	void testDivision() {
		//System.out.println("This test ran");
		CalculatorLogic calculatorLogic = new CalculatorLogic();
		double result = calculatorLogic.calculate(10, 2, '/');
		Assertions.assertEquals(5, result);
		
	}
	@Test
    void testDivisionByZero() {
	    CalculatorLogic calculator = new CalculatorLogic();
	    try {
	        calculator.calculate(6, 0, '/');
	        Assertions.fail("Expected ArithmeticException was not thrown");
	    } catch (ArithmeticException e) {
	        // Expected exception thrown
	        Assertions.assertEquals("Division by zero!", e.getMessage());
	    }
	}
	

	
	@Test
	 void testInvalidOperator() {
	    CalculatorLogic calculator = new CalculatorLogic();
	    try {
	        calculator.calculate(6, 3, '.'); 
	        Assertions.fail("Expected IllegalArgumentException was not thrown");
	    } catch (IllegalArgumentException e) {
	        // Expected exception thrown
	        Assertions.assertEquals("Invalid operator", e.getMessage());
	    }
	}

}
