package com.witsoftware.apiRest.connections;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;


import com.witsoftware.apiRest.persistents.RabbitmqPersistents;


@Component
public class RabbitMQConnection {
	
	private static final String NOME_EXCHANGE = "amq.direct";
	
	private AmqpAdmin amqpAdmin;
	
	//Responsável por conectar ao RabbitMQ
	public RabbitMQConnection(AmqpAdmin amqpAdmin) {
		this.amqpAdmin = amqpAdmin;
	}

	
	private Queue fila(String queueName){
		
		return new Queue(queueName, true, false, false);
		
	}
	
	private DirectExchange trocaDireta() {
		
		return new DirectExchange(NOME_EXCHANGE);
		
	} 
	
	private Binding relacionamento(Queue fila, DirectExchange troca) {
		
		return new Binding(fila.getName(), Binding.DestinationType.QUEUE, troca.getName(), fila.getName(), null );
	}

	@PostConstruct
	private void aditions() {
		Queue filaSoma = this.fila(RabbitmqPersistents.FILA_SOMA);
		
		DirectExchange troca = this.trocaDireta();
		
		Binding ligacao = this.relacionamento(filaSoma, troca);
		
		//Criando as filas no RabbitMQ
		this.amqpAdmin.declareQueue(filaSoma);
		
		this.amqpAdmin.declareExchange(troca);
		
		this.amqpAdmin.declareBinding(ligacao);
	}
}
