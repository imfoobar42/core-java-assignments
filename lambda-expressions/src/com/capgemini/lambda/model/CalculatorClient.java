package com.capgemini.lambda.model;

import com.capgemini.lambda.model.Calculator;;
public class CalculatorClient {

	public static void main(String[] args) {
		Calculator addition = (x,y)-> x+y;
		System.out.println(addition.calculate(56,458));
	}

}
