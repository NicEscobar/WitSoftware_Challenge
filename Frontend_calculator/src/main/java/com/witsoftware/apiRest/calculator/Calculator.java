package com.witsoftware.apiRest.calculator;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.witsoftware.apiRest.constant.RabbitmqConstant;

@Component
public class Calculator {
	
	@RabbitListener(queues = RabbitmqConstant.FILA_SOMA)
	private void Sum(String resultado) {
		
		System.out.print("RESULTADO SOMA:");
		System.out.print(resultado);
		
	}
	
	@RabbitListener(queues = RabbitmqConstant.FILA_SUB)
	private void Sub(String resultado) {
		
		System.out.print("RESULTADO SUBTRAÇÃO:");
		System.out.print(resultado);
		
	}
	
	@RabbitListener(queues = RabbitmqConstant.FILA_MULT)
	private void Muilt(String resultado) {
		
		System.out.print("RESULTADO MULTIPLICAÇÃO:");
		System.out.print(resultado);
		
	}
	
	@RabbitListener(queues = RabbitmqConstant.FILA_DIV)
	private void Div(String resultado) {
		
		System.out.print("RESULTADO DIVISÃO:");
		System.out.print(resultado);
		
	}

}
