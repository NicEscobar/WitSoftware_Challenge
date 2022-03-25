package com.witsoftware.apiRest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.witsoftware.apiRest.implementation.oparationImplementation;

@RestController
public class operationController {
	
	@Autowired
	oparationImplementation operationImp;
	
	@GetMapping(value="/sum")
	public String Sum(@RequestParam double a, double b) {		
				
		String result = operationImp.Sum(a,b);
		
		return result;
	}
	
	@GetMapping(value="/sub")
	public String Subtraction(@RequestParam int a, int b) {
		
		String result = operationImp.Subtraction(a,b);
		
		return result;
	}
	
	@GetMapping(value="/mult")
	public String Multiplication(@RequestParam int a, int b) {
		
		String result = operationImp.Multiplication(a,b);
		
		return result;
	}
	@GetMapping(value="/div")
	public String Division(@RequestParam int a, int b) {
		
		String result = operationImp.Division(a,b);
		
		return result;
	}

}
