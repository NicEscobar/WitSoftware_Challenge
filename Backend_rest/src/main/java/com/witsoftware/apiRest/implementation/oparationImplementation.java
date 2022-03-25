package com.witsoftware.apiRest.implementation;

import java.text.DecimalFormat;

import org.springframework.stereotype.Service;

import com.witsoftware.apiRest.interfaces.operationInterface;

@Service
public class oparationImplementation implements  operationInterface {

	DecimalFormat df = new DecimalFormat("#.##");
	
	@Override
	public String Sum(double a, double b) {
		
		double result = a + b;
		
		return df.format(result);
	}

	@Override
	public String Subtraction(double a, double b) {

		double result = a - b;
		
		return df.format(result);
	}

	@Override
	public String Multiplication(double a, double b) {
		
		double result = a * b;
		
		return df.format(result);
	}

	@Override
	public String Division(double a, double b) {
		
		double result = a / b;
		
		return df.format(result);
	}

	
}
