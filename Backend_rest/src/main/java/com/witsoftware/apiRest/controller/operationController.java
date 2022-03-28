package com.witsoftware.apiRest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.witsoftware.apiRest.constant.RabbitmqConstant;
import com.witsoftware.apiRest.implementation.oparationImplementation;
import com.witsoftware.apiRest.service.RabbitmqService;

@RestController
public class operationController {
	
	@Autowired
	oparationImplementation operationImp;
	
	@Autowired
	private RabbitmqService rabbitmqService;
	
	@GetMapping(value="/sum")
	private HttpStatus Sum(@RequestParam double a, double b) {		
				
		String result = operationImp.Sum(a,b);
		
		this.rabbitmqService.enviaMsg(RabbitmqConstant.FILA_SOMA, result);
		
		return HttpStatus.OK;
	}
	
	@GetMapping(value="/sub")
	private HttpStatus Subtraction(@RequestParam int a, int b) {
		
		String result = operationImp.Subtraction(a,b);
		
		this.rabbitmqService.enviaMsg(RabbitmqConstant.FILA_SUB, result);
		
		return HttpStatus.OK;
	}
	
	@GetMapping(value="/mult")
	public HttpStatus Multiplication(@RequestParam int a, int b) {
		
		String result = operationImp.Multiplication(a,b);
		
		this.rabbitmqService.enviaMsg(RabbitmqConstant.FILA_MULT, result);
		
		return HttpStatus.OK;
	}
	@GetMapping(value="/div")
	public HttpStatus Division(@RequestParam int a, int b) {
		
		String result = operationImp.Division(a,b);
		
		this.rabbitmqService.enviaMsg(RabbitmqConstant.FILA_DIV, result);
		
		return HttpStatus.OK;
	}

}
