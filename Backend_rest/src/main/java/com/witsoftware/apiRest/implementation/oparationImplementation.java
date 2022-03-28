package com.witsoftware.apiRest.implementation;

import java.text.DecimalFormat;

import org.springframework.stereotype.Service;

import com.witsoftware.apiRest.interfaces.operationInterface;

@Service
public class oparationImplementation implements  operationInterface {

	DecimalFormat df = new DecimalFormat("#.##");
	
	@Override
	public String Sum(double a, double b) {
		
		
		try {
				double result = a + b;
				
				return df.format(result);
			}
		catch(Exception e) {
			return e.getMessage();
		}
		
	}

	@Override
	public String Subtraction(double a, double b) {

		try {

			double result = a - b;
			
			return df.format(result);
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}

	@Override
	public String Multiplication(double a, double b) {
		
		try {
			double result = a * b;
			
			return df.format(result);
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}

	@Override
	public String Division(double a, double b) {
		
		try {
			if (b != 0) {
				double result = a / b;
				return df.format(result);
			}else
				return "O divisor não pode ser 0. Adicione outro valor";
							
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}

	
}
