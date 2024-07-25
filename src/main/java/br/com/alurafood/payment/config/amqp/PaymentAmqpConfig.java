package br.com.alurafood.payment.config.amqp;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class PaymentAmqpConfig {
	
	@Bean
	public Queue createRow() {
		//return new Queue("payment.check", false);
		
		return QueueBuilder.nonDurable("payment.check").build();
	}
	
	@Bean
	public RabbitAdmin createRabbitAdmin(ConnectionFactory connect) {
		return new RabbitAdmin(connect);
	}
	
	@Bean
	public ApplicationListener<ApplicationReadyEvent> startAdmin(RabbitAdmin admin){
		return event -> admin.initialize();
	}

}
